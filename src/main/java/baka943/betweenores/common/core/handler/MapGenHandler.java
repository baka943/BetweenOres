package baka943.betweenores.common.core.handler;

import baka943.betweenores.common.world.gen.structure.MapGenStrongholdEmpty;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent.EventType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MapGenHandler {

	@SubscribeEvent
	public void onMapGen(InitMapGenEvent event) {
		if(ConfigHandler.disableStronghold) {
			if(event.getType() == EventType.STRONGHOLD) {
				event.setNewGen(new MapGenStrongholdEmpty());
			}
		}
	}

}
