package baka943.betweenores.common.core.handler;

import baka943.betweenores.common.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static baka943.betweenores.common.BetweenOres.thermalFoundationLoaded;

public class EventHandler {

	@SubscribeEvent
	public void onBlockCreate(BlockEvent.NeighborNotifyEvent event) {
		try {
			BlockPos pos = event.getPos();
			World world = event.getWorld();
			Block block = event.getState().getBlock();

			if(!world.isRemote && block == ModBlocks.SILVER_ORE) {
				for(EnumFacing facing : EnumFacing.VALUES) {
					Block blockIn = world.getBlockState(pos.toImmutable().offset(facing)).getBlock();

					if(thermalFoundationLoaded && FluidRegistry.isFluidRegistered("mana")) {
						Block fluid = FluidRegistry.getFluid("mana").getBlock();

						if(blockIn == fluid) {
							world.setBlockState(pos, ModBlocks.MITHRIL_ORE.getDefaultState());
						}
					}
				}
			}
		} catch(Throwable throwable) {
			System.out.println("NO!");
		}
	}

}
