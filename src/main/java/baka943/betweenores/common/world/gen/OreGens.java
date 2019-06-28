package baka943.betweenores.common.world.gen;

import baka943.betweenores.common.lib.LibMisc;
import cofh.core.init.CoreProps;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.core.util.Loader;

import java.io.File;

public class OreGens {

    public static void addWorldGeneration() {
    	String worldGenPath = "assets/" + LibMisc.MOD_ID + "/world/";
	    String worldGenOre = "between_ores.json";

	    File worldGenFile = new File(CoreProps.configDir, "/cofh/world/" + worldGenOre);

	    if(!worldGenFile.exists()) {
	    	try {
	    		worldGenFile.createNewFile();
			    FileUtils.copyInputStreamToFile(Loader.getResource(worldGenPath + worldGenOre, null).openStream(), worldGenFile);
		    } catch(Throwable error) {
	    		error.printStackTrace();
		    }
	    }
    }

}
