package baka943.betweenores.common.block;

import baka943.betweenores.common.core.handler.ConfigHandler;
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
	public static final Block QUARTZ_ORE = new BlockOres("quartz_ore", 1);

	public static final Block REDSTONE_ORE = new BlockBLRedstoneOre("redstone_ore", false);
	public static final Block LIT_REDSTONE_ORE = new BlockBLRedstoneOre("lit_redstone_ore", true);

    public static final Block COPPER_ORE = new BlockOres("copper_ore", 1);
	public static final Block TIN_ORE = new BlockOres("tin_ore", 1);
	public static final Block LEAD_ORE = new BlockOres("lead_ore", 2);
	public static final Block NICKEL_ORE = new BlockOres("nickel_ore", 2);
	public static final Block SILVER_ORE = new BlockOres("silver_ore", 2);

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> evt) {
        IForgeRegistry<Block> r = evt.getRegistry();

        r.register(IRON_ORE);
        r.register(GOLD_ORE);
        r.register(LAPIS_ORE);
	    r.register(DIAMOND_ORE);
	    r.register(QUARTZ_ORE);
	    r.register(REDSTONE_ORE);
	    r.register(LIT_REDSTONE_ORE);

	    if(ConfigHandler.enableCopper) r.register(COPPER_ORE);

	    if(ConfigHandler.enableTin) r.register(TIN_ORE);

	    if(ConfigHandler.enableLead) r.register(LEAD_ORE);

	    if(ConfigHandler.enableNickel) r.register(NICKEL_ORE);

	    if(ConfigHandler.enableSilver) r.register(SILVER_ORE);
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> evt) {
        IForgeRegistry<Item> r = evt.getRegistry();

        r.register(new ItemBlock(IRON_ORE).setRegistryName(Utils.getRL("iron_ore")));
        r.register(new ItemBlock(GOLD_ORE).setRegistryName(Utils.getRL("gold_ore")));
	    r.register(new ItemBlock(LAPIS_ORE).setRegistryName(Utils.getRL("lapis_ore")));
	    r.register(new ItemBlock(DIAMOND_ORE).setRegistryName(Utils.getRL("diamond_ore")));
	    r.register(new ItemBlock(QUARTZ_ORE).setRegistryName(Utils.getRL("quartz_ore")));
	    r.register(new ItemBlock(REDSTONE_ORE).setRegistryName(Utils.getRL("redstone_ore")));

	    if(ConfigHandler.enableCopper) {
		    r.register(new ItemBlock(COPPER_ORE).setRegistryName(Utils.getRL("copper_ore")));
	    }
	    if(ConfigHandler.enableTin) {
		    r.register(new ItemBlock(TIN_ORE).setRegistryName(Utils.getRL("tin_ore")));
	    }
	    if(ConfigHandler.enableLead) {
		    r.register(new ItemBlock(LEAD_ORE).setRegistryName(Utils.getRL("lead_ore")));
	    }
	    if(ConfigHandler.enableNickel) {
		    r.register(new ItemBlock(NICKEL_ORE).setRegistryName(Utils.getRL("nickel_ore")));
	    }
	    if(ConfigHandler.enableSilver) {
		    r.register(new ItemBlock(SILVER_ORE).setRegistryName(Utils.getRL("silver_ore")));
	    }

        initOreDict();
    }

    private static void initOreDict() {
        OreDictionary.registerOre("oreIron", IRON_ORE);
        OreDictionary.registerOre("oreGold", GOLD_ORE);
        OreDictionary.registerOre("oreLapis", LAPIS_ORE);
	    OreDictionary.registerOre("oreDiamond", DIAMOND_ORE);
	    OreDictionary.registerOre("oreQuartz", QUARTZ_ORE);
	    OreDictionary.registerOre("oreRedstone", REDSTONE_ORE);

	    if(ConfigHandler.enableCopper) OreDictionary.registerOre("oreCopper", COPPER_ORE);

	    if(ConfigHandler.enableTin) OreDictionary.registerOre("oreTin", TIN_ORE);

	    if(ConfigHandler.enableLead) OreDictionary.registerOre("oreLead", LEAD_ORE);

	    if(ConfigHandler.enableNickel) OreDictionary.registerOre("oreNickel", NICKEL_ORE);

	    if(ConfigHandler.enableSilver) OreDictionary.registerOre("oreSilver", SILVER_ORE);
    }

}
