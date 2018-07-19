package com.controllerface.cmdr_j.data.events.stats.factions;

import com.controllerface.cmdr_j.EventProcessingContext;
import com.controllerface.cmdr_j.data.events.JournalEventHandler;
import com.controllerface.cmdr_j.structures.commander.RankStat;

import static com.controllerface.cmdr_j.data.events.JournalEventTransactions.logGeneralMessage;
import static com.controllerface.cmdr_j.data.events.JournalEventTransactions.setStatFromData;

/**
 * Rank event: written at startup, when loading from main menu
 *
 * Created by Stephen on 7/18/2018.
 */
public class RankHandler implements JournalEventHandler
{
    @Override
    @SuppressWarnings("unchecked")
    public void handle(EventProcessingContext context)
    {
        logGeneralMessage(context, "Reloading Current Rank Status");

        setStatFromData(context, RankStat.Rank_Combat);
        setStatFromData(context, RankStat.Rank_Trade);
        setStatFromData(context, RankStat.Rank_Explore );
        setStatFromData(context, RankStat.Rank_Empire);
        setStatFromData(context, RankStat.Rank_Federation);
        setStatFromData(context, RankStat.Rank_CQC);    }
}
