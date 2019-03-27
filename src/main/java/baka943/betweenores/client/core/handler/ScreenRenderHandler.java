package baka943.betweenores.client.core.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.opengl.GL11;
import thebetweenlands.common.TheBetweenlands;
import thebetweenlands.common.herblore.book.widgets.text.FormatTags;
import thebetweenlands.common.herblore.book.widgets.text.TextContainer;
import thebetweenlands.common.world.storage.location.LocationStorage;
import thebetweenlands.util.ColorUtils;

import java.util.List;

import static thebetweenlands.client.handler.ScreenRenderHandler.TITLE_TEXTURE;
import static thebetweenlands.client.handler.ScreenRenderHandler.getVisibleLocations;

public class ScreenRenderHandler {

	private ScreenRenderHandler() {}

	public static ScreenRenderHandler INSTANCE = new ScreenRenderHandler();

	private TextContainer titleContainer = null;
	private String currentLocation = "";
	private int titleTicks = 0;
	private int maxTitleTicks = 120;

	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event) {
		if(event.phase == TickEvent.Phase.START && !Minecraft.getMinecraft().isGamePaused()) {
			if(this.titleTicks > 0) {
				this.titleTicks--;
			}

			EntityPlayer player = Minecraft.getMinecraft().player;

			if(player != null) {
				String prevLocation = this.currentLocation;

				List<LocationStorage> locations = getVisibleLocations(player);
				if(locations.isEmpty()) {
					String location = "";

					String overworldName = I18n.format("location.overworld.name");
					String underworldName = I18n.format("location.underworld.name");

					String netherName = I18n.format("location.nether.name");
					String lavaSeaName = I18n.format("location.lava_sea.name");

					String theEndName = I18n.format("location.the_end.name");
					String theVoidName = I18n.format("location.the_void.name");

					if(player.dimension == 0) {
						if(player.posY < 50) {
							if(this.currentLocation.equals(overworldName)) {
								prevLocation = "";
							}

							location = underworldName;
						} else {
							if(this.currentLocation.equals(underworldName)) {
								prevLocation = "";
							}

							location = overworldName;
						}

					} else if(player.dimension == -1) {
						if(player.posY < 33) {
							if(this.currentLocation.equals(netherName)) {
								prevLocation = "";
							}

							location = lavaSeaName;
						} else {
							if(this.currentLocation.equals(lavaSeaName)) {
								prevLocation = "";
							}

							location = netherName;
						}
					} else if(player.dimension == 1) {
						if(player.posY < 12) {
							if(this.currentLocation.equals(theEndName)) {
								prevLocation = "";
							}

							location = theVoidName;
						} else {
							if(this.currentLocation.equals(theVoidName)) {
								prevLocation = "";
							}

							location = theEndName;
						}
					}

					this.currentLocation = location;
				} else {
					LocationStorage highestLocation = null;

					for(LocationStorage storage : locations) {
						if(highestLocation == null || storage.getLayer() > highestLocation.getLayer()) {
							highestLocation = storage;
						}
					}

					int displayCooldown = 60*20; //1 minute cooldown for title

					if(highestLocation.getTitleDisplayCooldown(player) == 0) {
						highestLocation.setTitleDisplayCooldown(player, displayCooldown);
					} else if(highestLocation.getTitleDisplayCooldown(player) > 0) {
						if(highestLocation.hasLocalizedName()) {
							this.currentLocation = highestLocation.getLocalizedName();
						} else {
							this.currentLocation = highestLocation.getName();
						}

						highestLocation.setTitleDisplayCooldown(player, displayCooldown); //Keep cooldown up until player leaves location
					}
				}

				if(this.currentLocation.length() > 0) {
					if(this.currentLocation.contains(":")) {
						int startIndex = this.currentLocation.indexOf(":");

						try {
							String ticks = this.currentLocation.substring(0, startIndex);
							this.maxTitleTicks = Integer.parseInt(ticks);
							this.currentLocation = this.currentLocation.substring(startIndex+1, this.currentLocation.length());
						} catch(Exception ex) {
							this.maxTitleTicks = 80;
						}
					}

					if(prevLocation != null && !prevLocation.equals(this.currentLocation)) {
						this.titleTicks = this.maxTitleTicks;
						this.titleContainer = new TextContainer(2048, 2048, this.currentLocation, TheBetweenlands.proxy.getCustomFontRenderer());
						this.titleContainer.setCurrentScale(2.0f).setCurrentColor(0xFFFFFFFF);
						this.titleContainer.registerTag(new FormatTags.TagNewLine());
						this.titleContainer.registerTag(new FormatTags.TagScale(2.0F));
						this.titleContainer.registerTag(new FormatTags.TagSimple("bold", TextFormatting.BOLD));
						this.titleContainer.registerTag(new FormatTags.TagSimple("obfuscated", TextFormatting.OBFUSCATED));
						this.titleContainer.registerTag(new FormatTags.TagSimple("italic", TextFormatting.ITALIC));
						this.titleContainer.registerTag(new FormatTags.TagSimple("strikethrough", TextFormatting.STRIKETHROUGH));
						this.titleContainer.registerTag(new FormatTags.TagSimple("underline", TextFormatting.UNDERLINE));

						try {
							this.titleContainer.parse();
						} catch (Exception e) {
							this.titleContainer = null;
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
		int width = event.getResolution().getScaledWidth();
		int height = event.getResolution().getScaledHeight();

		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			if(this.titleTicks > 0 && this.titleContainer != null && !this.titleContainer.getPages().isEmpty()) {
				TextContainer.TextPage page = this.titleContainer.getPages().get(0);
				double strWidth = page.getTextWidth();
				double strHeight = page.getTextHeight();
				double strX = width / 2.0D - strWidth / 2.0F;
				double strY = height / 5.0D;

				GlStateManager.pushMatrix();
				GlStateManager.translate(strX, strY, 0);

				float fade = Math.min(1.0F, ((float)this.maxTitleTicks - (float)this.titleTicks) / Math.min(40.0F, this.maxTitleTicks - 5.0F) + 0.02F) - Math.max(0, (-this.titleTicks + 5) / 5.0F);

				GlStateManager.alphaFunc(GL11.GL_GREATER, 0.0F);
				GlStateManager.enableBlend();

				float averageScale = 0F;

				for(TextContainer.TextSegment segment : page.getSegments()) {
					GlStateManager.pushMatrix();
					GlStateManager.translate(segment.x, segment.y, 0.0D);
					GlStateManager.scale(segment.scale, segment.scale, 1.0F);

					float[] rgba = ColorUtils.getRGBA(segment.color);

					segment.font.drawString(segment.text, 0, 0, ColorUtils.toHex(rgba[0], rgba[1], rgba[2], rgba[3] * fade));
					GlStateManager.color(1, 1, 1, 1);
					GlStateManager.popMatrix();
					averageScale += segment.scale;
				}

				averageScale /= page.getSegments().size();

				GlStateManager.popMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(TITLE_TEXTURE);
				GlStateManager.color(1, 1, 1, fade);

				double sidePadding = 6;
				double yOffset = 5;
				double sy = Math.ceil(strY + strHeight - yOffset * averageScale);
				double ey = Math.ceil(strY + strHeight + (-yOffset + 16) * averageScale);
				Tessellator tessellator = Tessellator.getInstance();
				BufferBuilder buffer = tessellator.getBuffer();

				buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);

				this.renderTexturedRect(buffer, strX - sidePadding*averageScale, sy, strX - sidePadding*averageScale + 9*averageScale, ey, 0, 9 / 128.0D);
				this.renderTexturedRect(buffer, strX - sidePadding*averageScale + 9*averageScale, sy, strX + strWidth / 2.0D - 6*averageScale, ey, 9 / 128.0D, 58 / 128.0D);
				this.renderTexturedRect(buffer, strX + strWidth / 2.0D - 6*averageScale, sy, strX + strWidth / 2.0D + 6*averageScale, ey, 58 / 128.0D, 70 / 128.0D);
				this.renderTexturedRect(buffer, strX + strWidth / 2.0D + 6*averageScale, sy, strX + strWidth + sidePadding*averageScale - 9*averageScale, ey, 70 / 128.0D, 119 / 128.0D);
				this.renderTexturedRect(buffer, strX + strWidth + sidePadding*averageScale - 9*averageScale, sy, strX + strWidth + sidePadding*averageScale, ey, 119 / 128.0D, 1);
				tessellator.draw();
				GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1F);
			}
		}
	}

	private void renderTexturedRect(BufferBuilder buffer, double x, double y, double x2, double y2, double umin, double umax) {
		buffer.pos(x, y2, 0.0D).tex(umin, 1).endVertex();
		buffer.pos(x2, y2, 0.0D).tex(umax, 1).endVertex();
		buffer.pos(x2, y, 0.0D).tex(umax, 0).endVertex();
		buffer.pos(x, y, 0.0D).tex(umin, 0).endVertex();
	}

}
