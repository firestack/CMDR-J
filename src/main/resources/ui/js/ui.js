/*
Global EventSource object; On page load, this object holds the connection to the local server.
By convention, this connection should always be active as long as the local server is running.
*/
var eventSource;

/*
Mappings for various game data. Note that for each of these are arrays, and order is important.
The events contain numerical values which are used as an index into the appropriate array to
display the correct info in the UI.
*/

// Combat Ranks
const combatRanks =
[
    'Harmless',
    'Mostly Harmless',
    'Novice',
    'Competent',
    'Expert',
    'Master',
    'Dangerous',
    'Deadly',
    'Elite'
];

// Trade Ranks
const tradeRanks =
[
    'Penniless',
    'Mostly Penniless',
    'Peddler',
    'Dealer',
    'Merchant',
    'Broker',
    'Entrepreneur',
    'Tycoon',
    'Elite'
];

// Exploration Ranks
const exploreRanks =
[
    'Aimless',
    'Mostly Aimless',
    'Scout',
    'Surveyor',
    'Trailblazer',
    'Pathfinder',
    'Ranger',
    'Pioneer',
    'Elite'
];

// CQC Ranks
const cqcRanks =
[
    'Helpless',
    'Mostly Helpless',
    'Amateur',
    'Semi Professional',
    'Professional',
    'Champion',
    'Hero',
    'Legend',
    'Elite'
];

// Federal Navy Ranks
const federalRanks =
[
    'None',
    'Recruit',
    'Cadet',
    'Midshipman',
    'Petty Officer',
    'Chief Petty Officer',
    'Warrant Officer',
    'Ensign',
    'Lieutenant',
    'Lieutenant Commander',
    'Post Commander',
    'Post Captain',
    'Rear Admiral',
    'Vice Admiral',
    'Admiral'
];

// Imperial Navy Ranks
const empireRanks =
[
    'None',
    'Outsider',
    'Serf',
    'Master',
    'Squire',
    'Knight',
    'Lord',
    'Baron',
    'Viscount',
    'Count',
    'Earl',
    'Marquis',
    'Duke',
    'Prince',
    'King'
];

// Ship Models
const shipTypes =
{
    adder : "Adder",
    hauler : "Hauler",
    ferdelance : "Fer-De-Lance",
    mamba : "Mamba",
    sidewinder : "Sidewinder",
    cobramkiii : "Cobra MK III",
    cobramkiv : "Cobra MK IV",
    viper : "Viper MK III",
    viper_mkiv : "Viper MK IV",
    krait_mkii : "Krait MK II",
    krait_light : "Krait Phantom",
    python : "Python",
    anaconda : "Anaconda",
    diamondbackxl : "Diamondback Explorer",
    diamondback : "Diamondback Scout",
    asp : "Asp Explorer",
    asp_scout : "Asp Scout",
    independant_trader : "Keelback",
    type6 : "Type-6",
    type7 : "Type-7",
    type9 : "Type-9",
    type9_military : "Type-10",
    typex : "Chieftain",
    typex_2 : "Crusader",
    typex_3 : "Challenger",
    eagle : "Eagle",
    empire_eagle : "Imperial Eagle",
    vulture : "Vulture",
    federation_dropship_mkii : "Federal Assault Ship",
    federation_dropship : "Federal Dropship",
    federation_gunship : "Federal Gunship",
    federation_corvette : "Federal Corvette",
    dolphin : "Dolphin",
    orca : "Orca",
    belugaliner : "Beluga Liner",
    empire_trader : "Imperial Clipper",
    empire_courier : "Imperial Courier",
    cutter : "Imperial Cutter"
}

/*
Called with an element ID and text value, which is set as the textContent property on the located
element. Note that the located DOM element is assumed to exist already in the DOM. If the element
is not present, an error will occur.
*/
function setElementText(id, text)
{
    document.getElementById(id).textContent = text;
}

/*
Called with an element ID and progress value, which is set as the value property on the located
element. Note that the located DOM element is assumed to be a <progress> element and to exist
already in the DOM. If the element is not present, an error will occur but if the element is
of some other type, the value will likely be ignored.
*/
function setElementProgress(id, progress)
{
    let target = document.getElementById(id)
    target.value = progress;
    let toolTip = progress + ' / ' + target.max;
    target.setAttribute('title', toolTip);
}

