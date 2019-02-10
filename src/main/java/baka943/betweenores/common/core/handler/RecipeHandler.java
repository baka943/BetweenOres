package baka943.betweenores.common.core.handler;

import baka943.betweenores.common.block.ModBlocks;
import baka943.betweenores.common.item.ModItems;
import baka943.betweenores.common.lib.LibMisc;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.registries.IForgeRegistry;
import thebetweenlands.common.registries.ItemRegistry;

@Mod.EventBusSubscriber(modid = LibMisc.MOD_ID)
public final class RecipeHandler {

	@SubscribeEvent
	public static void registerRecipes(RegistryEvent.Register<IRecipe> evt) {
		IForgeRegistry<IRecipe> r = evt.getRegistry();

		r.register(new ShapedOreRecipe(getRL("octine_nugget"), new ItemStack(ModItems.nuggetOctine, 9), true, new Object[] {
			"O",
			'O', "ingotOctine"}).setRegistryName(getRL("octine_nugget")));
		r.register(new ShapedOreRecipe(getRL("octine_ingot"), new ItemStack(ItemRegistry.OCTINE_INGOT), true, new Object[] {
			"ooo",
			"ooo",
			"ooo",
			'o', "nuggetOctine"}).setRegistryName(getRL("octine_ingot")));
		r.register(new ShapedOreRecipe(getRL("syrmorite_nugget"), new ItemStack(ModItems.nuggetSyrmorite, 9), true, new Object[] {
			"S",
			'S', "ingotSyrmorite"}).setRegistryName(getRL("syrmorite_nugget")));
		r.register(new ShapedOreRecipe(getRL("syrmorite_ingot"), new ItemStack(ItemRegistry.ITEMS_MISC, 1, 11), true, new Object[] {
			"sss",
			"sss",
			"sss",
			's', "nuggetSyrmorite"}).setRegistryName(getRL("syrmorite_ingot")));

		GameRegistry.addSmelting(new ItemStack(ModBlocks.betweenIronOre), new ItemStack(Items.IRON_INGOT), 0.7f);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.betweenGoldOre), new ItemStack(Items.GOLD_INGOT), 1.0f);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.betweenRedstoneOre), new ItemStack(Items.REDSTONE), 0.7f);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.betweenLapisOre), new ItemStack(Items.DYE, 1, 4), 0.2f);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.betweenDiamondOre), new ItemStack(Items.DIAMOND), 1.0f);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.betweenQuartzOre), new ItemStack(Items.QUARTZ), 0.2f);
	}

	public static ResourceLocation getRL(String name) {
		return new ResourceLocation(LibMisc.MOD_ID, name);
	}
}
