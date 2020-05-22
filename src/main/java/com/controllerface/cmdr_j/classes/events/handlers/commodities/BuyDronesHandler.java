package com.controllerface.cmdr_j.classes.events.handlers.commodities;

import com.controllerface.cmdr_j.classes.events.handlers.EventProcessingContext;
import com.controllerface.cmdr_j.classes.events.handlers.JournalEventHandler;
import com.controllerface.cmdr_j.enums.costs.commodities.Commodity;

import static com.controllerface.cmdr_j.classes.events.JournalEventTransactions.adjust;
import static com.controllerface.cmdr_j.classes.events.JournalEventTransactions.logInventoryMessage;

/**
 * Written when buying limpet drones
 *
 * Created by Stephen on 7/18/2018.
 */
public class BuyDronesHandler implements JournalEventHandler
{
    @Override
    public void handle(EventProcessingContext context)
    {
        logInventoryMessage(context, "Limpet Drones Purchased");
        adjust(context, Commodity.DRONES, ((int) context.getRawData().get("Count")));

        int cost = ((int) context.getRawData().get("TotalCost"));
        context.getCommanderData().adjustCreditBalance(-1 * cost);
    }
}