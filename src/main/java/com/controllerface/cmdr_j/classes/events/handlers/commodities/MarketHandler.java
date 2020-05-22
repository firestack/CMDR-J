package com.controllerface.cmdr_j.classes.events.handlers.commodities;

import com.controllerface.cmdr_j.classes.events.JournalEventTransactions;
import com.controllerface.cmdr_j.classes.events.handlers.EventProcessingContext;
import com.controllerface.cmdr_j.classes.events.handlers.JournalEventHandler;

/**
 * Created by Stephen on 7/18/2018.
 */
public class MarketHandler implements JournalEventHandler
{
    @Override
    public void handle(EventProcessingContext context)
    {
        JournalEventTransactions.processMarket(context);
    }
}