package baka943.betweenores.common.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockOres extends BlockMod {

    BlockOres(String name, int level) {
        super(Material.ROCK, name);
        this.setSoundType(SoundType.STONE);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", level);
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    @Nonnull
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if (this == ModBlocks.betweenDiamondOre) {
            return Items.DIAMOND;
        } else if(this == ModBlocks.betweenRedstoneOre) {
            return Items.REDSTONE;
        } else if (this == ModBlocks.betweenLapisOre) {
            return Items.DYE;
        } else {
            return this == ModBlocks.betweenQuartzOre ? Items.QUARTZ : Item.getItemFromBlock(this);
        }
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random) {
        return this == ModBlocks.betweenLapisOre ? 4 + random.nextInt(5) : 1;
    }

    /**
     * Get the quantity dropped based on the given fortune level
     */
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getBlockState().getValidStates().iterator().next(), random, fortune)) {
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0) i = 0;

            return this.quantityDropped(random) * (i + 1);
        } else {
            return this.quantityDropped(random);
        }
    }

    /**
     * Spawns this Block's drops into the World as EntityItems.
     */
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
    }

    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
            int i = 0;

            if (this == ModBlocks.betweenDiamondOre) {
                i = MathHelper.getInt(rand, 3, 7);
            } else if(this == ModBlocks.betweenRedstoneOre) {
                i = MathHelper.getInt(rand, 2, 5);
            } else if (this == ModBlocks.betweenLapisOre) {
                i = MathHelper.getInt(rand, 2, 5);
            } else if (this == ModBlocks.betweenQuartzOre) {
                i = MathHelper.getInt(rand, 2, 5);
            }

            return i;
        }
        return 0;
    }

    /**
     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
    public int damageDropped(IBlockState state) {
        return this == ModBlocks.betweenLapisOre ? EnumDyeColor.BLUE.getDyeDamage() : 0;
    }

}
