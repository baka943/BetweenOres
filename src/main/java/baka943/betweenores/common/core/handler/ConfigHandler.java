package baka943.betweenores.common.core.handler;

import baka943.betweenores.common.lib.LibMisc;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigHandler {

    private static Configuration config;

    public static int ironMinY, ironMaxY, ironVeinSize, ironVeinsPerChunk;
    public static int goldMinY, goldMaxY, goldVeinSize, goldVeinsPerChunk;
    public static int redstoneMinY, redstoneMaxY, redstoneVeinSize, redstoneVeinsPerChunk;
    public static int lapisMinY, lapisMaxY, lapisVeinSize, lapisVeinsPerChunk;
    public static int diamondMinY, diamondMaxY, diamondVeinSize, diamondVeinsPerChunk;
    public static int quartzMinY, quartzMaxY, quartzVeinSize, quartzVeinsPerChunk;
    public static int copperMinY, copperMaxY, copperVeinSize, copperVeinsPerChunk;
    public static int leadMinY, leadMaxY, leadVeinSize, leadVeinsPerChunk;
    public static int nickelMinY, nickelMaxY, nickelVeinSize, nickelVeinsPerChunk;
    public static int silverMinY, silverMaxY, silverVeinSize, silverVeinsPerChunk;
    public static int tinMinY, tinMaxY, tinVeinSize, tinVeinsPerChunk;

    public static boolean enableCopper, enableLead, enableNickel, enableSilver, enableTin;

    public static boolean disableNether, disableStronghold;

    public static void init(File configFile) {
        if(config == null) {
            config = new Configuration(configFile);
            load();
        }
    }

    private static void load() {
    	//Ores
        config.addCustomCategoryComment("ores", "Settings related to ore generation");

        ironMinY = config.getInt("ironMinY", "ores", 40, 0, 254, "Minimum height over which iron ore will spawn.");
        ironMaxY = config.getInt("ironMaxY", "ores", 100, 1, 255, "Maximum height under which iron ore will spawn.");
        ironVeinSize = config.getInt("ironVeinSize", "ores", 9, 0, 255, "Maximum size of a iron ore vein (in blocks).");
        ironVeinsPerChunk = config.getInt("ironVeinsPerChunk", "ores", 20, 0, 255, "Number of attempts to spawn iron ore the world generator will make for each chunk.");

        goldMinY = config.getInt("goldMinY", "ores", 0, 0, 254, "Minimum height over which gold ore will spawn.");
        goldMaxY = config.getInt("goldMaxY", "ores", 32, 1, 255, "Maximum height under which gold ore will spawn.");
        goldVeinSize = config.getInt("goldVeinSize", "ores", 9, 0, 255, "Maximum size of a gold ore vein (in blocks).");
        goldVeinsPerChunk = config.getInt("goldVeinsPerChunk", "ores", 2, 0, 255, "Number of attempts to spawn gold ore the world generator will make for each chunk.");

        redstoneMinY = config.getInt("redstoneMinY", "ores", 0, 0, 254, "Minimum height over which redstone ore will spawn.");
        redstoneMaxY = config.getInt("redstoneMaxY", "ores", 18, 1, 255, "Maximum height under which redstone ore will spawn.");
        redstoneVeinSize = config.getInt("redstoneVeinSize", "ores", 8, 0, 255, "Maximum size of a redstone ore vein (in blocks).");
        redstoneVeinsPerChunk = config.getInt("redstoneVeinsPerChunk", "ores", 8, 0, 255, "Number of attempts to spawn redstone ore the world generator will make for each chunk.");

        lapisMinY = config.getInt("lapisMinY", "ores", 0, 0, 254, "Minimum height over which lapis ore will spawn.");
        lapisMaxY = config.getInt("lapisMaxY", "ores", 31, 1, 255, "Maximum height under which lapis ore will spawn.");
        lapisVeinSize = config.getInt("lapisVeinSize", "ores", 7, 0, 255, "Maximum size of a lapis ore vein (in blocks).");
        lapisVeinsPerChunk = config.getInt("lapisVeinsPerChunk", "ores", 1, 0, 255, "Number of attempts to spawn lapis ore the world generator will make for each chunk.");

        diamondMinY = config.getInt("diamondMinY", "ores", 0, 0, 254, "Minimum height over which diamond ore will spawn.");
        diamondMaxY = config.getInt("diamondMaxY", "ores", 18, 1, 255, "Maximum height under which diamond ore will spawn.");
        diamondVeinSize = config.getInt("diamondVeinSize", "ores", 8, 0, 255, "Maximum size of a diamond ore vein (in blocks).");
        diamondVeinsPerChunk = config.getInt("diamondVeinsPerChunk", "ores", 1, 0, 255, "Number of attempts to spawn diamond ore the world generator will make for each chunk.");

        quartzMinY = config.getInt("quartzMinY", "ores", 0, 0, 254, "Minimum height over which quartz ore will spawn.");
        quartzMaxY = config.getInt("quartzMaxY", "ores", 18, 1, 255, "Maximum height under which quartz ore will spawn.");
        quartzVeinSize = config.getInt("quartzVeinSize", "ores", 8, 0, 255, "Maximum size of a quartz ore vein (in blocks).");
        quartzVeinsPerChunk = config.getInt("quartzVeinsPerChunk", "ores", 4, 0, 255, "Number of attempts to spawn quartz ore the world generator will make for each chunk.");

        //Compat
        config.addCustomCategoryComment("compat", "Settings related to compatibility with other mods");

        enableCopper = config.getBoolean("copperEnable", "compat", true, "If true, copper ore will generate in the betweenlands.");
        copperMinY = config.getInt("copperMinY", "compat", 40, 0, 254, "Minimum height over which copper ore will spawn.");
        copperMaxY = config.getInt("copperMaxY", "compat", 100, 1, 255, "Maximum height under which copper ore will spawn.");
        copperVeinSize = config.getInt("copperVeinSize", "compat", 12, 0, 255, "Maximum size of a copper ore vein (in blocks).");
        copperVeinsPerChunk = config.getInt("copperVeinsPerChunk", "compat", 10, 0, 255, "Number of attempts to spawn copper ore the world generator will make for each chunk.");

        enableLead = config.getBoolean("leadEnable", "compat", true, "If true, lead ore will generate in the betweenlands.");
        leadMinY = config.getInt("leadMinY", "compat", 0, 0, 254, "Minimum height over which lead ore will spawn.");
        leadMaxY = config.getInt("leadMaxY", "compat", 28, 1, 255, "Maximum height under which lead ore will spawn.");
        leadVeinSize = config.getInt("leadVeinSize", "compat", 8, 0, 255, "Maximum size of a lead ore vein (in blocks).");
        leadVeinsPerChunk = config.getInt("leadVeinsPerChunk", "compat", 4, 0, 255, "Number of attempts to spawn lead ore the world generator will make for each chunk.");

        enableNickel = config.getBoolean("nickelEnable", "compat", true, "If true, nickel ore will generate in the betweenlands.");
        nickelMinY = config.getInt("nickelMinY", "compat", 0, 0, 254, "Minimum height over which nickel ore will spawn.");
        nickelMaxY = config.getInt("nickelMaxY", "compat", 24, 1, 255, "Maximum height under which nickel ore will spawn.");
        nickelVeinSize = config.getInt("nickelVeinSize", "compat", 6, 0, 255, "Maximum size of a nickel ore vein (in blocks).");
        nickelVeinsPerChunk = config.getInt("nickelVeinsPerChunk", "compat", 4, 0, 255, "Number of attempts to spawn nickel ore the world generator will make for each chunk.");

        enableSilver = config.getBoolean("silverEnable", "compat", true, "If true, silver ore will generate in the betweenlands.");
        silverMinY = config.getInt("silverMinY", "compat", 0, 0, 254, "Minimum height over which silver ore will spawn.");
        silverMaxY = config.getInt("silverMaxY", "compat", 28, 1, 255, "Maximum height under which silver ore will spawn.");
        silverVeinSize = config.getInt("silverVeinSize", "compat", 6, 0, 255, "Maximum size of a silver ore vein (in blocks).");
        silverVeinsPerChunk = config.getInt("silverVeinsPerChunk", "compat", 4, 0, 255, "Number of attempts to spawn silver ore the world generator will make for each chunk.");

        enableTin = config.getBoolean("tinEnable", "compat", true, "If true, tin ore will generate in the betweenlands.");
        tinMinY = config.getInt("tinMinY", "compat", 40, 0, 254, "Minimum height over which tin ore will spawn.");
        tinMaxY = config.getInt("tinMaxY", "compat", 100, 1, 255, "Maximum height under which tin ore will spawn.");
        tinVeinSize = config.getInt("tinVeinSize", "compat", 6, 0, 255, "Maximum size of a tin ore vein (in blocks).");
        tinVeinsPerChunk = config.getInt("tinVeinsPerChunk", "compat", 6, 0, 255, "Number of attempts to spawn tin ore the world generator will make for each chunk.");

        //Misc
	    config.addCustomCategoryComment("misc", "Something I want to achieve");

	    disableNether = config.getBoolean("disableNetherPortals", "misc", false, "If true, Disable the nether portals.");
	    disableStronghold = config.getBoolean("disableStronghold", "misc", false, "If true, Disable the Stronghold.");

        if(config.hasChanged()) {
            config.save();
        }
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if(event.getModID().equalsIgnoreCase(LibMisc.MOD_ID)) {
            load();
        }
    }

}
