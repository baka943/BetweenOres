package baka943.betweenores.common.world.gen;

import baka943.betweenores.common.BetweenOres;
import baka943.betweenores.common.block.ModBlocks;
import baka943.betweenores.common.config.OreConfig;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import thebetweenlands.common.registries.BlockRegistry;
import thebetweenlands.common.world.gen.feature.WorldGenBLMinable;

import java.util.Random;

public class OreGens implements IWorldGenerator {

    @Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if(!world.isRemote) {
	        int x = chunkX * 16 + rand.nextInt(16);
	        int z = chunkZ * 16 + rand.nextInt(16);

	        WorldGenBLMinable BE_IRON = new WorldGenBLMinable(ModBlocks.IRON_ORE.getDefaultState(), OreConfig.VANILLA_ORE.ironSize, BlockMatcher.forBlock(BlockRegistry.BETWEENSTONE));
	        for(int i = 0; i < OreConfig.VANILLA_ORE.ironPerChunk; i++) {
		        int y = getY(rand, OreConfig.VANILLA_ORE.ironMin, OreConfig.VANILLA_ORE.ironMax);
                BE_IRON.generate(world, rand, new BlockPos(x, y, z));
            }

            WorldGenBLMinable BE_GOLD = new WorldGenBLMinable(ModBlocks.GOLD_ORE.getDefaultState(), OreConfig.VANILLA_ORE.goldSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
            for(int i = 0; i < OreConfig.VANILLA_ORE.goldPerChunk; i++) {
                int y = getY(rand, OreConfig.VANILLA_ORE.goldMin, OreConfig.VANILLA_ORE.goldMax);
                BE_GOLD.generate(world, rand, new BlockPos(x, y, z));
            }

            WorldGenBLMinable BE_REDSTONE = new WorldGenBLMinable(ModBlocks.REDSTONE_ORE.getDefaultState(), OreConfig.VANILLA_ORE.redstoneSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
            for(int i = 0; i < OreConfig.VANILLA_ORE.redstonePerChunk; i++) {
                int y = getY(rand, OreConfig.VANILLA_ORE.redstoneMin, OreConfig.VANILLA_ORE.redstoneMax);
                BE_REDSTONE.generate(world, rand, new BlockPos(x, y, z));
            }

            WorldGenBLMinable BE_LAPIS = new WorldGenBLMinable(ModBlocks.LAPIS_ORE.getDefaultState(), OreConfig.VANILLA_ORE.lapisSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
            for(int i = 0; i < OreConfig.VANILLA_ORE.lapisPerChunk; i++) {
                int y = getY(rand, OreConfig.VANILLA_ORE.lapisMin, OreConfig.VANILLA_ORE.lapisMax);
                BE_LAPIS.generate(world, rand, new BlockPos(x, y, z));
            }

            WorldGenBLMinable BE_DIAMOND = new WorldGenBLMinable(ModBlocks.DIAMOND_ORE.getDefaultState(), OreConfig.VANILLA_ORE.diamondSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
            for(int i = 0; i < OreConfig.VANILLA_ORE.diamondPerChunk; i++) {
                int y = getY(rand, OreConfig.VANILLA_ORE.diamondMin, OreConfig.VANILLA_ORE.diamondMax);
                BE_DIAMOND.generate(world, rand, new BlockPos(x, y, z));
            }

            if(!BetweenOres.hasRealmTweaks) {
            	WorldGenBLMinable BE_COAL = new WorldGenBLMinable(ModBlocks.COAL_ORE.getDefaultState(), OreConfig.VANILLA_ORE.coalSize, BlockMatcher.forBlock(BlockRegistry.BETWEENSTONE));
            	for(int i = 0; i < OreConfig.VANILLA_ORE.coalPerChunk; i++) {
            		int y = getY(rand, OreConfig.VANILLA_ORE.coalMin, OreConfig.VANILLA_ORE.coalMax);
            		BE_COAL.generate(world, rand, new BlockPos(x, y, z));
	            }

            	WorldGenBLMinable BE_EMERALD = new WorldGenBLMinable(ModBlocks.EMERALD_ORE.getDefaultState(), OreConfig.VANILLA_ORE.emeraldSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
            	for(int i = 0; i < OreConfig.VANILLA_ORE.emeraldPerChunk; i++) {
            		int y = getY(rand, OreConfig.VANILLA_ORE.emeraldMin, OreConfig.VANILLA_ORE.emeraldMax);
            		BE_EMERALD.generate(world, rand, new BlockPos(x, y, z));
	            }

            	WorldGenBLMinable BE_QUARTZ = new WorldGenBLMinable(ModBlocks.QUARTZ_ORE.getDefaultState(), OreConfig.VANILLA_ORE.quartzSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
	            for(int i = 0; i < OreConfig.VANILLA_ORE.quartzPerChunk; i++) {
		            int y = getY(rand, OreConfig.VANILLA_ORE.quartzMin, OreConfig.VANILLA_ORE.quartzMax);
		            BE_QUARTZ.generate(world, rand, new BlockPos(x, y, z));
	            }
            }

            if(OreConfig.METAL_ORE.copperEnable) {
                WorldGenBLMinable BE_COPPER = new WorldGenBLMinable(ModBlocks.COPPER_ORE.getDefaultState(), OreConfig.METAL_ORE.copperSize, BlockMatcher.forBlock(BlockRegistry.BETWEENSTONE));
                for (int i = 0; i < OreConfig.METAL_ORE.copperPerChunk; i++) {
                    int y = getY(rand, OreConfig.METAL_ORE.copperMin, OreConfig.METAL_ORE.copperMax);
                    BE_COPPER.generate(world, rand, new BlockPos(x, y, z));
                }
            }

            if(OreConfig.METAL_ORE.tinEnable) {
                WorldGenBLMinable BE_TIN = new WorldGenBLMinable(ModBlocks.TIN_ORE.getDefaultState(), OreConfig.METAL_ORE.tinSize, BlockMatcher.forBlock(BlockRegistry.BETWEENSTONE));
                for (int i = 0; i < OreConfig.METAL_ORE.tinPerChunk; i++) {
                    int y = getY(rand, OreConfig.METAL_ORE.tinMin, OreConfig.METAL_ORE.tinMax);
                    BE_TIN.generate(world, rand, new BlockPos(x, y, z));
                }
            }

            if(OreConfig.METAL_ORE.leadEnable) {
                WorldGenBLMinable BE_LEAD = new WorldGenBLMinable(ModBlocks.LEAD_ORE.getDefaultState(), OreConfig.METAL_ORE.leadSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
                for (int i = 0; i < OreConfig.METAL_ORE.leadPerChunk; i++) {
                    int y = getY(rand, OreConfig.METAL_ORE.leadMin, OreConfig.METAL_ORE.leadMax);
                    BE_LEAD.generate(world, rand, new BlockPos(x, y, z));
                }
            }

            if(OreConfig.METAL_ORE.nickelEnable) {
                WorldGenBLMinable BE_NICKEL = new WorldGenBLMinable(ModBlocks.NICKEL_ORE.getDefaultState(), OreConfig.METAL_ORE.nickelSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
                for (int i = 0; i < OreConfig.METAL_ORE.nickelPerChunk; i++) {
                    int y = getY(rand, OreConfig.METAL_ORE.nickelMin, OreConfig.METAL_ORE.nickelMax);
                    BE_NICKEL.generate(world, rand, new BlockPos(x, y, z));
                }
            }

            if(OreConfig.METAL_ORE.silverEnable) {
                WorldGenBLMinable BE_SILVER = new WorldGenBLMinable(ModBlocks.SILVER_ORE.getDefaultState(), OreConfig.METAL_ORE.silverSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
                for (int i = 0; i < OreConfig.METAL_ORE.silverPerChunk; i++) {
                    int y = getY(rand, OreConfig.METAL_ORE.silverMin, OreConfig.METAL_ORE.silverMax);
                    BE_SILVER.generate(world, rand, new BlockPos(x, y, z));
                }
            }
        }
    }

    private int getY(Random rand, int min, int max) {
    	return rand.nextInt(max - min) + min;
    }

}
