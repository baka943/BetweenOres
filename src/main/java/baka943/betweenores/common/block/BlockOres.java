package baka943.betweenores.common.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
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

    /**
     * Get the Item that this Block should drop when harvested.
     */
    @Nonnull
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if(this == ModBlocks.betweenDiamondOre) {
            return Items.DIAMOND;
        } else {
            return this == ModBlocks.betweenQuartzOre ? Items.QUARTZ : Item.getItemFromBlock(this);
        }
    }

    /**
     * Get the quantity dropped based on the given fortune level
     */
    public int quantityDroppedWithBonus(int fortune, @Nonnull Random rand) {
        if(fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getBlockState().getValidStates().iterator().next(), rand, fortune)) {
            int i = rand.nextInt(fortune + 2) - 1;

            if(i < 0) i = 0;

            return this.quantityDropped(rand) * (i + 1);
        } else {
            return this.quantityDropped(rand);
        }
    }

    /**
     * Spawns this Block's drops into the World as EntityItems.
     */
    public void dropBlockAsItemWithChance(World worldIn, @Nonnull BlockPos pos, @Nonnull IBlockState state, float chance, int fortune) {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        Random rand = new Random();
        if(this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
            int i = 0;

            if(this == ModBlocks.betweenDiamondOre) {
                i = MathHelper.getInt(rand, 3, 7);
            } else if(this == ModBlocks.betweenQuartzOre) {
                i = MathHelper.getInt(rand, 2, 5);
            }

            return i;
        }

        return 0;
    }

}
