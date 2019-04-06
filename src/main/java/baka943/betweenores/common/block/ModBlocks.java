package baka943.betweenores.common.block;

import baka943.betweenores.common.core.handler.ConfigHandler;
import baka943.betweenores.common.lib.LibMisc;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import slimeknights.mantle.item.ItemBlockMeta;
import thebetweenlands.client.tab.BLCreativeTabs;
import thebetweenlands.common.block.plant.BlockSaplingBetweenlands;
import thebetweenlands.common.world.gen.feature.tree.WorldGenWeedwoodTree;

@Mod.EventBusSubscriber(modid = LibMisc.MOD_ID)
public final class ModBlocks {

    public static final Block betweenIronOre = new BlockOres("iron_ore", 1);
    public static final Block betweenGoldOre = new BlockOres("gold_ore", 2);
    public static final Block betweenLapisOre = new BlockOres("lapis_ore", 2);
	public static final Block betweenDiamondOre = new BlockOres("diamond_ore", 2);
	public static final Block betweenQuartzOre = new BlockOres("quartz_ore", 1);

	public static final Block betweenRedstoneOre = new BlockBLRedstoneOre("redstone_ore", false).setCreativeTab(BLCreativeTabs.BLOCKS);
	public static final Block lit_betweenRedstoneOre = new BlockBLRedstoneOre("lit_redstone_ore", true);

    public static Block betweenCopperOre;
    public static Block betweenLeadOre;
    public static Block betweenNickelOre;
    public static Block betweenSilverOre;
    public static Block betweenTinOre;

    public static final BlockWorldSapling worldSapling = new BlockWorldSapling("world_sapling");

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> evt) {
        IForgeRegistry<Block> r = evt.getRegistry();

        r.register(betweenIronOre);
        r.register(betweenGoldOre);
        r.register(betweenLapisOre);
	    r.register(betweenDiamondOre);
	    r.register(betweenQuartzOre);

	    r.register(betweenRedstoneOre);
	    r.register(lit_betweenRedstoneOre);

	    if(ConfigHandler.enableCopper) {
		    r.register(betweenCopperOre = new BlockOres("copper_ore", 1));
	    }
	    if(ConfigHandler.enableLead) {
		    r.register(betweenLeadOre = new BlockOres("lead_ore", 2));
	    }
	    if(ConfigHandler.enableNickel) {
		    r.register(betweenNickelOre = new BlockOres("nickel_ore", 2));
	    }
	    if(ConfigHandler.enableSilver) {
		    r.register(betweenSilverOre = new BlockOres("silver_ore", 2));
	    }
	    if(ConfigHandler.enableTin) {
		    r.register(betweenTinOre = new BlockOres("tin_ore", 1));
	    }

		r.register(worldSapling);

    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> evt) {
        IForgeRegistry<Item> r = evt.getRegistry();

        r.register(new ItemBlock(betweenIronOre).setRegistryName(getRL("iron_ore")));
        r.register(new ItemBlock(betweenGoldOre).setRegistryName(getRL("gold_ore")));
	    r.register(new ItemBlock(betweenLapisOre).setRegistryName(getRL("lapis_ore")));
	    r.register(new ItemBlock(betweenDiamondOre).setRegistryName(getRL("diamond_ore")));
	    r.register(new ItemBlock(betweenQuartzOre).setRegistryName(getRL("quartz_ore")));

	    r.register(new ItemBlock(betweenRedstoneOre).setRegistryName(getRL("redstone_ore")));

	    if(ConfigHandler.enableCopper) {
		    r.register(new ItemBlock(betweenCopperOre).setRegistryName(getRL("copper_ore")));
	    }
	    if(ConfigHandler.enableLead) {
		    r.register(new ItemBlock(betweenLeadOre).setRegistryName(getRL("lead_ore")));
	    }
	    if(ConfigHandler.enableNickel) {
		    r.register(new ItemBlock(betweenNickelOre).setRegistryName(getRL("nickel_ore")));
	    }
	    if(ConfigHandler.enableSilver) {
		    r.register(new ItemBlock(betweenSilverOre).setRegistryName(getRL("silver_ore")));
	    }
	    if(ConfigHandler.enableTin) {
		    r.register(new ItemBlock(betweenTinOre).setRegistryName(getRL("tin_ore")));
	    }

	    r.register(new ItemBlock(worldSapling).setRegistryName(getRL("world_sapling")));

        initOreDict();
    }

    private static void initOreDict() {
        OreDictionary.registerOre("oreIron", betweenIronOre);
        OreDictionary.registerOre("oreGold", betweenGoldOre);
        OreDictionary.registerOre("oreLapis", betweenLapisOre);
	    OreDictionary.registerOre("oreDiamond", betweenDiamondOre);
	    OreDictionary.registerOre("oreQuartz", betweenQuartzOre);

	    OreDictionary.registerOre("oreRedstone", betweenRedstoneOre);

	    if(ConfigHandler.enableCopper) {
		    OreDictionary.registerOre("oreCopper", betweenCopperOre);
	    }
	    if(ConfigHandler.enableLead) {
		    OreDictionary.registerOre("oreLead", betweenLeadOre);
	    }
	    if(ConfigHandler.enableNickel) {
		    OreDictionary.registerOre("oreNickel", betweenNickelOre);
	    }
	    if(ConfigHandler.enableSilver) {
		    OreDictionary.registerOre("oreSilver", betweenSilverOre);
	    }
	    if(ConfigHandler.enableTin) {
		    OreDictionary.registerOre("oreTin", betweenTinOre);
	    }
    }

	private static ResourceLocation getRL(String name) {
		return new ResourceLocation(LibMisc.MOD_ID, name);
	}

}
