package baka943.betweenores.common.world.gen;

import baka943.betweenores.common.block.ModBlocks;
import baka943.betweenores.common.core.handler.ConfigHandler;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import thebetweenlands.common.registries.BlockRegistry;
import thebetweenlands.common.world.WorldProviderBetweenlands;
import thebetweenlands.common.world.gen.feature.WorldGenBLMinable;

import java.util.Random;

public class OreGens implements IWorldGenerator {

    @Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if(!world.isRemote) {
	        int x = chunkX * 16 + rand.nextInt(16);
	        int z = chunkZ * 16 + rand.nextInt(16);

	        WorldGenBLMinable BE_IRON = new WorldGenBLMinable(ModBlocks.IRON_ORE.getDefaultState(), ConfigHandler.ironVeinSize, BlockMatcher.forBlock(BlockRegistry.BETWEENSTONE));
	        for(int i = 0; i < ConfigHandler.ironVeinsPerChunk; i++) {
		        int y = rand.nextInt(ConfigHandler.ironMaxY - ConfigHandler.ironMinY) + ConfigHandler.ironMinY;
                BE_IRON.generate(world, rand, new BlockPos(x, y, z));
            }

            WorldGenBLMinable BE_GOLD = new WorldGenBLMinable(ModBlocks.GOLD_ORE.getDefaultState(), ConfigHandler.goldVeinSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
            for(int i = 0; i < ConfigHandler.goldVeinsPerChunk; i++) {
                int y = rand.nextInt(ConfigHandler.goldMaxY - ConfigHandler.goldMinY) + ConfigHandler.goldMinY;
                BE_GOLD.generate(world, rand, new BlockPos(x, y, z));
            }

            WorldGenBLMinable BE_REDSTONE = new WorldGenBLMinable(ModBlocks.REDSTONE_ORE.getDefaultState(), ConfigHandler.redstoneVeinSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
            for(int i = 0; i < ConfigHandler.redstoneVeinsPerChunk; i++) {
                int y = rand.nextInt(ConfigHandler.redstoneMaxY - ConfigHandler.redstoneMinY) + ConfigHandler.redstoneMinY;
                BE_REDSTONE.generate(world, rand, new BlockPos(x, y, z));
            }

            WorldGenBLMinable BE_LAPIS = new WorldGenBLMinable(ModBlocks.LAPIS_ORE.getDefaultState(), ConfigHandler.lapisVeinSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
            for(int i = 0; i < ConfigHandler.lapisVeinsPerChunk; i++) {
                int y = rand.nextInt(ConfigHandler.lapisMaxY - ConfigHandler.lapisMinY) + ConfigHandler.lapisMinY;
                BE_LAPIS.generate(world, rand, new BlockPos(x, y, z));
            }

            WorldGenBLMinable BE_DIAMOND = new WorldGenBLMinable(ModBlocks.DIAMOND_ORE.getDefaultState(), ConfigHandler.diamondVeinSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
            for(int i = 0; i < ConfigHandler.diamondVeinsPerChunk; i++) {
                int y = rand.nextInt(ConfigHandler.diamondMaxY - ConfigHandler.diamondMinY) + ConfigHandler.diamondMinY;
                BE_DIAMOND.generate(world, rand, new BlockPos(x, y, z));
            }

            WorldGenBLMinable BE_QUARTZ = new WorldGenBLMinable(ModBlocks.QUARTZ_ORE.getDefaultState(), ConfigHandler.quartzVeinSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
            for(int i = 0; i < ConfigHandler.quartzVeinsPerChunk; i++) {
                int y = rand.nextInt(ConfigHandler.quartzMaxY - ConfigHandler.quartzMinY) + ConfigHandler.quartzMinY;
                BE_QUARTZ.generate(world, rand, new BlockPos(x, y, z));
            }

            if(ConfigHandler.enableCopper) {
                WorldGenBLMinable BE_COPPER = new WorldGenBLMinable(ModBlocks.COPPER_ORE.getDefaultState(), ConfigHandler.copperVeinSize, BlockMatcher.forBlock(BlockRegistry.BETWEENSTONE));
                for (int i = 0; i < ConfigHandler.copperVeinsPerChunk; i++) {
                    int y = rand.nextInt(ConfigHandler.copperMaxY - ConfigHandler.copperMinY) + ConfigHandler.copperMinY;
                    BE_COPPER.generate(world, rand, new BlockPos(x, y, z));
                }
            }

            if(ConfigHandler.enableTin) {
                WorldGenBLMinable BE_TIN = new WorldGenBLMinable(ModBlocks.TIN_ORE.getDefaultState(), ConfigHandler.tinVeinSize, BlockMatcher.forBlock(BlockRegistry.BETWEENSTONE));
                for (int i = 0; i < ConfigHandler.tinVeinsPerChunk; i++) {
                    int y = rand.nextInt(ConfigHandler.tinMaxY - ConfigHandler.tinMinY) + ConfigHandler.tinMinY;
                    BE_TIN.generate(world, rand, new BlockPos(x, y, z));
                }
            }

            if(ConfigHandler.enableLead) {
                WorldGenBLMinable BE_LEAD = new WorldGenBLMinable(ModBlocks.LEAD_ORE.getDefaultState(), ConfigHandler.leadVeinSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
                for (int i = 0; i < ConfigHandler.leadVeinsPerChunk; i++) {
                    int y = rand.nextInt(ConfigHandler.leadMaxY - ConfigHandler.leadMinY) + ConfigHandler.leadMinY;
                    BE_LEAD.generate(world, rand, new BlockPos(x, y, z));
                }
            }

            if(ConfigHandler.enableNickel) {
                WorldGenBLMinable BE_NICKEL = new WorldGenBLMinable(ModBlocks.NICKEL_ORE.getDefaultState(), ConfigHandler.nickelVeinSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
                for (int i = 0; i < ConfigHandler.nickelVeinsPerChunk; i++) {
                    int y = rand.nextInt(ConfigHandler.nickelMaxY - ConfigHandler.nickelMinY) + ConfigHandler.nickelMinY;
                    BE_NICKEL.generate(world, rand, new BlockPos(x, y, z));
                }
            }

            if(ConfigHandler.enableSilver) {
                WorldGenBLMinable BE_SILVER = new WorldGenBLMinable(ModBlocks.SILVER_ORE.getDefaultState(), ConfigHandler.silverVeinSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
                for (int i = 0; i < ConfigHandler.silverVeinsPerChunk; i++) {
                    int y = rand.nextInt(ConfigHandler.silverMaxY - ConfigHandler.silverMinY) + ConfigHandler.silverMinY;
                    BE_SILVER.generate(world, rand, new BlockPos(x, y, z));
                }
            }
        }
    }

}
