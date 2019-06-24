package baka943.betweenores.common.config;

import baka943.betweenores.common.lib.LibMisc;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.*;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = LibMisc.MOD_ID, category = "", name = LibMisc.MOD_ID)
@Mod.EventBusSubscriber(modid = LibMisc.MOD_ID)
public class OreConfig {

	private OreConfig() {
		throw new UnsupportedOperationException("No instance for you");
	}

	@SubscribeEvent
	public static void onConfigReload(ConfigChangedEvent.OnConfigChangedEvent event) {
		if(event.getModID().equals(LibMisc.MOD_ID)) {
			ConfigManager.sync(LibMisc.MOD_ID, Type.INSTANCE);
		}
	}

    @Ignore
    private static final String LANG_PREFIX = "config." + LibMisc.MOD_ID + ".";

	@Comment("Vanilla ores")
	@LangKey(LANG_PREFIX + "vanilla_ore")
    @Name("vanilla_ore")
    public static final VanillaOre VANILLA_ORE = new VanillaOre();

    public static final class VanillaOre {

        @Comment("Minimum height over which iron ore will spawn.")
		@LangKey(LANG_PREFIX + "iron_min")
	    @Name("iron_min")
	    @RangeInt(min = 0, max = 254)
	    @RequiresMcRestart
	    public int ironMin = 40;

		@Comment("Maximum height under which iron ore will spawn.")
		@LangKey(LANG_PREFIX + "iron_max")
	    @Name("iron_max")
	    @RangeInt(min = 1, max = 255)
	    @RequiresMcRestart
	    public int ironMax = 100;

	    @Comment("Maximum size of a iron ore vein (in blocks).")
	    @LangKey(LANG_PREFIX + "iron_size")
	    @Name("iron_size")
	    @RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int ironSize = 9;

	    @Comment("Number of attempts to spawn iron ore the world generator will make for each chunk.")
	    @LangKey(LANG_PREFIX + "iron_per_chunk")
	    @Name("iron_per_chunk")
	    @RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int ironPerChunk = 20;

	    @Comment("Minimum height over which gold ore will spawn.")
	    @LangKey(LANG_PREFIX + "gold_min")
	    @Name("gold_min")
		@RangeInt(min = 0, max = 254)
	    @RequiresMcRestart
	    public int goldMin = 0;

	    @Comment("Maximum height under which gold ore will spawn.")
	    @LangKey(LANG_PREFIX + "gold_max")
	    @Name("gold_max")
		@RangeInt(min = 1, max = 255)
	    @RequiresMcRestart
	    public int goldMax = 32;

	    @Comment("Maximum size of a gold ore vein (in blocks).")
	    @LangKey(LANG_PREFIX + "gold_size")
	    @Name("gold_size")
		@RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int goldSize = 9;

	    @Comment("Number of attempts to spawn gold ore the world generator will make for each chunk.")
	    @LangKey(LANG_PREFIX + "gold_per_chunk")
	    @Name("gold_per_chunk")
	    @RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int goldPerChunk = 2;

	    @Comment("Minimum height over which coal ore will spawn.")
	    @LangKey(LANG_PREFIX + "coal_min")
	    @Name("coal_min")
		@RangeInt(min = 0, max = 254)
	    @RequiresMcRestart
	    public int coalMin = 0;

	    @Comment("Maximum height under which coal ore will spawn.")
	    @LangKey(LANG_PREFIX + "coal_max")
	    @Name("coal_max")
		@RangeInt(min = 1, max = 255)
	    @RequiresMcRestart
	    public int coalMax = 100;

	    @Comment("Maximum size of a coal ore vein (in blocks).")
	    @LangKey(LANG_PREFIX + "coal_size")
		@Name("coal_size")
		@RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int coalSize = 9;

	    @Comment("Number of attempts to spawn coal ore the world generator will make for each chunk.")
	    @LangKey(LANG_PREFIX + "coal_per_chunk")
		@Name("coal_per_chunk")
		@RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int coalPerChunk = 20;

