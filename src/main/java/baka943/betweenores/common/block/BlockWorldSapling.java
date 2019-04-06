package baka943.betweenores.common.block;

import baka943.betweenores.client.core.handler.ModelHandler;
import baka943.betweenores.client.render.IModelRegister;
import baka943.betweenores.common.lib.LibMisc;
import net.minecraft.block.*;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.block.EnumBlock;
import thebetweenlands.client.tab.BLCreativeTabs;

import javax.annotation.Nonnull;
import java.util.Locale;
import java.util.Random;

public class BlockWorldSapling extends BlockBush implements IGrowable, IModelRegister {

	public static final PropertyEnum<SaplingType> VARIANT = PropertyEnum.create("variant", SaplingType.class);
	private static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.1D, 0.0D, 0.1D, 0.9D, 0.8D, 0.9D);

	private final String name;

	public BlockWorldSapling(String name) {
		this.name = name;
		this.setRegistryName(LibMisc.MOD_ID, name);
		this.setTranslationKey(LibMisc.MOD_ID + "." + name);
		this.setSoundType(SoundType.PLANT);
		this.setCreativeTab(BLCreativeTabs.PLANTS);
		this.setDefaultState(this.blockState.getBaseState());
	}

	public String getName() {
		return name;
	}

	public int getItemSubtypeAmount() {
		return 3;
	}

	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items) {
		for(int i = 0; i < getItemSubtypeAmount(); i++) {
			items.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		return this.getDefaultState().withProperty(VARIANT, SaplingType.values()[meta]);
	}

	@Override
	@SuppressWarnings("deprecation")
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, SaplingType.values()[meta / 2]).withProperty(BlockSapling.STAGE, meta % 2);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(VARIANT).ordinal() * 2 + state.getValue(BlockSapling.STAGE);
	}

	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(VARIANT).ordinal();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, VARIANT, BlockSapling.STAGE);
	}

	@Override
	@SuppressWarnings("deprecation")
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return SAPLING_AABB;
	}

	@Override
	public boolean canGrow(World world, BlockPos blockPos, IBlockState iBlockState, boolean b) {
		return false;
	}

	@Override
	public boolean canUseBonemeal(World world, Random random, BlockPos blockPos, IBlockState iBlockState) {
		return false;
	}

	@Override
	public void grow(World world, Random random, BlockPos blockPos, IBlockState iBlockState) {}

	public enum SaplingType implements IStringSerializable {
		ALTERNATE,
		ANOTHER,
		NIGHTMARE;

		@Override
		public String getName() {
			return this.toString().toLowerCase(Locale.ENGLISH);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels() {
		ModelLoader.setCustomStateMapper(this, new StateMap.Builder().ignore(BlockSapling.STAGE).build());

		Item item = Item.getItemFromBlock(this);
		SaplingType[] values = SaplingType.values();

		for(int i = 0; i < values.length; i++) {
			ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(new ResourceLocation(LibMisc.MOD_ID, "sapling_" + values[i].getName()), "inventory"));
		}
	}

}
