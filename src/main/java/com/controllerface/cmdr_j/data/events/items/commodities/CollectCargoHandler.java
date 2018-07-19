package com.controllerface.cmdr_j.data.events.items.commodities;

import com.controllerface.cmdr_j.EventProcessingContext;
import com.controllerface.cmdr_j.data.events.JournalEventHandler;
import com.controllerface.cmdr_j.data.events.JournalEventTransactions;
import javafx.util.Pair;

import static com.controllerface.cmdr_j.data.events.JournalEventTransactions.adjust;
import static com.controllerface.cmdr_j.data.events.JournalEventTransactions.logInventoryMessage;

/**
 * Written when collecting commodity items
 *
 * Created by Stephen on 7/18/2018.
 */
public class CollectCargoHandler implements JournalEventHandler
{
    @Override
    @SuppressWarnings("unchecked")
    public void handle(EventProcessingContext context)
    {
        logInventoryMessage(context, "Cargo Collected");
        String name = ((String) context.getRawData().get("Type")).toUpperCase();
        adjust(context, new Pair<>(name, 1), JournalEventTransactions.AdjustmentType.COMMODITY);
    }
}
