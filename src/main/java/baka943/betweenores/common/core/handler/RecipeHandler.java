package baka943.betweenores.common.core.handler;

import baka943.betweenores.common.block.ModBlocks;
import baka943.betweenores.common.config.OreConfig;
import baka943.betweenores.common.lib.LibMisc;
import baka943.betweenores.common.lib.Utils;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

@Mod.EventBusSubscriber(modid = LibMisc.MOD_ID)
public final class RecipeHandler {

	@SubscribeEvent
	public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
		GameRegistry.addSmelting(new ItemStack(ModBlocks.COAL_ORE), new ItemStack(Items.COAL), 0.1F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.IRON_ORE), new ItemStack(Items.IRON_INGOT), 0.7F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.GOLD_ORE), new ItemStack(Items.GOLD_INGOT), 1.0F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.REDSTONE_ORE), new ItemStack(Items.REDSTONE), 0.7F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.LAPIS_ORE), new ItemStack(Items.DYE, 8, 4), 0.2F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.DIAMOND_ORE), new ItemStack(Items.DIAMOND), 1.0F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.EMERALD_ORE), new ItemStack(Items.EMERALD), 1.0F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.QUARTZ_ORE), new ItemStack(Items.QUARTZ), 0.2F);

		if(OreConfig.METAL_ORE.copperEnable && OreDictionary.doesOreNameExist("ingotCopper")) {
			GameRegistry.addSmelting(new ItemStack(ModBlocks.COPPER_ORE), Utils.getStackFromOredict("ingotCopper"), 0.65F);
		}

		if(OreConfig.METAL_ORE.tinEnable && OreDictionary.doesOreNameExist("ingotTin")) {
			GameRegistry.addSmelting(new ItemStack(ModBlocks.TIN_ORE), Utils.getStackFromOredict("ingotTin"), 0.65F);
		}

		if(OreConfig.METAL_ORE.leadEnable && OreDictionary.doesOreNameExist("ingotLead")) {
			GameRegistry.addSmelting(new ItemStack(ModBlocks.LEAD_ORE), Utils.getStackFromOredict("ingotLead"), 0.65F);
		}

		if(OreConfig.METAL_ORE.nickelEnable && OreDictionary.doesOreNameExist("ingotNickel")) {
			GameRegistry.addSmelting(new ItemStack(ModBlocks.NICKEL_ORE), Utils.getStackFromOredict("ingotNickel"), 0.65F);
		}

		if(OreConfig.METAL_ORE.silverEnable && OreDictionary.doesOreNameExist("ingotSilver")) {
			GameRegistry.addSmelting(new ItemStack(ModBlocks.SILVER_ORE), Utils.getStackFromOredict("ingotSilver"), 0.65F);
		}

		if(OreConfig.METAL_ORE.aluminumEnable && OreDictionary.doesOreNameExist("ingotAluminum")) {
			GameRegistry.addSmelting(new ItemStack(ModBlocks.ALUMINUM_ORE), Utils.getStackFromOredict("ingotAluminum"), 0.65F);
		}

		if(OreConfig.METAL_ORE.platinumEnable && OreDictionary.doesOreNameExist("ingotPlatinum")) {
			GameRegistry.addSmelting(new ItemStack(ModBlocks.PLATINUM_ORE), Utils.getStackFromOredict("ingotPlatinum"), 0.65F);
		}

		if(OreConfig.METAL_ORE.iridiumEnable && OreDictionary.doesOreNameExist("ingotIridium")) {
			GameRegistry.addSmelting(new ItemStack(ModBlocks.IRIDIUM_ORE), Utils.getStackFromOredict("ingotIridium"), 0.65F);
		}

		if(OreConfig.METAL_ORE.mithrilEnable&& OreDictionary.doesOreNameExist("ingotMithril")) {
			GameRegistry.addSmelting(new ItemStack(ModBlocks.MITHRIL_ORE), Utils.getStackFromOredict("ingotMithril"), 0.65F);
		}

		if(OreConfig.METAL_ORE.uraniumEnable&& OreDictionary.doesOreNameExist("ingotUranium")) {
			GameRegistry.addSmelting(new ItemStack(ModBlocks.URANIUM_ORE), Utils.getStackFromOredict("ingotUranium"), 0.65F);
		}

		if(OreConfig.METAL_ORE.osmiumEnable&& OreDictionary.doesOreNameExist("ingotOsmium")) {
			GameRegistry.addSmelting(new ItemStack(ModBlocks.OSMIUM_ORE), Utils.getStackFromOredict("ingotOsmium"), 0.65F);
		}
	}

}
