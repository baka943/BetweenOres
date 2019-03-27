package baka943.betweenores.client.core.proxy;

import baka943.betweenores.client.core.handler.ScreenRenderHandler;
import baka943.betweenores.common.core.proxy.IProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy implements IProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {}

    @Override
    public void init(FMLInitializationEvent event) {}

    @Override
    public void postInit(FMLPostInitializationEvent event) {}

	@Override
    public void registerEventHandlers() {
	    MinecraftForge.EVENT_BUS.register(ScreenRenderHandler.INSTANCE);
    }

}
