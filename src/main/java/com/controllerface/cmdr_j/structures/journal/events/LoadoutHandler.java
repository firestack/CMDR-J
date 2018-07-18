package com.controllerface.cmdr_j.structures.journal.events;

import com.controllerface.cmdr_j.EventProcessingContext;
import com.controllerface.cmdr_j.structures.equipment.ships.CoreInternalSlot;
import com.controllerface.cmdr_j.structures.equipment.ships.Ship;
import com.controllerface.cmdr_j.threads.JournalSyncTask;

import java.util.List;
import java.util.Map;

import static com.controllerface.cmdr_j.structures.journal.JournalEventTransactions.*;
import static com.controllerface.cmdr_j.structures.journal.JournalEventTransactions.extractStatString;
import static com.controllerface.cmdr_j.structures.journal.JournalEventTransactions.setStatFromData;

/**
 * Created by Stephen on 7/18/2018.
 */
public class LoadoutHandler extends JournalEventHandler
{
    @Override
    @SuppressWarnings("unchecked")
    public void handle(EventProcessingContext context)
    {
        logLoadoutMessage(context, "Entering Star Ship");

        JournalSyncTask.shipStats.forEach(context.getCommanderData()::removeStat);

        setStatFromData(context, CoreInternalSlot.Ship);
        setStatFromData(context, CoreInternalSlot.ShipName);
        setStatFromData(context, CoreInternalSlot.ShipIdent);

        String shipName = context.getCommanderData().getStat(CoreInternalSlot.Ship);
        Ship ship;
        try
        {
            ship = Ship.findShip(shipName);
            logLoadoutMessage(context, "Ship Type: " + ship.getBaseShipStats().getDisplayName());
            context.getCommanderData().setShip(ship);
            context.getCommanderData().getStarShip()
                    .setGivenName(extractStatString(context, CoreInternalSlot.ShipName));
            context.getCommanderData().getStarShip()
                    .setShipID(extractStatString(context, CoreInternalSlot.ShipIdent));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        ((List<Map<String, Object>>) context.getRawData().get("Modules")).stream()
                .forEach(module -> setSlotFromLoadout(context, module));
    }
}
