package com.controllerface.cmdr_j.enums.equipment.ships;

import com.controllerface.cmdr_j.classes.BaseShipStats;
import com.controllerface.cmdr_j.classes.CoreModuleLayoutData;
import com.controllerface.cmdr_j.classes.HardPointLayoutData;
import com.controllerface.cmdr_j.classes.OptionalModuleLayoutData;
import com.controllerface.cmdr_j.classes.commander.ShipModule;
import com.controllerface.cmdr_j.classes.ships.*;
import com.controllerface.cmdr_j.enums.equipment.modules.CoreInternalModule;
import com.controllerface.cmdr_j.enums.equipment.modules.stats.HardPointSize;
import com.controllerface.cmdr_j.enums.equipment.modules.stats.ModuleSize;
import com.controllerface.cmdr_j.enums.equipment.ships.shipdata.ShipManufacturer;
import com.controllerface.cmdr_j.enums.equipment.ships.shipdata.ShipSize;

import java.util.Arrays;

/**
 * Created by Controllerface on 4/16/2018.
 */
public enum Ship implements SpaceCraft
{
    // zorgon peterson
    adder(new Adder()),

    hauler(new Hauler()),

    ferdelance(new FDL()),

    mamba(new Mamba()),

    // faulcon delacy

    sidewinder(new Sidewinder()),

    cobramkiii(new CobraMK3()),
    cobramkiv(new CobraMK4()),

    viper(new ViperMK3()),
    viper_mkiv(new ViperMK4()),

    krait_mkii(new KraitMK2()),
    krait_light(new KraitPhantom()),

    python(new Python()),

    anaconda(new Anaconda()),


    // lakon

    diamondbackxl(new DBX()),
    diamondback(new DBScout()),

    asp(new AspX()),
    asp_scout(new AspScout()),

    independant_trader(new Keelback()),

    type6(new Type6()),
    type7(new Type7()),
    type9(new Type9()),
    type9_military(new Type10()),

    typex(new Chieftain()),
    typex_2(new Crusader()),
    typex_3(new Challenger()),


    // core dynamics

    eagle(new Eagle()),
    empire_eagle(new IEagle()),

    vulture(new Vulture()),

    federation_dropship_mkii(new FedAssault()),
    federation_dropship(new FedDropship()),
    federation_gunship(new FedGunship()),
    federation_corvette(new FedCorvette()),


    // saud kruger

    dolphin(new Dolphin()),
    orca(new Orca()),
    belugaliner(new Beluga()),


    // gutamaya

    empire_trader(new IClipper()),
    empire_courier(new ICourier()),
    cutter(new ICutter()),

    ;

    private final AbstractShip delegate;

    private final BaseShipStats baseShipStats;
    private final CoreModuleLayoutData coreModules;
    private final HardPointLayoutData hardpoints;
    private final OptionalModuleLayoutData internals;
    private final ShipModule[] armorModules;

    Ship(AbstractShip delegate)
    {
        this.delegate = delegate;
        this.baseShipStats = null;
        this.coreModules = null;
        this.hardpoints = null;
        this.internals = null;
        this.armorModules = null;
    }

    public BaseShipStats getBaseShipStats()
    {
        return delegate == null ? baseShipStats : delegate.baseShipStats;
    }

    public CoreModuleLayoutData getCoreModules()
    {
        return delegate == null ? coreModules : delegate.coreModules;
    }

    public HardPointLayoutData getHardpoints()
    {
        return delegate == null ? hardpoints : delegate.hardpoints;
    }

    public OptionalModuleLayoutData getInternals()
    {
        return delegate == null ? internals : delegate.internals;
    }

    public ShipModule[] getArmorModules()
    {
        return delegate == null ? armorModules : delegate.armorModules;
    }

    public static Ship findShip(String shipName) throws Exception
    {
        Exception exception;
        try
        {
            return valueOf(shipName);
        }
        catch (Exception e)
        {
            exception = e;
            if (shipName == null || shipName.isEmpty()) throw e;
        }
        return Arrays.stream(Ship.values())
                .filter(ship -> ship.name().toLowerCase().equals(shipName.toLowerCase()))
                .findFirst().orElseThrow(() -> exception);
    }
}
