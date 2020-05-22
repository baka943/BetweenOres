package baka943.betweenores.common.block;

import baka943.betweenores.common.config.OreConfig;
import baka943.betweenores.common.lib.LibMisc;
import baka943.betweenores.common.lib.Utils;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = LibMisc.MOD_ID)
public final class ModBlocks {

	public static final Block COAL_ORE = new BlockOres("coal_ore", 0);
	public static final Block IRON_ORE = new BlockOres("iron_ore", 1);
	public static final Block GOLD_ORE = new BlockOres("gold_ore", 2);
	public static final Block REDSTONE_ORE = new BlockBLRedstoneOre("redstone_ore", false);
	public static final Block LIT_REDSTONE_ORE = new BlockBLRedstoneOre("lit_redstone_ore", true);
	public static final Block LAPIS_ORE = new BlockOres("lapis_ore", 2);
	public static final Block DIAMOND_ORE = new BlockOres("diamond_ore", 2);
	public static final Block EMERALD_ORE = new BlockOres("emerald_ore", 2);
	public static final Block QUARTZ_ORE = new BlockOres("quartz_ore", 1);

    public static final Block COPPER_ORE = new BlockOres("copper_ore", 1);
	public static final Block TIN_ORE = new BlockOres("tin_ore", 1);
	public static final Block LEAD_ORE = new BlockOres("lead_ore", 2);
	public static final Block NICKEL_ORE = new BlockOres("nickel_ore", 2);
	public static final Block SILVER_ORE = new BlockOres("silver_ore", 2);
	public static final Block ALUMINUM_ORE = new BlockOres("aluminum_ore", 1);
	public static final Block PLATINUM_ORE = new BlockOres("platinum_ore", 3).setLightLevel(0.25F);
	public static final Block IRIDIUM_ORE = new BlockOres("iridium_ore", 3).setLightLevel(0.25F);
	public static final Block MITHRIL_ORE = new BlockOres("mithril_ore", 3).setLightLevel(0.5F);
	public static final Block URANIUM_ORE = new BlockOres("uranium_ore", 3);
	public static final Block OSMIUM_ORE = new BlockOres("osmium_ore", 0);
	public static final Block ARDITE_ORE = new BlockOres("ardite_ore", 4);
	public static final Block COBALT_ORE = new BlockOres("cobalt_ore", 5);

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();

	    registry.register(COAL_ORE);
	    registry.register(IRON_ORE);
	    registry.register(GOLD_ORE);
	    registry.register(REDSTONE_ORE);
	    registry.register(LIT_REDSTONE_ORE);
	    registry.register(LAPIS_ORE);
	    registry.register(DIAMOND_ORE);
	    registry.register(EMERALD_ORE);
	    registry.register(QUARTZ_ORE);

	    if(OreConfig.METAL_ORE.copperEnable) {
		    registry.register(COPPER_ORE);
	    }

	    if(OreConfig.METAL_ORE.tinEnable) {
		    registry.register(TIN_ORE);
	    }

	    if(OreConfig.METAL_ORE.leadEnable) {
		    registry.register(LEAD_ORE);
	    }

	    if(OreConfig.METAL_ORE.nickelEnable) {
		    registry.register(NICKEL_ORE);
	    }

	    if(OreConfig.METAL_ORE.silverEnable) {
		    registry.register(SILVER_ORE);
	    }

	    if(OreConfig.METAL_ORE.aluminumEnable) {
		    registry.register(ALUMINUM_ORE);
	    }

	    if(OreConfig.METAL_ORE.platinumEnable) {
		    registry.register(PLATINUM_ORE);
	    }

	    if(OreConfig.METAL_ORE.iridiumEnable) {
		    registry.register(IRIDIUM_ORE);
	    }

	    if(OreConfig.METAL_ORE.mithrilEnable) {
		    registry.register(MITHRIL_ORE);
	    }

	    if(OreConfig.METAL_ORE.uraniumEnable) {
		    registry.register(URANIUM_ORE);
	    }

	    if(OreConfig.METAL_ORE.osmiumEnable) {
		    registry.register(OSMIUM_ORE);
	    }

	    if(OreConfig.METAL_ORE.arditeEnable) {
	    	registry.register(ARDITE_ORE);
	    }

	    if(OreConfig.METAL_ORE.cobaltEnable) {
		    registry.register(COBALT_ORE);
	    }
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

	    registry.register(new ItemBlock(COAL_ORE).setRegistryName(Utils.getRL("coal_ore")));
	    registry.register(new ItemBlock(IRON_ORE).setRegistryName(Utils.getRL("iron_ore")));
	    registry.register(new ItemBlock(GOLD_ORE).setRegistryName(Utils.getRL("gold_ore")));
	    registry.register(new ItemBlock(REDSTONE_ORE).setRegistryName(Utils.getRL("redstone_ore")));
	    registry.register(new ItemBlock(LAPIS_ORE).setRegistryName(Utils.getRL("lapis_ore")));
	    registry.register(new ItemBlock(DIAMOND_ORE).setRegistryName(Utils.getRL("diamond_ore")));
	    registry.register(new ItemBlock(EMERALD_ORE).setRegistryName(Utils.getRL("emerald_ore")));
	    registry.register(new ItemBlock(QUARTZ_ORE).setRegistryName(Utils.getRL("quartz_ore")));

	    if(OreConfig.METAL_ORE.copperEnable) {
		    registry.register(new ItemBlock(COPPER_ORE).setRegistryName(Utils.getRL("copper_ore")));
	    }

	    if(OreConfig.METAL_ORE.tinEnable) {
		    registry.register(new ItemBlock(TIN_ORE).setRegistryName(Utils.getRL("tin_ore")));
	    }

