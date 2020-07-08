package com.controllerface.cmdr_j.classes.events.handlers.status;

import com.controllerface.cmdr_j.classes.events.handlers.EventProcessingContext;
import com.controllerface.cmdr_j.classes.events.handlers.JournalEventHandler;
import com.controllerface.cmdr_j.threads.UserTransaction;

public class LaunchSRVHandler implements JournalEventHandler
{
    @Override
    public void handle(EventProcessingContext context)
    {
        context.getTransactions().add(UserTransaction.type(UserTransaction.TransactionType.VEHICLE)
                .setInSRV(true)
                .build());
    }
}
