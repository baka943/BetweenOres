package baka943.betweenores.common.block;

import baka943.betweenores.common.core.handler.ConfigHandler;
import baka943.betweenores.common.lib.LibBlockNames;
import baka943.betweenores.common.lib.LibMisc;
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

    public static final Block betweenIronOre = new BlockOres(LibBlockNames.BE_IRON_ORE, 1);
    public static final Block betweenGoldOre = new BlockOres(LibBlockNames.BE_GOLD_ORE, 2);
    public static final Block betweenRedstoneOre = new BlockOres(LibBlockNames.BE_REDSTONE_ORE, 2);
    public static final Block betweenLapisOre = new BlockOres(LibBlockNames.BE_LAPIS_ORE, 2);
    public static final Block betweenDiamondOre = new BlockOres(LibBlockNames.BE_DIAMOND_ORE, 2);
    public static final Block betweenQuartzOre = new BlockOres(LibBlockNames.BE_QUARTZ_ORE, 1);

    public static Block betweenCopperOre;
    public static Block betweenLeadOre;
    public static Block betweenNickelOre;
    public static Block betweenSilverOre;
    public static Block betweenTinOre;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> evt) {
        IForgeRegistry<Block> r = evt.getRegistry();

        r.register(betweenIronOre);
        r.register(betweenGoldOre);
        r.register(betweenRedstoneOre);
        r.register(betweenLapisOre);
        r.register(betweenDiamondOre);
        r.register(betweenQuartzOre);

        if(ConfigHandler.enableCopper)
            r.register(betweenCopperOre = new BlockOres(LibBlockNames.BE_COPPER_ORE, 1));
        if(ConfigHandler.enableLead)
            r.register(betweenLeadOre = new BlockOres(LibBlockNames.BE_LEAD_ORE, 2));
        if(ConfigHandler.enableNickel)
            r.register(betweenNickelOre = new BlockOres(LibBlockNames.BE_NICKEL_ORE, 2));
        if(ConfigHandler.enableSilver)
            r.register(betweenSilverOre = new BlockOres(LibBlockNames.BE_SILVER_ORE, 2));
        if(ConfigHandler.enableTin)
            r.register(betweenTinOre = new BlockOres(LibBlockNames.BE_TIN_ORE, 1));
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> evt) {
        IForgeRegistry<Item> r = evt.getRegistry();

        r.register(new ItemBlock(betweenIronOre).setRegistryName(LibBlockNames.RN_IRON_ORE));
        r.register(new ItemBlock(betweenGoldOre).setRegistryName(LibBlockNames.RN_GOLD_ORE));
        r.register(new ItemBlock(betweenRedstoneOre).setRegistryName(LibBlockNames.RN_REDSTONE_ORE));
        r.register(new ItemBlock(betweenLapisOre).setRegistryName(LibBlockNames.RN_LAPIS_ORE));
        r.register(new ItemBlock(betweenDiamondOre).setRegistryName(LibBlockNames.RN_DIAMOND_ORE));
        r.register(new ItemBlock(betweenQuartzOre).setRegistryName(LibBlockNames.RN_QUARTZ_ORE));

        if(ConfigHandler.enableCopper)
            r.register(new ItemBlock(betweenCopperOre).setRegistryName(LibBlockNames.RN_COPPER_ORE));
        if(ConfigHandler.enableLead)
            r.register(new ItemBlock(betweenLeadOre).setRegistryName(LibBlockNames.RN_LEAD_ORE));
        if(ConfigHandler.enableNickel)
            r.register(new ItemBlock(betweenNickelOre).setRegistryName(LibBlockNames.RN_NICKEL_ORE));
        if(ConfigHandler.enableSilver)
            r.register(new ItemBlock(betweenSilverOre).setRegistryName(LibBlockNames.RN_SILVER_ORE));
        if(ConfigHandler.enableTin)
            r.register(new ItemBlock(betweenTinOre).setRegistryName(LibBlockNames.RN_TIN_ORE));

        initOreDict();
    }

    private static void initOreDict() {
        OreDictionary.registerOre("oreIron", betweenIronOre);
        OreDictionary.registerOre("oreGold", betweenGoldOre);
        OreDictionary.registerOre("oreRedstone", betweenRedstoneOre);
        OreDictionary.registerOre("oreLapis", betweenLapisOre);
        OreDictionary.registerOre("oreDiamond", betweenDiamondOre);
        OreDictionary.registerOre("oreQuartz", betweenQuartzOre);

        if(ConfigHandler.enableCopper)
            OreDictionary.registerOre("oreCopper", betweenCopperOre);
        if(ConfigHandler.enableLead)
            OreDictionary.registerOre("oreLead", betweenLeadOre);
        if(ConfigHandler.enableNickel)
            OreDictionary.registerOre("oreNickel", betweenNickelOre);
        if(ConfigHandler.enableSilver)
            OreDictionary.registerOre("oreSilver", betweenSilverOre);
        if(ConfigHandler.enableTin)
            OreDictionary.registerOre("oreTin", betweenTinOre);
    }

}
