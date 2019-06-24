package baka943.betweenores.common.lib;

import baka943.betweenores.common.config.OreConfig;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

public class Utils {

	public static ResourceLocation getRL(String name) {
		return new ResourceLocation(LibMisc.MOD_ID, name);
	}

	public static ItemStack getStackFromOredict(String oredict) {
		ItemStack stack = ItemStack.EMPTY;
		int i = Integer.MAX_VALUE;

		List<ItemStack> items = OreDictionary.getOres(oredict, false);

		outer:
		for(ItemStack item : items) {
			if(!item.isEmpty()) {
				if(i == Integer.MAX_VALUE && stack.isEmpty()) {
					stack = item;
				}

				String modid = item.getItem().getCreatorModId(item);

				inner:
				for(int j = 0; j <= Math.min(i, OreConfig.COMPATIBILITY.modPriority.length - 1); j++) {
					if(modid.equals(OreConfig.COMPATIBILITY.modPriority[j])) {
						i = j;
						stack = item;

						if(i == 0) {
							break outer;
						}

						break inner;
					} else {
						stack = items.get(0);
					}
				}
			}
		}

		stack = ItemHandlerHelper.copyStackWithSize(stack, 1);

		if(!stack.isEmpty() && stack.getMetadata() == OreDictionary.WILDCARD_VALUE) {
			stack.setItemDamage(0);
		}

		return stack;
	}

}
