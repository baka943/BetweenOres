package baka943.betweenores.common.block;

import baka943.betweenores.common.BetweenOres;
import baka943.betweenores.common.config.OreConfig;
import baka943.betweenores.common.lib.LibMisc;
import baka943.betweenores.common.lib.Utils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = LibMisc.MOD_ID)
public final class ModBlocks {

    public static final Block IRON_ORE = new BlockOres("iron_ore", 1);
    public static final Block GOLD_ORE = new BlockOres("gold_ore", 2);
    public static final Block LAPIS_ORE = new BlockOres("lapis_ore", 2);
	public static final Block DIAMOND_ORE = new BlockOres("diamond_ore", 2);

	public static final Block COAL_ORE = new BlockOres("coal_ore", 0);
	public static final Block EMERALD_ORE = new BlockOres("emerald_ore", 2);
	public static final Block QUARTZ_ORE = new BlockOres("quartz_ore", 1);

	public static final Block REDSTONE_ORE = new BlockBLRedstoneOre("redstone_ore", false);
	public static final Block LIT_REDSTONE_ORE = new BlockBLRedstoneOre("lit_redstone_ore", true);

    public static final Block COPPER_ORE = new BlockOres("copper_ore", 1);
	public static final Block TIN_ORE = new BlockOres("tin_ore", 1);
	public static final Block LEAD_ORE = new BlockOres("lead_ore", 2);
	public static final Block NICKEL_ORE = new BlockOres("nickel_ore", 2);
	public static final Block SILVER_ORE = new BlockOres("silver_ore", 2);

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();

        registry.register(IRON_ORE);
        registry.register(GOLD_ORE);
        registry.register(LAPIS_ORE);
	    registry.register(DIAMOND_ORE);
	    registry.register(REDSTONE_ORE);
	    registry.register(LIT_REDSTONE_ORE);

	    if(!BetweenOres.hasRealmTweaks) {
	    	registry.register(COAL_ORE);
		    registry.register(EMERALD_ORE);
		    registry.register(QUARTZ_ORE);
	    }

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
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        registry.register(new ItemBlock(IRON_ORE).setRegistryName(Utils.getRL("iron_ore")));
        registry.register(new ItemBlock(GOLD_ORE).setRegistryName(Utils.getRL("gold_ore")));
	    registry.register(new ItemBlock(LAPIS_ORE).setRegistryName(Utils.getRL("lapis_ore")));
	    registry.register(new ItemBlock(DIAMOND_ORE).setRegistryName(Utils.getRL("diamond_ore")));
	    registry.register(new ItemBlock(REDSTONE_ORE).setRegistryName(Utils.getRL("redstone_ore")));

	    if(!BetweenOres.hasRealmTweaks) {
		    registry.register(new ItemBlock(COAL_ORE).setRegistryName(Utils.getRL("coal_ore")));
		    registry.register(new ItemBlock(EMERALD_ORE).setRegistryName(Utils.getRL("emerald_ore")));
	    	registry.register(new ItemBlock(QUARTZ_ORE).setRegistryName(Utils.getRL("quartz_ore")));
	    }

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

        initOreDict();
    }

    private static void initOreDict() {
        OreDictionary.registerOre("oreIron", IRON_ORE);
        OreDictionary.registerOre("oreGold", GOLD_ORE);
        OreDictionary.registerOre("oreLapis", LAPIS_ORE);
	    OreDictionary.registerOre("oreDiamond", DIAMOND_ORE);
	    OreDictionary.registerOre("oreRedstone", REDSTONE_ORE);

	    if(!BetweenOres.hasRealmTweaks) {
		    OreDictionary.registerOre("oreCoal", COAL_ORE);
		    OreDictionary.registerOre("oreEmerald", EMERALD_ORE);
	    	OreDictionary.registerOre("oreQuartz", QUARTZ_ORE);
	    }

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
    }

}
