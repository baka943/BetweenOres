package baka943.betweenores.common.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockBLRedstoneOre extends BlockMod {

	private boolean isOn;

	public BlockBLRedstoneOre(String name, boolean isOn) {
		super(Material.ROCK, name);
		this.setSoundType(SoundType.STONE);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setHarvestLevel("pickaxe", 2);

		if(isOn) {
			this.setTickRandomly(true);
			this.setLightLevel(0.625F);
		}

		this.isOn = isOn;
	}

	@Override
	public int tickRate(World worldIn) {
		return 30;
	}

	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		this.activate(worldIn, pos);
	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		this.activate(worldIn, pos);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		this.activate(worldIn, pos);
		return false;
	}

	private void activate(World worldIn, BlockPos pos) {
		this.spawnParticles(worldIn, pos);

		if(this == ModBlocks.betweenRedstoneOre) {
			worldIn.setBlockState(pos, ModBlocks.lit_betweenRedstoneOre.getDefaultState());
		}
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if(this == ModBlocks.lit_betweenRedstoneOre) {
			worldIn.setBlockState(pos, ModBlocks.betweenRedstoneOre.getDefaultState());
		}
	}

	@Nonnull
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.REDSTONE;
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, @Nonnull Random random) {
		return this.quantityDropped(random) + random.nextInt(fortune + 1);
	}

	@Override
	public int quantityDropped(Random random) {
		return 4 + random.nextInt(2);
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		if(this.getItemDropped(state, RANDOM, fortune) != Item.getItemFromBlock(this)) {
			return 1 + RANDOM.nextInt(5);
		}

		return 0;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if(this.isOn) {
			this.spawnParticles(worldIn, pos);
		}
	}

	private void spawnParticles(World worldIn, BlockPos pos) {
		Random random = worldIn.rand;

		for(int i = 0; i < 6; ++i) {
			double d1 = (double)((float)pos.getX() + random.nextFloat());
			double d2 = (double)((float)pos.getY() + random.nextFloat());
			double d3 = (double)((float)pos.getZ() + random.nextFloat());

			if(i == 0 && !worldIn.getBlockState(pos.up()).isOpaqueCube()) {
				d2 = (double)pos.getY() + 0.0625D + 1.0D;
			}

			if(i == 1 && !worldIn.getBlockState(pos.down()).isOpaqueCube()) {
				d2 = (double)pos.getY() - 0.0625D;
			}

			if(i == 2 && !worldIn.getBlockState(pos.south()).isOpaqueCube()) {
				d3 = (double)pos.getZ() + 0.0625D + 1.0D;
			}

			if(i == 3 && !worldIn.getBlockState(pos.north()).isOpaqueCube()) {
				d3 = (double)pos.getZ() - 0.0625D;
			}

			if(i == 4 && !worldIn.getBlockState(pos.east()).isOpaqueCube()) {
				d1 = (double)pos.getX() + 0.0625D + 1.0D;
			}

			if(i == 5 && !worldIn.getBlockState(pos.west()).isOpaqueCube()) {
				d1 = (double)pos.getX() - 0.0625D;
			}

			if(d1 < (double)pos.getX() || d1 > (double)(pos.getX() + 1) || d2 < 0.0D || d2 > (double)(pos.getY() + 1) || d3 < (double)pos.getZ() || d3 > (double)(pos.getZ() + 1)) {
				worldIn.spawnParticle(EnumParticleTypes.REDSTONE, d1, d2, d3, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@Nonnull
	@Override
	protected ItemStack getSilkTouchDrop(@Nonnull IBlockState state) {
		return new ItemStack(ModBlocks.betweenRedstoneOre);
	}

	@Nonnull
	@Override
	public ItemStack getPickBlock(@Nonnull IBlockState state, RayTraceResult target, @Nonnull World world, @Nonnull BlockPos pos, EntityPlayer player) {
		return new ItemStack(ModBlocks.betweenRedstoneOre);
	}

}
