package com.controllerface.cmdr_j.server;

import com.controllerface.cmdr_j.classes.commander.Statistic;
import com.controllerface.cmdr_j.classes.data.EntityKeys;
import com.controllerface.cmdr_j.enums.commander.CommanderStat;
import com.controllerface.cmdr_j.enums.commander.RankStat;
import com.controllerface.cmdr_j.enums.commander.ShipStat;
import com.controllerface.cmdr_j.enums.costs.materials.Material;
import com.controllerface.cmdr_j.enums.equipment.ships.moduleslots.CoreInternalSlot;
import com.controllerface.cmdr_j.enums.equipment.ships.moduleslots.CosmeticSlot;
import com.controllerface.cmdr_j.enums.equipment.ships.moduleslots.HardpointSlot;
import com.controllerface.cmdr_j.enums.equipment.ships.moduleslots.OptionalInternalSlot;
import com.controllerface.cmdr_j.ui.UIFunctions;
import jetbrains.exodus.entitystore.PersistentEntityStore;
import jetbrains.exodus.entitystore.PersistentEntityStores;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;

public class PlayerState
{
    private final Lock stateLock = new ReentrantLock();

    private final Map<Statistic, String> commanderStatistics = new ConcurrentHashMap<>();
    private final Map<Statistic, String> shipStatistics = new ConcurrentHashMap<>();
    private final Map<Material, Integer> materials = new ConcurrentHashMap<>();

    /**
     * Contains the commander's current credit balance.
     */
    private long creditBalance = 0;

    /**
     * This object holds the persistent data related to this commander
     */
    private final PersistentEntityStore database =
        PersistentEntityStores.newInstance(UIFunctions.DATA_FOLDER + "/db");


    /**
     * This is an event sink used when state changes must be communicated to listening clients
     */
    private final BiConsumer<String, String> globalUpdate;

    public PlayerState(BiConsumer<String, String> globalUpdate)
    {
        this.globalUpdate = globalUpdate;
    }

    private void executeWithLock(Procedure procedure)
    {
        stateLock.lock();
        try
        {
            procedure.call();
        }
        finally
        {
            stateLock.unlock();
        }
    }

    public void setCommanderStat(Statistic statistic, String value)
    {
        executeWithLock(() ->
        {
            commanderStatistics.put(statistic, value);
            globalUpdate.accept(statistic.getName(), value);
            updateInternalState(statistic, value);
        });
    }

    public void setMaterialCount(Material material, Integer count)
    {
        executeWithLock(() ->
        {
            materials.put(material, count);
            globalUpdate.accept(material.name(), count.toString());
        });
    }

    public void setShipStat(Statistic statistic, String value)
    {
        executeWithLock(() ->
        {
            shipStatistics.put(statistic, value);
            globalUpdate.accept(statistic.getName(), value);
            updateInternalState(statistic, value);
        });
    }

    public void emitCurrentState(BiConsumer<String, String> directUpdate)
    {
        executeWithLock(() ->
        {
            // todo: as more state is tracked, this will need to be updated to make sure
            //  all important data is emitted during this call

            commanderStatistics.forEach((statistic, value) ->
                directUpdate.accept(statistic.getName(), value));

            shipStatistics.forEach((statistic, value) ->
                directUpdate.accept(statistic.getName(), value));

            materials.forEach((material, value) ->
                directUpdate.accept(material.name(), value.toString()));
        });
    }

    public void adjustCreditBalance(long adjustment)
    {
        executeWithLock(() ->
        {
            creditBalance += adjustment;
            String balance = String.valueOf(creditBalance);
            commanderStatistics.put(CommanderStat.Credits, balance);
            globalUpdate.accept(CommanderStat.Credits.getName(), balance);
        });
    }

    private void updateInternalState(Statistic statistic, String value)
    {
        // player

        if (statistic instanceof CommanderStat)
        {
            if (statistic == CommanderStat.Commander)
            {
                database.executeInTransaction(txn ->
                {
                    String commander = commanderStatistics.get(CommanderStat.Commander);
                    if (txn.find(EntityKeys.COMMANDER, EntityKeys.NAME, commander).isEmpty())
                    {
                        txn.newEntity(EntityKeys.COMMANDER)
                            .setProperty(EntityKeys.NAME, commander);
                    }
                });
            }

            if (statistic == CommanderStat.Credits)
            {
                creditBalance = Long.parseLong(value.replace(",",""));
            }
        }

        if (statistic instanceof RankStat)
        {
            // ignore for now
        }

        // ship

        if (statistic instanceof ShipStat)
        {
            if (statistic == ShipStat.Fuel_Level)
            {
                // todo: parse value
            }
            if (statistic == ShipStat.Fuel_Capacity)
            {
                // todo: parse value
            }
        }

        if (statistic instanceof CoreInternalSlot)
        {

        }

        if (statistic instanceof CosmeticSlot)
        {

        }

        if (statistic instanceof HardpointSlot)
        {

        }

        if (statistic instanceof OptionalInternalSlot)
        {

        }
    }
}
