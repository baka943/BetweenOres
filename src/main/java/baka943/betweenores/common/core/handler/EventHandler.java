package baka943.betweenores.common.core.handler;

import net.minecraftforge.event.world.BlockEvent.PortalSpawnEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {

	private EventHandler() {}

	@SubscribeEvent
	public static void onPortalSpawnEvent(PortalSpawnEvent event) {
		event.setCanceled(ConfigHandler.disableNether);
	}

}
