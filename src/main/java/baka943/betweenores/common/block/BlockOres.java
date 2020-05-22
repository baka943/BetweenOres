package baka943.betweenores.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidRegistry;
import thebetweenlands.client.tab.BLCreativeTabs;

import javax.annotation.Nonnull;
import java.util.Random;

import static baka943.betweenores.common.BetweenOres.thermalFoundationLoaded;

public class BlockOres extends BlockMod {

    BlockOres(String name, int level) {
        super(Material.ROCK, name);
        this.setSoundType(SoundType.STONE);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", level);
	    this.setCreativeTab(BLCreativeTabs.BLOCKS);
    }

	@SuppressWarnings("deprecation")
	@Override
	public void neighborChanged(@Nonnull IBlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull Block blockIn, @Nonnull BlockPos fromPos) {
		try {
			if(!worldIn.isRemote && this == ModBlocks.SILVER_ORE) {
				Block block = worldIn.getBlockState(fromPos).getBlock();

				if(thermalFoundationLoaded && FluidRegistry.isFluidRegistered("mana")) {
					Block fluid = FluidRegistry.getFluid("mana").getBlock();

					if(block == fluid) {
						worldIn.setBlockState(pos, ModBlocks.MITHRIL_ORE.getDefaultState());
					}
				}
			}
		} catch(Throwable throwable) {
			System.out.println("NO!");
		}
	}

	@Nonnull
    @Override
    public Item getItemDropped(@Nonnull IBlockState state, @Nonnull Random rand, int fortune) {
	    if(this == ModBlocks.COAL_ORE) {
	    	return Items.COAL;
	    } else if(this == ModBlocks.DIAMOND_ORE) {
            return Items.DIAMOND;
        } else if(this == ModBlocks.EMERALD_ORE) {
	    	return Items.EMERALD;
	    } else {
		    return this == ModBlocks.QUARTZ_ORE ? Items.QUARTZ : Item.getItemFromBlock(this);
	    }
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, @Nonnull Random rand) {
        int i = 0;

    	if(fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getDefaultState(), rand, fortune)) {
	        i = rand.nextInt(fortune + 1);
        }

        return i + 1;
    }

    @Override
    public int getExpDrop(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, int fortune) {
	    Random rand = new Random();

	    if(this == ModBlocks.COAL_ORE) {
	    	return rand.nextInt(2);
	    } else if(this == ModBlocks.DIAMOND_ORE) {
		    return rand.nextInt(4) + 3;
	    } else if(this == ModBlocks.EMERALD_ORE) {
	    	return rand.nextInt(4) + 3;
	    } else {
		    return this == ModBlocks.QUARTZ_ORE ? rand.nextInt(3) + 2 : 0;
	    }
    }

}
