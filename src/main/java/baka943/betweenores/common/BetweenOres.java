package baka943.betweenores.common;

import baka943.betweenores.common.core.handler.EventHandler;
import baka943.betweenores.common.core.proxy.IProxy;
import baka943.betweenores.common.lib.LibMisc;
import baka943.betweenores.common.world.gen.OreGens;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = LibMisc.MOD_ID, name = LibMisc.MOD_NAME, version = LibMisc.VERSION, dependencies = LibMisc.DEPENDENCIES)
public class BetweenOres {

	public static boolean thermalFoundationLoaded = false;

    @Mod.Instance
    public static BetweenOres instance;

    @SidedProxy(serverSide = LibMisc.PROXY_SERVER, clientSide = LibMisc.PROXY_CLIENT)
    private static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	thermalFoundationLoaded = Loader.isModLoaded("thermalfoundation");

	    OreGens.addWorldGeneration();
    	proxy.preInit(event);
    }

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		proxy.init(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

}
