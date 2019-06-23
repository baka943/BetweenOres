package baka943.betweenores.common.item;

import baka943.betweenores.common.lib.LibMisc;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = LibMisc.MOD_ID)
public class ModItems {

	public static final Item OCTINE_NUGGET = new ItemMod("octine_nugget");
	public static final Item SYRMORITE_NUGGET = new ItemMod("syrmorite_nugget");

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();

		registry.register(OCTINE_NUGGET);
		registry.register(SYRMORITE_NUGGET);

		initOreDict();
	}

	private static void initOreDict() {
		OreDictionary.registerOre("nuggetOctine", OCTINE_NUGGET);
		OreDictionary.registerOre("nuggetSyrmorite", SYRMORITE_NUGGET);
	}

}
