package com.controllerface.cmdr_j.data.events.handlers.stats.ship;

import com.controllerface.cmdr_j.EventProcessingContext;
import com.controllerface.cmdr_j.data.events.handlers.JournalEventHandler;

import static com.controllerface.cmdr_j.data.events.JournalEventTransactions.logGeneralMessage;
import static com.controllerface.cmdr_j.data.events.JournalEventTransactions.logLoadoutMessage;

/**
 * Fuel Scoop event:
 *
 * Created by Stephen on 7/18/2018.
 */
public class FuelScoopHandler implements JournalEventHandler
{
    @Override
    @SuppressWarnings("unchecked")
    public void handle(EventProcessingContext context)
    {
        double scooped = ((double) context.getRawData().get("Scooped"));
        double total = ((double) context.getRawData().get("Total"));
        logGeneralMessage(context, "Scooped " + scooped + " Tons of fuel; Current Fuel Level:  " + total + " Tons");
    }
}
