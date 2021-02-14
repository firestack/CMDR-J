package com.controllerface.cmdr_j.classes.events.handlers.materials;

import com.controllerface.cmdr_j.classes.events.handlers.EventProcessingContext;
import com.controllerface.cmdr_j.classes.events.handlers.JournalEventHandler;
import com.controllerface.cmdr_j.enums.costs.commodities.Commodity;

import java.util.List;
import java.util.Map;

import static com.controllerface.cmdr_j.classes.events.JournalEventTransactions.*;

/**
 * Written when synthesizing items
 *
 * Created by Stephen on 7/18/2018.
 */
public class SynthesisHandler implements JournalEventHandler
{
    @Override
    @SuppressWarnings("unchecked")
    public void handle(EventProcessingContext context)
    {
        String name = ((String) context.getRawData().get("Name"));
        logInventoryMessage(context, "Synthesis Complete: " + name);

        if (name.contains("Limpet")) adjust(context, Commodity.DRONES, 4);
        ((List<Map<String, Object>>) context.getRawData().get("Materials"))
                .forEach(material -> adjustMaterialCountDown(context, material));
    }
}
