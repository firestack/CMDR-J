package com.controllerface.cmdr_j.classes.events.handlers.items.materials;

import com.controllerface.cmdr_j.classes.events.handlers.EventProcessingContext;
import com.controllerface.cmdr_j.classes.events.handlers.JournalEventHandler;

import static com.controllerface.cmdr_j.classes.events.JournalEventTransactions.adjustMaterialCount;
import static com.controllerface.cmdr_j.classes.events.JournalEventTransactions.logInventoryMessage;

/**
 * Written when materials are collected
 *
 * Created by Stephen on 7/18/2018.
 */
public class MaterialCollectedHandler implements JournalEventHandler
{
    @Override
    public void handle(EventProcessingContext context)
    {
        logInventoryMessage(context, "Material Collected");
        adjustMaterialCount(context, context.getRawData());
    }
}