/*
Called with an element ID and maximum value, which is set as the max property on the located
element. Note that the located DOM element is assumed to be a <progress> element and to exist
already in the DOM. If the element is not present, an error will occur but if the element is
of some other type, the max value will likely be ignored.
*/
function setElementProgressMax(id, max)
{
    let target = document.getElementById(id)
    target.max = max;
    let toolTip = target.value + ' / ' + max;
    target.setAttribute('title', toolTip);
}

/*
When material count events are received, this method is called with the material ID and
the current count, which are used to update the appropriate material count in the UI.
*/
function setMaterialCount(id, data)
{
    let materialBin = document.getElementById(id);
    materialBin.stock = data;
}

/*
From the provided module data, updates the corresponding section of the UI to display the
information for each module.
*/
function updateModules(containerId, moduleData)
{
    // get the UI tab for the appropriate module category
    let moduleTab = document.getElementById(containerId);

    // this clears out any elements that may already be present in the tab
    moduleTab.textContent = "";

    // get all the slot names and sort them
    let slots = Object.keys(moduleData);
    slots.sort((a, b) =>
    {
        /*
        The planetary approach suite is categorized as an optional internal module,
        though now that the Horizons expansion has been rolled into the main game,
        it will always be present. When modules like this have been made universal
        in the past (ex: discovery scanner) they eventually phased out the module
        altogether, and this may happen in the future. If it does, then this can
        be removed.
        */
        if (a === 'PlanetaryApproachSuite')
        {
            return 1;
        }
        if (b === 'PlanetaryApproachSuite')
        {
            return -1;
        }

        // fall back to the default string compare for all other modules
        return a.localeCompare(b);
    });

    for (let i = 0, len = slots.length; i < len; i++)
    {
        let slot = slots[i];
        let module = moduleData[slot];

        let shipModule = document.createElement('ship-module');
        shipModule.slotName = slot;
        shipModule.loadModuleData(module);
        moduleTab.appendChild(shipModule);
    }
}

/*
When loadout data is successfully retrieved, it is passed to this method which separates
it into individual categories before updating each of the matching categories' sections
in the UI.
*/
function setLoadout(data)
{
    let coreModules = {};
    let optionalModules = {};
    let hardPoints = {};
    let slots = Object.keys(data);

    for (let i = 0, len = slots.length; i < len; i++)
    {
        let slot = slots[i];
        if (slot.includes('Hardpoint'))
        {
            hardPoints[slot] = data[slot];
        }
        else if (slot.includes('_Size') || slot === 'PlanetaryApproachSuite')
        {
            optionalModules[slot] = data[slot];
        }
        else
        {
            coreModules[slot] = data[slot];
        }
    }

    updateModules('coreInternals', coreModules);
    updateModules('optionalInternals', optionalModules);
    updateModules('hardpoints', hardPoints);
}

function setStatistics(data)
{
    let statData = data['statistics'];
    let statContainer = document.getElementById('extendedStatistics');
    let categories = Object.keys(statData);
    categories.sort();

    for (let i = 0, len = categories.length; i < len; i++)
    {
        let category = categories[i];
        let statistics = statData[category];

        let nextCategory = document.createElement('stat-category');
        nextCategory.category = category;

        let statNames = Object.keys(statistics);
        statNames.sort();

        for (let j = 0, statLen = statNames.length; j < statLen; j++)
        {
            let statName = statNames[j];
            let statValue = statistics[statName];

            let nextStat = document.createElement('commander-stat');
            nextStat.statistic = statName;
            nextStat.statValue = statValue;
            nextCategory.append(nextStat);
        }
        statContainer.append(nextCategory);
    }
}

