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
import thebetweenlands.client.tab.BLCreativeTabs;

public abstract class BlockMod extends Block implements IModelRegister {

    public BlockMod(Material material, String name) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(new ResourceLocation(LibMisc.MOD_ID, name));
        setCreativeTab(BLCreativeTabs.BLOCKS);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels() {
        if(Item.getItemFromBlock(this) != Items.AIR)
            ModelHandler.registerInventoryVariant(this);
    }

}
