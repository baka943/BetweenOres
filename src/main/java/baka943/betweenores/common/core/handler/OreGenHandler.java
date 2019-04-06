package baka943.betweenores.common.core.handler;

import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OreGenHandler {

	@SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
	public void onOreGenMinable(OreGenEvent.GenerateMinable event) {

		switch(event.getType()) {
			case COAL:
			case IRON:
			case GOLD:
			case LAPIS:
			case REDSTONE:
			case QUARTZ:
			case DIAMOND:
			case EMERALD:
				event.setResult(Event.Result.DENY);
				break;

			default:
				event.setResult(Event.Result.ALLOW);
				break;
		}
	}
}
