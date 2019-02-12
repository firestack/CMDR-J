package com.controllerface.cmdr_j.data.events.handlers.stats.status;

import com.controllerface.cmdr_j.EventProcessingContext;
import com.controllerface.cmdr_j.data.events.handlers.JournalEventHandler;

import static com.controllerface.cmdr_j.data.events.JournalEventTransactions.logGeneralMessage;

public class ReceiveTextHandler implements JournalEventHandler
{
    @Override
    public void handle(EventProcessingContext context)
    {
        String channel = ((String) context.getRawData().get("Channel"));
        String from = ((String) context.getRawData().get("From_Localised"));
        if (from == null)
        {
            from = ((String) context.getRawData().get("From"));
        }
        String message = ((String) context.getRawData().get("Message_Localised"));
        if (channel.equals("npc"))
        {
            logGeneralMessage(context, "Public Message: [" + from + "] " + message);
        }
        else
        {
            logGeneralMessage(context, "Message: [" + from + "] " + message);
        }
    }
}