	    @Comment("Minimum height over which redstone ore will spawn.")
	    @LangKey(LANG_PREFIX + "redstone_min")
		@Name("redstone_min")
		@RangeInt(min = 0, max = 254)
	    @RequiresMcRestart
	    public int redstoneMin = 0;

	    @Comment("Maximum height under which redstone ore will spawn.")
	    @LangKey(LANG_PREFIX + "redstone_max")
		@Name("redstone_max")
		@RangeInt(min = 1, max = 255)
	    @RequiresMcRestart
	    public int redstoneMax = 18;

	    @Comment("Maximum size of a redstone ore vein (in blocks).")
	    @LangKey(LANG_PREFIX + "redstone_size")
		@Name("redstone_size")
		@RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int redstoneSize = 8;

	    @Comment("Number of attempts to spawn redstone ore the world generator will make for each chunk.")
	    @LangKey(LANG_PREFIX + "redstone_per_chunk")
		@Name("redstone_per_chunk")
		@RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int redstonePerChunk = 8;

	    @Comment("Minimum height over which lapis ore will spawn.")
	    @LangKey(LANG_PREFIX + "lapis_min")
		@Name("lapis_min")
		@RangeInt(min = 0, max = 254)
	    @RequiresMcRestart
	    public int lapisMin = 0;

	    @Comment("Maximum height under which lapis ore will spawn.")
	    @LangKey(LANG_PREFIX + "lapis_max")
		@Name("lapis_max")
		@RangeInt(min = 1, max = 255)
	    @RequiresMcRestart
	    public int lapisMax = 31;

	    @Comment("Maximum size of a lapis ore vein (in blocks).")
	    @LangKey(LANG_PREFIX + "lapis_size")
		@Name("lapis_size")
		@RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int lapisSize = 7;

	    @Comment("Number of attempts to spawn lapis ore the world generator will make for each chunk.")
	    @LangKey(LANG_PREFIX + "lapis_per_chunk")
		@Name("lapis_per_chunk")
		@RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int lapisPerChunk = 1;

	    @Comment("Minimum height over which diamond ore will spawn.")
	    @LangKey(LANG_PREFIX + "diamond_min")
		@Name("diamond_min")
		@RangeInt(min = 0, max = 254)
	    @RequiresMcRestart
	    public int diamondMin = 0;

	    @Comment("Maximum height under which diamond ore will spawn.")
	    @LangKey(LANG_PREFIX + "diamond_max")
		@Name("diamond_max")
		@RangeInt(min = 1, max = 255)
	    @RequiresMcRestart
	    public int diamondMax = 18;

	    @Comment("Maximum size of a diamond ore vein (in blocks).")
	    @LangKey(LANG_PREFIX + "diamond_size")
		@Name("diamond_size")
		@RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int diamondSize = 8;

	    @Comment("Number of attempts to spawn diamond ore the world generator will make for each chunk.")
	    @LangKey(LANG_PREFIX + "diamond_per_chunk")
		@Name("diamond_per_chunk")
		@RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int diamondPerChunk = 1;

	    @Comment("Minimum height over which emerald ore will spawn.")
	    @LangKey(LANG_PREFIX + "emerald_min")
		@Name("emerald_min")
		@RangeInt(min = 0, max = 254)
	    @RequiresMcRestart
	    public int emeraldMin = 0;

	    @Comment("Maximum height under which emerald ore will spawn.")
	    @LangKey(LANG_PREFIX + "emerald_max")
		@Name("emerald_max")
		@RangeInt(min = 1, max = 255)
	    @RequiresMcRestart
	    public int emeraldMax = 18;

	    @Comment("Maximum size of a emerald ore vein (in blocks).")
	    @LangKey(LANG_PREFIX + "emerald_size")
		@Name("emerald_size")
		@RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int emeraldSize = 2;

	    @Comment("Number of attempts to spawn emerald ore the world generator will make for each chunk.")
	    @LangKey(LANG_PREFIX + "emerald_per_chunk")
		@Name("emerald_per_chunk")
		@RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int emeraldPerChunk = 1;