	    if(OreConfig.METAL_ORE.leadEnable) {
		    registry.register(new ItemBlock(LEAD_ORE).setRegistryName(Utils.getRL("lead_ore")));
	    }

	    if(OreConfig.METAL_ORE.nickelEnable) {
		    registry.register(new ItemBlock(NICKEL_ORE).setRegistryName(Utils.getRL("nickel_ore")));
	    }

	    if(OreConfig.METAL_ORE.silverEnable) {
		    registry.register(new ItemBlock(SILVER_ORE).setRegistryName(Utils.getRL("silver_ore")));
	    }

	    if(OreConfig.METAL_ORE.aluminumEnable) {
		    registry.register(new ItemBlock(ALUMINUM_ORE).setRegistryName(Utils.getRL("aluminum_ore")));
	    }

	    if(OreConfig.METAL_ORE.platinumEnable) {
		    registry.register(new ItemBlock(PLATINUM_ORE) {

		    	@SuppressWarnings("deprecation")
			    @Nonnull
			    @Override
			    public EnumRarity getRarity(@Nonnull ItemStack stack) {
				    return EnumRarity.UNCOMMON;
			    }

		    }.setRegistryName(Utils.getRL("platinum_ore")));
	    }

	    if(OreConfig.METAL_ORE.iridiumEnable) {
		    registry.register(new ItemBlock(IRIDIUM_ORE) {

			    @SuppressWarnings("deprecation")
			    @Nonnull
			    @Override
			    public EnumRarity getRarity(@Nonnull ItemStack stack) {
				    return EnumRarity.UNCOMMON;
			    }

		    }.setRegistryName(Utils.getRL("iridium_ore")));
	    }

	    if(OreConfig.METAL_ORE.mithrilEnable) {
		    registry.register(new ItemBlock(MITHRIL_ORE) {

		    	@SuppressWarnings("deprecation")
			    @Nonnull
			    @Override
			    public EnumRarity getRarity(@Nonnull ItemStack stack) {
				    return EnumRarity.RARE;
			    }

		    }.setRegistryName(Utils.getRL("mithril_ore")));
	    }

	    if(OreConfig.METAL_ORE.uraniumEnable) {
		    registry.register(new ItemBlock(URANIUM_ORE).setRegistryName(Utils.getRL("uranium_ore")));
	    }

	    if(OreConfig.METAL_ORE.osmiumEnable) {
		    registry.register(new ItemBlock(OSMIUM_ORE).setRegistryName(Utils.getRL("osmium_ore")));
	    }

	    if(OreConfig.METAL_ORE.arditeEnable) {
		    registry.register(new ItemBlock(ARDITE_ORE).setRegistryName(Utils.getRL("ardite_ore")));
	    }

	    if(OreConfig.METAL_ORE.cobaltEnable) {
		    registry.register(new ItemBlock(COBALT_ORE).setRegistryName(Utils.getRL("cobalt_ore")));
	    }

	    initOreDict();
    }

    private static void initOreDict() {
	    OreDictionary.registerOre("oreCoal", COAL_ORE);
	    OreDictionary.registerOre("oreIron", IRON_ORE);
	    OreDictionary.registerOre("oreGold", GOLD_ORE);
	    OreDictionary.registerOre("oreRedstone", REDSTONE_ORE);
	    OreDictionary.registerOre("oreLapis", LAPIS_ORE);
	    OreDictionary.registerOre("oreDiamond", DIAMOND_ORE);
	    OreDictionary.registerOre("oreEmerald", EMERALD_ORE);
	    OreDictionary.registerOre("oreQuartz", QUARTZ_ORE);

	    if(OreConfig.METAL_ORE.copperEnable) {
		    OreDictionary.registerOre("oreCopper", COPPER_ORE);
	    }

	    if(OreConfig.METAL_ORE.tinEnable) {
		    OreDictionary.registerOre("oreTin", TIN_ORE);
	    }

	    if(OreConfig.METAL_ORE.leadEnable) {
		    OreDictionary.registerOre("oreLead", LEAD_ORE);
	    }

	    if(OreConfig.METAL_ORE.nickelEnable) {
		    OreDictionary.registerOre("oreNickel", NICKEL_ORE);
	    }

	    if(OreConfig.METAL_ORE.silverEnable) {
		    OreDictionary.registerOre("oreSilver", SILVER_ORE);
	    }

	    if(OreConfig.METAL_ORE.aluminumEnable) {
		    OreDictionary.registerOre("oreAluminum", ALUMINUM_ORE);
	    }

	    if(OreConfig.METAL_ORE.platinumEnable) {
		    OreDictionary.registerOre("orePlatinum", PLATINUM_ORE);
	    }

	    if(OreConfig.METAL_ORE.iridiumEnable) {
		    OreDictionary.registerOre("oreIridium", IRIDIUM_ORE);
	    }

	    if(OreConfig.METAL_ORE.mithrilEnable) {
		    OreDictionary.registerOre("oreMithril", MITHRIL_ORE);
	    }

	    if(OreConfig.METAL_ORE.uraniumEnable) {
		    OreDictionary.registerOre("oreUranium", URANIUM_ORE);
	    }

	    if(OreConfig.METAL_ORE.osmiumEnable) {
	    	OreDictionary.registerOre("oreOsmium", OSMIUM_ORE);
	    }

	    if(OreConfig.METAL_ORE.arditeEnable) {
	    	OreDictionary.registerOre("oreArdite", ARDITE_ORE);
	    }

	    if(OreConfig.METAL_ORE.cobaltEnable) {
	    	OreDictionary.registerOre("oreCobalt", COBALT_ORE);
	    }
    }

}
