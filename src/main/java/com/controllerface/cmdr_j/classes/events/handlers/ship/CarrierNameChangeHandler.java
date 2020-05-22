package com.controllerface.cmdr_j.classes.events.handlers.ship;

import com.controllerface.cmdr_j.classes.events.JournalEventTransactions;
import com.controllerface.cmdr_j.classes.events.handlers.EventProcessingContext;
import com.controllerface.cmdr_j.classes.events.handlers.JournalEventHandler;

/**
 * Written when a currently equipped module is sold, removing it from the current ship
 *
 * Created by Stephen on 7/18/2018.
 */
public class CarrierNameChangeHandler implements JournalEventHandler
{
    @Override
    public void handle(EventProcessingContext context)
    {
        String name = ((String) context.getRawData().get("Name"));
        String callSign = ((String) context.getRawData().get("Callsign"));
        JournalEventTransactions.logGeneralMessage(context, "Fleet carrier " + callSign +
                " was renamed to: " + name);
    }
}