	    @Comment("Minimum height over which quartz ore will spawn.")
	    @LangKey(LANG_PREFIX + "quartz_min")
		@Name("quartz_min")
		@RangeInt(min = 0, max = 254)
	    @RequiresMcRestart
	    public int quartzMin = 0;

	    @Comment("Maximum height under which quartz ore will spawn.")
	    @LangKey(LANG_PREFIX + "quartz_max")
		@Name("quartz_max")
		@RangeInt(min = 1, max = 255)
	    @RequiresMcRestart
	    public int quartzMax = 18;

	    @Comment("Maximum size of a quartz ore vein (in blocks).")
	    @LangKey(LANG_PREFIX + "quartz_size")
		@Name("quartz_size")
		@RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int quartzSize = 8;

	    @Comment("Number of attempts to spawn quartz ore the world generator will make for each chunk.")
	    @LangKey(LANG_PREFIX + "quartz_per_chunk")
		@Name("quartz_per_chunk")
		@RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int quartzPerChunk = 4;

    }

    @Comment("Metal Ores")
    @LangKey(LANG_PREFIX + "metal_ore")
    @Name("metal_ore")
    public static final MetalOre METAL_ORE = new MetalOre();

    public static final class MetalOre {

    	@Comment("If true, copper ore will generate in the Betweenlands.")
	    @LangKey(LANG_PREFIX + "copper_enable")
	    @Name("copper_enable")
	    @RequiresMcRestart
	    public boolean copperEnable = true;

	    @Comment("Minimum height over which copper ore will spawn.")
	    @LangKey(LANG_PREFIX + "copper_min")
	    @Name("copper_min")
	    @RangeInt(min = 0, max = 254)
	    @RequiresMcRestart
	    public int copperMin = 0;

	    @Comment("Maximum height under which copper ore will spawn.")
	    @LangKey(LANG_PREFIX + "copper_max")
	    @Name("copper_max")
	    @RangeInt(min = 1, max = 255)
	    @RequiresMcRestart
	    public int copperMax = 18;

	    @Comment("Maximum size of a copper ore vein (in blocks).")
	    @LangKey(LANG_PREFIX + "copper_size")
	    @Name("copper_size")
	    @RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int copperSize = 8;

	    @Comment("Number of attempts to spawn copper ore the world generator will make for each chunk.")
	    @LangKey(LANG_PREFIX + "copper_per_chunk")
	    @Name("copper_per_chunk")
	    @RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int copperPerChunk = 4;

    	@Comment("If true, tin ore will generate in the Betweenlands.")
	    @LangKey(LANG_PREFIX + "tin_enable")
	    @Name("tin_enable")
	    @RequiresMcRestart
	    public boolean tinEnable = true;

	    @Comment("Minimum height over which tin ore will spawn.")
	    @LangKey(LANG_PREFIX + "tin_min")
	    @Name("tin_min")
	    @RangeInt(min = 0, max = 254)
	    @RequiresMcRestart
	    public int tinMin = 0;

	    @Comment("Maximum height under which tin ore will spawn.")
	    @LangKey(LANG_PREFIX + "tin_max")
	    @Name("tin_max")
	    @RangeInt(min = 1, max = 255)
	    @RequiresMcRestart
	    public int tinMax = 18;

	    @Comment("Maximum size of a tin ore vein (in blocks).")
	    @LangKey(LANG_PREFIX + "tin_size")
	    @Name("tin_size")
	    @RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int tinSize = 8;

	    @Comment("Number of attempts to spawn tin ore the world generator will make for each chunk.")
	    @LangKey(LANG_PREFIX + "tin_per_chunk")
	    @Name("tin_per_chunk")
	    @RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int tinPerChunk = 4;

    	@Comment("If true, lead ore will generate in the Betweenlands.")
	    @LangKey(LANG_PREFIX + "lead_enable")
	    @Name("lead_enable")
	    @RequiresMcRestart
	    public boolean leadEnable = true;

	    @Comment("Minimum height over which lead ore will spawn.")
	    @LangKey(LANG_PREFIX + "lead_min")
	    @Name("lead_min")
	    @RangeInt(min = 0, max = 254)
	    @RequiresMcRestart
	    public int leadMin = 0;

