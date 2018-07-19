package com.controllerface.cmdr_j.structures.journal;

import com.controllerface.cmdr_j.EventProcessingContext;
import com.controllerface.cmdr_j.data.events.*;
import com.controllerface.cmdr_j.data.events.items.bounties.BountyHandler;
import com.controllerface.cmdr_j.data.events.items.bounties.FactionKillBondHandler;
import com.controllerface.cmdr_j.data.events.items.commodities.*;
import com.controllerface.cmdr_j.data.events.items.engineers.EngineerContributionHandler;
import com.controllerface.cmdr_j.data.events.items.engineers.EngineerCraftHandler;
import com.controllerface.cmdr_j.data.events.items.engineers.TechnologyBrokerHandler;
import com.controllerface.cmdr_j.data.events.items.materials.MaterialCollectedHandler;
import com.controllerface.cmdr_j.data.events.items.materials.MaterialDiscardedHandler;
import com.controllerface.cmdr_j.data.events.items.materials.MaterialTradeHandler;
import com.controllerface.cmdr_j.data.events.items.materials.SynthesisHandler;
import com.controllerface.cmdr_j.data.events.items.missions.MissionCompletedHandler;
import com.controllerface.cmdr_j.data.events.items.missions.ScientificResearchHandler;
import com.controllerface.cmdr_j.data.events.items.modules.ModuleBuyHandler;
import com.controllerface.cmdr_j.data.events.items.modules.ModuleRetrieveHandler;
import com.controllerface.cmdr_j.data.events.items.modules.ModuleSellHandler;
import com.controllerface.cmdr_j.data.events.items.modules.ModuleStoreHandler;
import com.controllerface.cmdr_j.data.events.items.powerplay.PowerplayCollectHandler;
import com.controllerface.cmdr_j.data.events.items.powerplay.PowerplayDeliverHandler;
import com.controllerface.cmdr_j.data.events.stats.factions.ProgressHandler;
import com.controllerface.cmdr_j.data.events.stats.factions.RankHandler;
import com.controllerface.cmdr_j.data.events.stats.factions.ReputationHandler;
import com.controllerface.cmdr_j.data.events.stats.market.MarketHandler;
import com.controllerface.cmdr_j.data.events.stats.ship.LoadoutHandler;
import com.controllerface.cmdr_j.data.events.stats.ship.SetUserShipNameHandler;
import com.controllerface.cmdr_j.data.events.stats.startup.CargoHandler;
import com.controllerface.cmdr_j.data.events.stats.startup.LoadGameHandler;
import com.controllerface.cmdr_j.data.events.stats.startup.MaterialsHandler;
import com.controllerface.cmdr_j.data.events.stats.status.HeatWarningHandler;
import com.controllerface.cmdr_j.data.events.stats.status.HullDamageHandler;
import com.controllerface.cmdr_j.data.events.stats.status.ShieldStateHandler;
import com.controllerface.cmdr_j.data.events.stats.status.UnderAttackHandler;
import com.controllerface.cmdr_j.data.events.stats.travel.*;

/**
 * This enum defines all of the Journal API events that are currently supported. By convention, enum value names are
 * exact alphabetical matches for the JSON value string for the event it handles. This is a convenience that allows
 * support for an arbitrary event to be determined by using the valueOf() enum method. Internally, each enum value
 * contains the required processing logic for an event by defining a EventProcessingContext consumer function that
 * is executed on calls to the process() method.
 *
 * For every supported event, the logic to process it is defined as a lambda implementation and passed as a constructor
 * parameter for each event. This configuration helps consolidate all journal API processing code in one central
 * location, making it easy to share functionality among different methods where possible. The intention is that, for
 * maintenance and addition of new events, the bulk of the work to support them would be contained in this one class.
 *
 * Created by Controllerface on 4/16/2018.
 */

@SuppressWarnings("unchecked")
public enum JournalEvent
{
    /*
    Factions
     */
    Progress(new ProgressHandler()),
    Rank(new RankHandler()),
    Reputation(new ReputationHandler()),

    /*
    Market
     */
    Market(new MarketHandler()),

    /*
    Ship
     */
    Loadout(new LoadoutHandler()),
    SetUserShipName(new SetUserShipNameHandler()),

    /*
    Startup
     */
    Cargo(new CargoHandler()),
    LoadGame(new LoadGameHandler()),
    Materials(new MaterialsHandler()),

    /*
    Status
     */
    HeatWarning(new HeatWarningHandler()),
    HullDamage(new HullDamageHandler()),
    ShieldState(new ShieldStateHandler()),
    UnderAttack(new UnderAttackHandler()),

    /*
    Travel
     */
    Docked(new DockedHandler()),
    FSDJump(new FSDJumpHandler()),
    Location(new LocationHandler()),
    StartJump(new StartJumpHandler()),
    SupercruiseEntry(new SupercruiseEntryHandler()),
    SupercruiseExit(new SupercruiseExitHandler()),
    Undocked(new UndockedHandler()),
    USSDrop(new USSDropHandler()),

    /*
    Bounties
     */
    Bounty(new BountyHandler()),
    FactionKillBond(new FactionKillBondHandler()),

    /*
    Commodities
     */
    BuyDrones(new BuyDronesHandler()),
    CargoDepot(new CargoDepotHandler()),
    CollectCargo(new CollectCargoHandler()),
    EjectCargo(new EjectCargoHandler()),
    LaunchDrone(new LaunchDroneHandler()),
    MarketBuy(new MarketBuyHandler()),
    MarketSell(new MarketSellHandler()),
    MiningRefined(new MiningRefinedHandler()),
    SellDrones(new SellDronesHandler()),

    /*
    Engineers
     */
    EngineerContribution(new EngineerContributionHandler()),
    EngineerCraft(new EngineerCraftHandler()),
    TechnologyBroker(new TechnologyBrokerHandler()),

    /*
    Materials
     */
    MaterialCollected(new MaterialCollectedHandler()),
    MaterialDiscarded(new MaterialDiscardedHandler()),
    MaterialTrade(new MaterialTradeHandler()),
    Synthesis(new SynthesisHandler()),

    /*
    Missions
     */
    MissionCompleted(new MissionCompletedHandler()),
    ScientificResearch(new ScientificResearchHandler()),

    /*
    Modules
     */
    ModuleBuy(new ModuleBuyHandler()),
    ModuleRetrieve(new ModuleRetrieveHandler()),
    ModuleSell(new ModuleSellHandler()),
    ModuleStore(new ModuleStoreHandler()),

    /*
    PowerPlay
     */
    PowerplayCollect(new PowerplayCollectHandler()),
    PowerplayDeliver(new PowerplayDeliverHandler()),

    ;

    /**
     * Stores the event processing logic for the corresponding event
     */
    private final JournalEventHandler handler;

    JournalEvent(JournalEventHandler handler)
    {
        this.handler = handler;
    }

    /**
     * Executes a specified event consumer function containing the required processing logic for an event
     *
     * @param eventProcessingContext the current event processing context
     */
    public void process(EventProcessingContext eventProcessingContext)
    {
        handler.handle(eventProcessingContext);
    }
}
