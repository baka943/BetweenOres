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
import thebetweenlands.client.tab.BLCreativeTabs;

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
		} else this.setCreativeTab(BLCreativeTabs.BLOCKS);

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

		if(this == ModBlocks.REDSTONE_ORE) {
			worldIn.setBlockState(pos, ModBlocks.LIT_REDSTONE_ORE.getDefaultState());
		}
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if(this == ModBlocks.LIT_REDSTONE_ORE) {
			worldIn.setBlockState(pos, ModBlocks.REDSTONE_ORE.getDefaultState());
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
		return 3 + random.nextInt(2);
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
		Random rand = worldIn.rand;
		double pixel = 0.0625D;

		for(int i = 0; i < 6; ++i) {
			double x = pos.getX() + rand.nextFloat();
			double y = pos.getY() + rand.nextFloat();
			double z = pos.getZ() + rand.nextFloat();

			if(i == 0 && !worldIn.getBlockState(pos.up()).isOpaqueCube()) {
				y = pos.getY() + 1 + pixel;
			}

			if(i == 1 && !worldIn.getBlockState(pos.down()).isOpaqueCube()) {
				y = pos.getY() - pixel;
			}

			if(i == 2 && !worldIn.getBlockState(pos.south()).isOpaqueCube()) {
				z = pos.getZ() + 1 + pixel;
			}

			if(i == 3 && !worldIn.getBlockState(pos.north()).isOpaqueCube()) {
				z = pos.getZ() - pixel;
			}

			if(i == 4 && !worldIn.getBlockState(pos.east()).isOpaqueCube()) {
				x = pos.getX() + 1 + pixel;
			}

			if(i == 5 && !worldIn.getBlockState(pos.west()).isOpaqueCube()) {
				x = pos.getX() - pixel;
			}

			if(x < pos.getX() || x > pos.getX() + 1 || y < pos.getY() || y > pos.getY() + 1 || z < pos.getZ() || z > pos.getZ() + 1) {
				worldIn.spawnParticle(EnumParticleTypes.REDSTONE, x, y, z, 0, 0, 0);
			}
		}
	}

	@Nonnull
	@Override
	protected ItemStack getSilkTouchDrop(@Nonnull IBlockState state) {
		return new ItemStack(ModBlocks.REDSTONE_ORE);
	}

	@Nonnull
	@Override
	public ItemStack getPickBlock(@Nonnull IBlockState state, RayTraceResult target, @Nonnull World world, @Nonnull BlockPos pos, EntityPlayer player) {
		return new ItemStack(ModBlocks.REDSTONE_ORE);
	}

}
