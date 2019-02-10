package baka943.betweenores.common.item;

import baka943.betweenores.client.render.IModelRegister;
import baka943.betweenores.common.lib.LibMisc;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thebetweenlands.client.tab.BLCreativeTabs;

public class ItemMod extends Item implements IModelRegister {
	public ItemMod(String name) {
		super();
		setUnlocalizedName(name);
		setRegistryName(new ResourceLocation(LibMisc.MOD_ID, name));
		setCreativeTab(BLCreativeTabs.ITEMS);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