function setMarketData(data)
{
    if (Object.keys(data).length === 0)
    {
        return
    }

    let market = document.getElementById('marketInfo');
    market.textContent = "";
    market.station = data['name'];
    market.type = data['type'];
    market.system = data['system'];

    let imports = data['imports'];
    let exports = data['exports'];

    let importTypes = Object.keys(imports);
    let exportTypes = Object.keys(exports);

    importTypes.sort();
    exportTypes.sort();

    for (let i = 0, len = importTypes.length; i < len; i++)
    {
        let category = importTypes[i];
        let categoryElement = document.createElement('span');
        categoryElement.classList.add('binCategoryHeader');
        categoryElement.setAttribute('slot', 'imports');
        categoryElement.textContent = category;
        market.append(categoryElement);

        let items = imports[category];
        let itemTypes = Object.keys(items);
        itemTypes.sort();

        for (let it = 0, itLen = itemTypes.length; it < itLen; it++)
        {
            let itemName = itemTypes[it];
            let item = items[itemName];
            let nextItem = document.createElement('market-entry');
            nextItem.setAttribute('slot', 'imports');
            nextItem.commodity = itemName;
            nextItem.quantity = item['quantity'];
            nextItem.price = item['price'];
            nextItem.mean = item['mean'];
            nextItem.profit = item['profit'];
            market.append(nextItem);
        }

    }

    for (let e = 0, len = exportTypes.length; e < len; e++)
    {
        let category = exportTypes[e];
        let categoryElement = document.createElement('h4');
        categoryElement.classList.add('binCategoryHeader');
        categoryElement.setAttribute('slot', 'exports');
        categoryElement.textContent = category;
        market.append(categoryElement);

        let items = exports[category];
        let itemTypes = Object.keys(items);
        itemTypes.sort();

        for (let it = 0, itLen = itemTypes.length; it < itLen; it++)
        {
            let itemName = itemTypes[it];
            let item = items[itemName];
            let nextItem = document.createElement('market-entry');
            nextItem.setAttribute('slot', 'exports');
            nextItem.commodity = itemName;
            nextItem.quantity = item['quantity'];
            nextItem.price = item['price'];
            nextItem.mean = item['mean'];
            nextItem.profit = item['profit'];
            market.append(nextItem);
        }
    }

}

/*
Called when a complex JSON event trigger is detected. Requests the endpoint
of the complex object and passes the data to the provided callback.
*/
function requestJsonEndpoint(endpoint, callback)
{
    fetch(endpoint)
      .then(response => response.json())
      .then(data => callback(data))
      .catch(error => console.error(error));
}

function handleMaterial(e)
{
    let data = JSON.parse(e);
    let name = data['name'];
    let count = data['count'];
    setMaterialCount(name, count);
}

/*
Called when the cargo event comes in. When the initial event is received it
triggers a clearing of the last known values, then the current values are
received immediately after.
*/
function handleCargo(e)
{
    let cargoContainer = document.getElementById('tradeCargo');
    if (e === 'Clear')
    {
        let existingBins = cargoContainer.querySelectorAll('cargo-bin');
        for (let i = 0, len = existingBins.length; i < len; i++)
        {
            cargoContainer.removeChild(existingBins[i]);
        }
    }
    else
    {
        let cargoData = JSON.parse(e);
        let cargoBin = document.createElement('cargo-bin');
        cargoBin.commodity = cargoData['name'];
        cargoBin.stock = cargoData['count'];
        cargoBin.type = cargoData['type'];
        cargoContainer.append(cargoBin);
    }
}

function handleShipData(data)
{
    let layout = JSON.parse(data);
    console.log(layout);
    let baseStats = layout['baseStats'];

    let shipStats = document.getElementById('shipStats');
    shipStats.manufacturer = baseStats['manufacturer'];
    shipStats.model = baseStats['displayName'];
    shipStats.shipSize = baseStats['shipSize'];
    shipStats.baseCost = parseInt(baseStats['baseCost'], 10).toLocaleString("en-US");
    shipStats.crewSeats = baseStats['crewSeats'];
    shipStats.slf = baseStats['slfCapable'];

    let agilityStats = document.getElementById('agilityStats');

    shipStats.baseHull = baseStats['hullMass']
    shipStats.massLock = baseStats['massLockFactor']
    shipStats.baseAgility = baseStats['agility']
    shipStats.speed = baseStats['speed']
    shipStats.maxSpeed = baseStats['maxSpeed']
    shipStats.boost = baseStats['boostSpeed']
    shipStats.maxBoost = baseStats['maxBoostSpeed']
}

function handleMassData(property, data)
{
    let agilityStats = document.getElementById('agilityStats');
    agilityStats[property] = data;
}

function handleShipValueData(property, data)
{
    let shipStats = document.getElementById('shipStats');
    shipStats[property] = data;
}

