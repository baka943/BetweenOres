package baka943.betweenores.common.block;

import baka943.betweenores.client.core.handler.ModelHandler;
import baka943.betweenores.client.render.IModelRegister;
import baka943.betweenores.common.lib.LibMisc;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockMod extends Block implements IModelRegister {

    public BlockMod(Material material, String name) {
        super(material);
	    this.setTranslationKey(LibMisc.MOD_ID + "." + name);
        this.setRegistryName(new ResourceLocation(LibMisc.MOD_ID, name));
    }

    @Override
	@SideOnly(Side.CLIENT)
	public void registerModels() {
		if(Item.getItemFromBlock(this) != Items.AIR) {
			ModelHandler.registerInventoryVariant(this);
		}
	}

}
