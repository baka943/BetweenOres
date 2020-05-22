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

    	@Comment("If true, tin ore will generate in the Betweenlands.")
	    @LangKey(LANG_PREFIX + "tin_enable")
	    @Name("tin_enable")
	    @RequiresMcRestart
	    public boolean tinEnable = true;

    	@Comment("If true, lead ore will generate in the Betweenlands.")
	    @LangKey(LANG_PREFIX + "lead_enable")
	    @Name("lead_enable")
	    @RequiresMcRestart
	    public boolean leadEnable = true;

    	@Comment("If true, nickel ore will generate in the Betweenlands.")
	    @LangKey(LANG_PREFIX + "nickel_enable")
	    @Name("nickel_enable")
	    @RequiresMcRestart
	    public boolean nickelEnable = true;

    	@Comment("If true, silver ore will generate in the Betweenlands.")
	    @LangKey(LANG_PREFIX + "silver_enable")
	    @Name("silver_enable")
	    @RequiresMcRestart
	    public boolean silverEnable = true;

    	@Comment("If true, aluminum ore will generate in the Betweenlands.")
	    @LangKey(LANG_PREFIX + "aluminum_enable")
	    @Name("aluminum_enable")
	    @RequiresMcRestart
	    public boolean aluminumEnable = true;

    	@Comment("If true, platinum ore will generate in the Betweenlands.")
	    @LangKey(LANG_PREFIX + "platinum_enable")
	    @Name("platinum_enable")
	    @RequiresMcRestart
	    public boolean platinumEnable = true;

    	@Comment("If true, iridium ore will generate in the Betweenlands.")
	    @LangKey(LANG_PREFIX + "iridium_enable")
	    @Name("iridium_enable")
	    @RequiresMcRestart
	    public boolean iridiumEnable = true;

    	@Comment("If true, mithril ore will generate in the Betweenlands.")
	    @LangKey(LANG_PREFIX + "mithril_enable")
	    @Name("mithril_enable")
	    @RequiresMcRestart
	    public boolean mithrilEnable = true;

    	@Comment("If true, uranium ore will generate in the Betweenlands.")
	    @LangKey(LANG_PREFIX + "uranium_enable")
	    @Name("uranium_enable")
	    @RequiresMcRestart
	    public boolean uraniumEnable = true;

    	@Comment("If true, osmium ore will generate in the Betweenlands.")
	    @LangKey(LANG_PREFIX + "osmium_enable")
	    @Name("osmium_enable")
	    @RequiresMcRestart
	    public boolean osmiumEnable = true;

    	@Comment("If true, ardite ore will generate in the Betweenlands.")
	    @LangKey(LANG_PREFIX + "ardite_enable")
	    @Name("ardite_enable")
	    @RequiresMcRestart
	    public boolean arditeEnable = true;

    	@Comment("If true, cobalt ore will generate in the Betweenlands.")
	    @LangKey(LANG_PREFIX + "cobalt_enable")
	    @Name("cobalt_enable")
	    @RequiresMcRestart
	    public boolean cobaltEnable = true;

	}

	@Comment("Compat")
	@LangKey(LANG_PREFIX + "compat")
	@Name("compat")
	public static final Compat COMPAT = new Compat();

	public static final class Compat {

		@Comment("The priority sorted ModIDs for BetweenOres recipes to try using.")
		@LangKey(LANG_PREFIX + "mod_priority")
		@Name("mod_priority")
		@RequiresMcRestart
    	public String[] modPriority = new String[] {
			    "thermalfoundation",
			    "mekanism",
			    "immersiveengineering"
    	};

	}

}
