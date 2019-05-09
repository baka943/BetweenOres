package baka943.betweenores.common.core.handler;

import baka943.betweenores.common.block.ModBlocks;
import baka943.betweenores.common.lib.LibMisc;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber(modid = LibMisc.MOD_ID)
public final class RecipeHandler {

	@SubscribeEvent
	public static void registerRecipes(RegistryEvent.Register<IRecipe> evt) {
		//Smelting Ores
		GameRegistry.addSmelting(new ItemStack(ModBlocks.IRON_ORE), new ItemStack(Items.IRON_INGOT), 0.7F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.GOLD_ORE), new ItemStack(Items.GOLD_INGOT), 1.0F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.REDSTONE_ORE), new ItemStack(Items.REDSTONE), 0.7F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.LAPIS_ORE), new ItemStack(Items.DYE, 8, 4), 0.2F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.DIAMOND_ORE), new ItemStack(Items.DIAMOND), 1.0F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.QUARTZ_ORE), new ItemStack(Items.QUARTZ), 0.2F);
	}

}
