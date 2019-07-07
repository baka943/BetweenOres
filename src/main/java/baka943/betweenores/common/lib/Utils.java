package baka943.betweenores.common.lib;

import baka943.betweenores.common.config.OreConfig;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Iterator;
import java.util.List;

public class Utils {

	public static ResourceLocation getRL(String name) {
		return new ResourceLocation(LibMisc.MOD_ID, name);
	}

	public static ItemStack getStackFromOredict(String oredict) {
		int i = Integer.MAX_VALUE;
		List<ItemStack> items = OreDictionary.getOres(oredict, false);
		ItemStack stack = items.get(0);
		Iterator iterator = items.iterator();

		while(iterator.hasNext() && i == Integer.MAX_VALUE) {
			ItemStack item = (ItemStack) iterator.next();

			if(!item.isEmpty()) {
				String modid = item.getItem().getCreatorModId(item);

				for(int j = 0; j <= OreConfig.COMPAT.modPriority.length - 1; j++) {
					if(modid != null && modid.equals(OreConfig.COMPAT.modPriority[j])) {
						i = 0;
						stack = item;

						break;
					}
				}
			}
		}

		stack = stack.copy();

		if(!stack.isEmpty() && stack.getMetadata() == OreDictionary.WILDCARD_VALUE) {
			stack.setItemDamage(0);
		}

		return stack;
	}

}
