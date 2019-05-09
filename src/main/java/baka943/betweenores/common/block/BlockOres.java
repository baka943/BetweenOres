package baka943.betweenores.common.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import thebetweenlands.client.tab.BLCreativeTabs;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockOres extends BlockMod {

    BlockOres(String name, int level) {
        super(Material.ROCK, name);
        this.setSoundType(SoundType.STONE);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", level);
	    this.setCreativeTab(BLCreativeTabs.BLOCKS);
    }

    @Nonnull
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if(this == ModBlocks.DIAMOND_ORE) {
            return Items.DIAMOND;
        } else {
            return this == ModBlocks.QUARTZ_ORE ? Items.QUARTZ : Item.getItemFromBlock(this);
        }
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, @Nonnull Random rand) {
        if(fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getDefaultState(), rand, fortune)) {
	        int i = rand.nextInt(fortune + 1);

	        return i + 1;
        }

        return 1;
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
	    Random rand = new Random();

        if(this == ModBlocks.DIAMOND_ORE) {
            return rand.nextInt(4) + 3;
        } else {
	        return this == ModBlocks.QUARTZ_ORE ? rand.nextInt(3) + 2 : 0;
        }
    }

}
