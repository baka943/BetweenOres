package baka943.betweenores.common;

import baka943.betweenores.common.core.proxy.IProxy;
import baka943.betweenores.common.lib.LibMisc;
import baka943.betweenores.common.world.gen.OreGens;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = LibMisc.MOD_ID, name = LibMisc.MOD_NAME, version = LibMisc.VERSION, dependencies = LibMisc.DEPENDENCIES)
public class BetweenOres {

    @Mod.Instance
    public static BetweenOres instance;

    @SidedProxy(serverSide = LibMisc.PROXY_SERVER, clientSide = LibMisc.PROXY_CLIENT)
    private static IProxy proxy;

    public static boolean hasRealmTweaks = Loader.isModLoaded("realmtweaks");

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
	    proxy.preInit(event);
    }

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new OreGens(), 0);

		proxy.init(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

}
