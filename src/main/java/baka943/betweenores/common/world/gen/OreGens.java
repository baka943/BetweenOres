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
import thebetweenlands.common.world.gen.feature.WorldGenBLMinable;

import java.util.Random;

public class OreGens implements IWorldGenerator {

    @Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if(!world.isRemote) {
            WorldGenBLMinable BE_IRON = new WorldGenBLMinable(ModBlocks.betweenIronOre.getDefaultState(), ConfigHandler.ironVeinSize, BlockMatcher.forBlock(BlockRegistry.BETWEENSTONE));
            for(int i = 0; i < ConfigHandler.ironVeinsPerChunk; i++) {
                int x = chunkX * 16 + rand.nextInt(16);
                int y = rand.nextInt(ConfigHandler.ironMaxY - ConfigHandler.ironMinY) + ConfigHandler.ironMinY;
                int z = chunkZ * 16 + rand.nextInt(16);
                BE_IRON.generate(world, rand, new BlockPos(x, y, z));
            }

            WorldGenBLMinable BE_GOLD = new WorldGenBLMinable(ModBlocks.betweenGoldOre.getDefaultState(), ConfigHandler.goldVeinSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
            for(int i = 0; i < ConfigHandler.goldVeinsPerChunk; i++) {
                int x = chunkX * 16 + rand.nextInt(16);
                int y = rand.nextInt(ConfigHandler.goldMaxY - ConfigHandler.goldMinY) + ConfigHandler.goldMinY;
                int z = chunkZ * 16 + rand.nextInt(16);
                BE_GOLD.generate(world, rand, new BlockPos(x, y, z));
            }

            WorldGenBLMinable BE_REDSTONE = new WorldGenBLMinable(ModBlocks.betweenRedstoneOre.getDefaultState(), ConfigHandler.redstoneVeinSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
            for(int i = 0; i < ConfigHandler.redstoneVeinsPerChunk; i++) {
                int x = chunkX * 16 + rand.nextInt(16);
                int y = rand.nextInt(ConfigHandler.redstoneMaxY - ConfigHandler.redstoneMinY) + ConfigHandler.redstoneMinY;
                int z = chunkZ * 16 + rand.nextInt(16);
                BE_REDSTONE.generate(world, rand, new BlockPos(x, y, z));
            }

            WorldGenBLMinable BE_LAPIS = new WorldGenBLMinable(ModBlocks.betweenLapisOre.getDefaultState(), ConfigHandler.lapisVeinSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
            for(int i = 0; i < ConfigHandler.lapisVeinsPerChunk; i++) {
                int x = chunkX * 16 + rand.nextInt(16);
                int y = rand.nextInt(ConfigHandler.lapisMaxY - ConfigHandler.lapisMinY) + ConfigHandler.lapisMinY;
                int z = chunkZ * 16 + rand.nextInt(16);
                BE_LAPIS.generate(world, rand, new BlockPos(x, y, z));
            }

            WorldGenBLMinable BE_DIAMOND = new WorldGenBLMinable(ModBlocks.betweenDiamondOre.getDefaultState(), ConfigHandler.diamondVeinSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
            for(int i = 0; i < ConfigHandler.diamondVeinsPerChunk; i++) {
                int x = chunkX * 16 + rand.nextInt(16);
                int y = rand.nextInt(ConfigHandler.diamondMaxY - ConfigHandler.diamondMinY) + ConfigHandler.diamondMinY;
                int z = chunkZ * 16 + rand.nextInt(16);
                BE_DIAMOND.generate(world, rand, new BlockPos(x, y, z));
            }

            WorldGenBLMinable BE_QUARTZ = new WorldGenBLMinable(ModBlocks.betweenQuartzOre.getDefaultState(), ConfigHandler.quartzVeinSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
            for(int i = 0; i < ConfigHandler.quartzVeinsPerChunk; i++) {
                int x = chunkX * 16 + rand.nextInt(16);
                int y = rand.nextInt(ConfigHandler.quartzMaxY - ConfigHandler.quartzMinY) + ConfigHandler.quartzMinY;
                int z = chunkZ * 16 + rand.nextInt(16);
                BE_QUARTZ.generate(world, rand, new BlockPos(x, y, z));
            }

            if(ConfigHandler.enableCopper) {
                WorldGenBLMinable BE_COPPER = new WorldGenBLMinable(ModBlocks.betweenCopperOre.getDefaultState(), ConfigHandler.copperVeinSize, BlockMatcher.forBlock(BlockRegistry.BETWEENSTONE));
                for (int i = 0; i < ConfigHandler.copperVeinsPerChunk; i++) {
                    int x = chunkX * 16 + rand.nextInt(16);
                    int y = rand.nextInt(ConfigHandler.copperMaxY - ConfigHandler.copperMinY) + ConfigHandler.copperMinY;
                    int z = chunkZ * 16 + rand.nextInt(16);
                    BE_COPPER.generate(world, rand, new BlockPos(x, y, z));
                }
            }

            if(ConfigHandler.enableTin) {
                WorldGenBLMinable BE_TIN = new WorldGenBLMinable(ModBlocks.betweenTinOre.getDefaultState(), ConfigHandler.tinVeinSize, BlockMatcher.forBlock(BlockRegistry.BETWEENSTONE));
                for (int i = 0; i < ConfigHandler.tinVeinsPerChunk; i++) {
                    int x = chunkX * 16 + rand.nextInt(16);
                    int y = rand.nextInt(ConfigHandler.tinMaxY - ConfigHandler.tinMinY) + ConfigHandler.tinMinY;
                    int z = chunkZ * 16 + rand.nextInt(16);
                    BE_TIN.generate(world, rand, new BlockPos(x, y, z));
                }
            }

            if(ConfigHandler.enableLead) {
                WorldGenBLMinable BE_LEAD = new WorldGenBLMinable(ModBlocks.betweenLeadOre.getDefaultState(), ConfigHandler.leadVeinSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
                for (int i = 0; i < ConfigHandler.leadVeinsPerChunk; i++) {
                    int x = chunkX * 16 + rand.nextInt(16);
                    int y = rand.nextInt(ConfigHandler.leadMaxY - ConfigHandler.leadMinY) + ConfigHandler.leadMinY;
                    int z = chunkZ * 16 + rand.nextInt(16);
                    BE_LEAD.generate(world, rand, new BlockPos(x, y, z));
                }
            }

            if(ConfigHandler.enableNickel) {
                WorldGenBLMinable BE_NICKEL = new WorldGenBLMinable(ModBlocks.betweenNickelOre.getDefaultState(), ConfigHandler.nickelVeinSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
                for (int i = 0; i < ConfigHandler.nickelVeinsPerChunk; i++) {
                    int x = chunkX * 16 + rand.nextInt(16);
                    int y = rand.nextInt(ConfigHandler.nickelMaxY - ConfigHandler.nickelMinY) + ConfigHandler.nickelMinY;
                    int z = chunkZ * 16 + rand.nextInt(16);
                    BE_NICKEL.generate(world, rand, new BlockPos(x, y, z));
                }
            }

            if(ConfigHandler.enableSilver) {
                WorldGenBLMinable BE_SILVER = new WorldGenBLMinable(ModBlocks.betweenSilverOre.getDefaultState(), ConfigHandler.silverVeinSize, BlockMatcher.forBlock(BlockRegistry.PITSTONE));
                for (int i = 0; i < ConfigHandler.silverVeinsPerChunk; i++) {
                    int x = chunkX * 16 + rand.nextInt(16);
                    int y = rand.nextInt(ConfigHandler.silverMaxY - ConfigHandler.silverMinY) + ConfigHandler.silverMinY;
                    int z = chunkZ * 16 + rand.nextInt(16);
                    BE_SILVER.generate(world, rand, new BlockPos(x, y, z));
                }
            }
        }
    }

}
