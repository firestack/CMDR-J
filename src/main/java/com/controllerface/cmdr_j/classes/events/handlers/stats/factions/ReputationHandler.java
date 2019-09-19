package com.controllerface.cmdr_j.classes.events.handlers.stats.factions;

import com.controllerface.cmdr_j.classes.events.handlers.EventProcessingContext;
import com.controllerface.cmdr_j.classes.events.handlers.JournalEventHandler;
import com.controllerface.cmdr_j.enums.commander.RankStat;

import static com.controllerface.cmdr_j.classes.events.JournalEventTransactions.logGeneralMessage;
import static com.controllerface.cmdr_j.classes.events.JournalEventTransactions.setStatFromData;

/**
 * Reputation event: written at startup, when loading from main menu
 *
 * Created by Stephen on 7/18/2018.
 */
public class ReputationHandler implements JournalEventHandler
{
    @Override
    public void handle(EventProcessingContext context)
    {
        logGeneralMessage(context, "Reloading Faction Reputation");

        setStatFromData(context, RankStat.Reputation_Empire);
        setStatFromData(context, RankStat.Reputation_Federation);
        setStatFromData(context, RankStat.Reputation_Alliance);
        setStatFromData(context, RankStat.Reputation_Independent);
    }
}
