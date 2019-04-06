package baka943.betweenores.common.item;

import baka943.betweenores.common.block.ModBlocks;
import baka943.betweenores.common.lib.LibMisc;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = LibMisc.MOD_ID)
public class ModItems {

	public static final Item nuggetOctine = new ItemMod("octine_nugget");
	public static final Item nuggetSyrmorite = new ItemMod("syrmorite_nugget");

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> evt) {
		IForgeRegistry<Item> r = evt.getRegistry();

		r.register(nuggetOctine);
		r.register(nuggetSyrmorite);

		registerOreDictionary();
	}

	private static void registerOreDictionary() {
		OreDictionary.registerOre("nuggetOctine", nuggetOctine);
		OreDictionary.registerOre("nuggetSyrmorite", nuggetSyrmorite);
	}

}