/*
This object contains event listener functions that will be bound to the local event source
on page load. For each key listed below, the mapped function is bound to an event with the
exact name of the key itself, so the key must exactly match an event that will be sent over
the event source connection.
*/
const eventListeners =
{
    // The player's commander name
    Commander: (e) => setElementText("Commander", e.data),

    // Current game mode
    Game_Mode: (e) => setElementText("Game_Mode", e.data),

    // If in a private group, the name of that group
    Private_Group: (e) => setElementText("Private_Group", e.data),

    // Current ship info; the ship model name, and the player controlled ship name and ID
    Ship: (e) => setElementText("Ship", shipTypes[e.data.toLowerCase()]),
    Ship_Name: (e) => setElementText("Ship_Name", e.data),
    Ship_Ident: (e) => setElementText("Ship_Ident", '[' + e.data.toUpperCase() + ']'),
    Ship_Data: (e) => handleShipData(e.data),

    // Current fuel level data; max and current level
    Fuel_Capacity: (e) =>
    {
        setElementProgressMax("Fuel_Capacity", e.data);
        handleShipValueData('fuelCapacity', e.data)
    },
    Fuel_Level: (e) =>
    {
        setElementProgress("Fuel_Capacity", e.data);
    },
    ReserveCapacity: (e) => handleShipValueData('resevoirCapacity', e.data),

    // Monetary info; current balance, insurance costs, and current loan amount if any
    Credits: (e) => setElementText("Credits", parseInt(e.data, 10).toLocaleString("en-US")),
    Rebuy: (e) => setElementText("Rebuy", parseInt(e.data, 10).toLocaleString("en-US")),
    Loan: (e) => setElementText("Loan", parseInt(e.data, 10).toLocaleString("en-US")),

    CargoCapacity: (e) => handleShipValueData('cargoCapacity', e.data),
    UnladenMass: (e) => handleShipValueData('unladenMass', e.data),
    CurrentMass: (e) => handleShipValueData('currentMass', e.data),
    MaxJumpRange: (e) => handleShipValueData('maxRange', e.data),
    HullValue: (e) => handleShipValueData('hullValue', parseInt(e.data, 10).toLocaleString("en-US")),
    ModulesValue: (e) => handleShipValueData('moduleValue', parseInt(e.data, 10).toLocaleString("en-US")),

    // Current career ranks
    Rank_Combat: (e) => setElementText("Rank_Combat", combatRanks[e.data]),
    Rank_Trade: (e) => setElementText("Rank_Trade", tradeRanks[e.data]),
    Rank_Explore: (e) => setElementText("Rank_Explore", exploreRanks[e.data]),
    Rank_CQC: (e) => setElementText("Rank_CQC", cqcRanks[e.data]),

    // Career rank progress
    Progress_Combat: (e) => setElementProgress("Progress_Combat", e.data),
    Progress_Trade: (e) => setElementProgress("Progress_Trade", e.data),
    Progress_Explore: (e) => setElementProgress("Progress_Explore", e.data),
    Progress_CQC: (e) => setElementProgress("Progress_CQC", e.data),

    // Federal naval rank and reputation
    Rank_Federation: (e) => setElementText("Rank_Federation", federalRanks[e.data]),
    Progress_Federation: (e) => setElementProgress("Progress_Federation", e.data),
    Reputation_Federation: (e) => setElementProgress("Reputation_Federation", e.data),

    // Imperial navy rank and reputation
    Rank_Empire: (e) => setElementText("Rank_Empire", empireRanks[e.data]),
    Progress_Empire: (e) => setElementProgress("Progress_Empire", e.data),
    Reputation_Empire: (e) => setElementProgress("Reputation_Empire", e.data),

    // Alliance reputation
    Reputation_Alliance: (e) => setElementProgress("Reputation_Alliance", e.data),

    // Independent (non-allied) reputation
    Reputation_Independent: (e) => setElementProgress("Reputation_Independent", e.data),

    // Signals the player's ship loadout has changed
    Loadout: (e) => requestJsonEndpoint('/loadout', setLoadout),

    // Extended player stats (total time played, etc.)
    Statistics: (e) => requestJsonEndpoint('/statistics', setStatistics),

    // Information about the most recently visited commodity market
    Market: (e) => requestJsonEndpoint('/market', setMarketData),

    // Called when the player's cargo manifest changes, contains info about each item
    Cargo: (e) => handleCargo(e.data),

    // Called when the player's crafting material counts change
    Material: (e) => handleMaterial(e.data),
};

window.onload = (e) =>
{
    eventSource = new EventSource('/');
    Object.keys(eventListeners)
        .forEach(event => eventSource.addEventListener(event, eventListeners[event]));
};