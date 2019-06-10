package baka943.betweenores.common.item;

import baka943.betweenores.client.render.IModelRegister;
import baka943.betweenores.common.lib.LibMisc;
import baka943.betweenores.common.lib.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thebetweenlands.client.tab.BLCreativeTabs;

public class ItemMod extends Item implements IModelRegister {

	public ItemMod(String name) {
		super();
		this.setRegistryName(Utils.getRL(name));
		this.setTranslationKey(LibMisc.MOD_ID + "." + name);
		this.setCreativeTab(BLCreativeTabs.ITEMS);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}