	    @Comment("Maximum height under which lead ore will spawn.")
	    @LangKey(LANG_PREFIX + "lead_max")
	    @Name("lead_max")
	    @RangeInt(min = 1, max = 255)
	    @RequiresMcRestart
	    public int leadMax = 18;

	    @Comment("Maximum size of a lead ore vein (in blocks).")
	    @LangKey(LANG_PREFIX + "lead_size")
	    @Name("lead_size")
	    @RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int leadSize = 8;

	    @Comment("Number of attempts to spawn lead ore the world generator will make for each chunk.")
	    @LangKey(LANG_PREFIX + "lead_per_chunk")
	    @Name("lead_per_chunk")
	    @RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int leadPerChunk = 4;

    	@Comment("If true, nickel ore will generate in the Betweenlands.")
	    @LangKey(LANG_PREFIX + "nickel_enable")
	    @Name("nickel_enable")
	    @RequiresMcRestart
	    public boolean nickelEnable = true;

	    @Comment("Minimum height over which nickel ore will spawn.")
	    @LangKey(LANG_PREFIX + "nickel_min")
	    @Name("nickel_min")
	    @RangeInt(min = 0, max = 254)
	    @RequiresMcRestart
	    public int nickelMin = 0;

	    @Comment("Maximum height under which nickel ore will spawn.")
	    @LangKey(LANG_PREFIX + "nickel_max")
	    @Name("nickel_max")
	    @RangeInt(min = 1, max = 255)
	    @RequiresMcRestart
	    public int nickelMax = 18;

	    @Comment("Maximum size of a nickel ore vein (in blocks).")
	    @LangKey(LANG_PREFIX + "nickel_size")
	    @Name("nickel_size")
	    @RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int nickelSize = 8;

	    @Comment("Number of attempts to spawn nickel ore the world generator will make for each chunk.")
	    @LangKey(LANG_PREFIX + "nickel_per_chunk")
	    @Name("nickel_per_chunk")
	    @RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int nickelPerChunk = 4;

    	@Comment("If true, silver ore will generate in the Betweenlands.")
	    @LangKey(LANG_PREFIX + "silver_enable")
	    @Name("silver_enable")
	    @RequiresMcRestart
	    public boolean silverEnable = true;

	    @Comment("Minimum height over which silver ore will spawn.")
	    @LangKey(LANG_PREFIX + "silver_min")
	    @Name("silver_min")
	    @RangeInt(min = 0, max = 254)
	    @RequiresMcRestart
	    public int silverMin = 0;

	    @Comment("Maximum height under which silver ore will spawn.")
	    @LangKey(LANG_PREFIX + "silver_max")
	    @Name("silver_max")
	    @RangeInt(min = 1, max = 255)
	    @RequiresMcRestart
	    public int silverMax = 18;

	    @Comment("Maximum size of a silver ore vein (in blocks).")
	    @LangKey(LANG_PREFIX + "silver_size")
	    @Name("silver_size")
	    @RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int silverSize = 8;

	    @Comment("Number of attempts to spawn silver ore the world generator will make for each chunk.")
	    @LangKey(LANG_PREFIX + "silver_per_chunk")
	    @Name("silver_per_chunk")
	    @RangeInt(min = 0, max = 255)
	    @RequiresMcRestart
	    public int silverPerChunk = 4;

	}

	@Comment("Compatibility")
	@LangKey(LANG_PREFIX + "compatibility")
	@Name("compatibility")
	public static final Compatibility COMPATIBILITY = new Compatibility();

	public static final class Compatibility {

		@Comment("The priority sorted ModIDs for BetweenOres recipes to try using.")
		@LangKey(LANG_PREFIX + "mod_priority")
		@Name("mod_priority")
		@RequiresMcRestart
    	public String[] modPriority = new String[] {
    			"minecraft",
			    "thermalfoundation",
			    "substratum",
			    "ic2",
			    "mekanism",
			    "immersiveengineering",
			    "techreborn",
			    "embers"
    	};

	}

}
