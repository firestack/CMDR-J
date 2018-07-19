package com.controllerface.cmdr_j.data.events.items.commodities;

import com.controllerface.cmdr_j.EventProcessingContext;
import com.controllerface.cmdr_j.data.events.JournalEventHandler;
import com.controllerface.cmdr_j.structures.costs.commodities.Commodity;

import static com.controllerface.cmdr_j.data.events.JournalEventTransactions.adjust;
import static com.controllerface.cmdr_j.data.events.JournalEventTransactions.logInventoryMessage;

/**
 * Written when buying limpet drones
 *
 * Created by Stephen on 7/18/2018.
 */
public class BuyDronesHandler implements JournalEventHandler
{
    @Override
    @SuppressWarnings("unchecked")
    public void handle(EventProcessingContext context)
    {
        logInventoryMessage(context, "Limpet Drones Purchased");
        adjust(context, Commodity.DRONES, ((int) context.getRawData().get("Count")));
    }
}
