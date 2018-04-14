package com.controllerface.edeps.enums.procurements.synthesis;

import com.controllerface.edeps.ProcurementRecipe;
import com.controllerface.edeps.data.CostData;
import com.controllerface.edeps.data.ItemEffectData;
import com.controllerface.edeps.enums.common.ItemEffect;
import com.controllerface.edeps.enums.costs.materials.Material;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Stephen on 4/12/2018.
 */

@SuppressWarnings("unchecked")
public enum SynthesisRecipe implements ProcurementRecipe
{
    /*
    AFM Refill
     */

    AFM_Refill_Basic("Basic", new ItemEffectData
            (
                    new Pair<>(ItemEffect.Refill, 0d)
            ),
            new CostData(Material.NICKEL, 2),
            new CostData(Material.ZINC, 2),
            new CostData(Material.CHROMIUM, 2),
            new CostData(Material.VANADIUM, 3)),

    AFM_Refill_Standard("Standard", new ItemEffectData
            (
                    new Pair<>(ItemEffect.Refill, 0d),
                    new Pair<>(ItemEffect.Repair_Speed, 50d)
            ),
            new CostData(Material.TIN, 1),
            new CostData(Material.MANGANESE, 2),
            new CostData(Material.VANADIUM, 6),
            new CostData(Material.MOLYBDENUM, 1),
            new CostData(Material.ZIRCONIUM, 1)),

    AFM_Refill_Premium("Premium", new ItemEffectData
            (
                    new Pair<>(ItemEffect.Refill, 0d),
                    new Pair<>(ItemEffect.Repair_Speed, 100d)
            ),
            new CostData(Material.ZINC, 2),
            new CostData(Material.CHROMIUM, 4),
            new CostData(Material.VANADIUM, 6),
            new CostData(Material.ZIRCONIUM, 2),
            new CostData(Material.TELLURIUM, 1),
            new CostData(Material.RUTHENIUM, 1)),

    /*
    AX Explosive Munitions
     */

    AX_Explosive_Munitions_Basic("Basic", new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d)
            ),
            new CostData(Material.IRON, 3),
            new CostData(Material.NICKEL, 3),
            new CostData(Material.CARBON, 4),
            new CostData(Material.TG_PROPULSIONELEMENT, 3)),

    AX_Explosive_Munitions_Standard("Standard", new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 5d)

            ),
            new CostData(Material.SULPHUR, 6),
            new CostData(Material.PHOSPHORUS, 6),
            new CostData(Material.MERCURY, 2),
            new CostData(Material.UNKNOWNORGANICCIRCUITRY, 4),
            new CostData(Material.TG_PROPULSIONELEMENT, 4)),

    AX_Explosive_Munitions_Premium("Premium", new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 10d)

            ),
            new CostData(Material.TUNGSTEN, 5),
            new CostData(Material.MERCURY, 4),
            new CostData(Material.POLONIUM, 2),
            new CostData(Material.TG_BIOMECHANICALCONDUITS, 5),
            new CostData(Material.TG_PROPULSIONELEMENT, 5),
            new CostData(Material.TG_SHIPFLIGHTDATA, 6)),

    /*
    AX Remote Flak Munitions
     */

    AX_Remote_Flak_Munitions_Basic("Basic",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d)
            ),
            new CostData(Material.NICKEL, 4),
            new CostData(Material.CARBON, 3),
            new CostData(Material.SULPHUR, 2)),

    AX_Remote_Flak_Munitions_Standard("Standard",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 5d)

            ),
            new CostData(Material.TIN, 2),
            new CostData(Material.ZINC, 3),
            new CostData(Material.ARSENIC, 1),
            new CostData(Material.UNKNOWNTECHNOLOGYCOMPONENTS, 3),
            new CostData(Material.TG_WRECKAGECOMPONENTS, 2)),

    AX_Remote_Flak_Munitions_Premium("Premium",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 10d)

            ),
            new CostData(Material.ZINC, 8),
            new CostData(Material.TUNGSTEN, 2),
            new CostData(Material.ARSENIC, 1),
            new CostData(Material.UNKNOWNENERGYSOURCE, 3),
            new CostData(Material.UNKNOWNTECHNOLOGYCOMPONENTS, 4),
            new CostData(Material.TG_WEAPONPARTS, 1)),

    /*
    AX Small Calibre Munitions
     */

    AX_Small_Calibre_Munitions_Basic("Basic",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d)
            ),
            new CostData(Material.IRON, 2),
            new CostData(Material.NICKEL, 1),
            new CostData(Material.SULPHUR, 1),
            new CostData(Material.TG_WEAPONPARTS, 2)),

    AX_Small_Calibre_Munitions_Standard("Standard",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 5d)
            ),
            new CostData(Material.IRON, 2),
            new CostData(Material.PHOSPHORUS, 2),
            new CostData(Material.ZIRCONIUM, 2),
            new CostData(Material.UNKNOWNENERGYSOURCE, 3),
            new CostData(Material.TG_WEAPONPARTS, 4)),

    AX_Small_Calibre_Munitions_Premium("Premium",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 10d)
            ),
            new CostData(Material.IRON, 3),
            new CostData(Material.PHOSPHORUS, 2),
            new CostData(Material.ZIRCONIUM, 2),
            new CostData(Material.UNKNOWNENERGYSOURCE, 4),
            new CostData(Material.UNKNOWNCARAPACE, 2),
            new CostData(Material.TG_WEAPONPARTS, 6)),

    /*
    Enzyme Missile Munitions
     */

    Enzyme_Missile_Munitions_Basic("Basic",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d)
            ),
            new CostData(Material.IRON, 3),
            new CostData(Material.SULPHUR, 3),
            new CostData(Material.TG_BIOMECHANICALCONDUITS, 4),
            new CostData(Material.TG_PROPULSIONELEMENT, 3),
            new CostData(Material.TG_WEAPONPARTS, 3),
            new CostData(Material.LEAD, 2)),

    Enzyme_Missile_Munitions_Standard("Standard",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 15d)
            ),
            new CostData(Material.SULPHUR, 6),
            new CostData(Material.TUNGSTEN, 4),
            new CostData(Material.TG_BIOMECHANICALCONDUITS, 5),
            new CostData(Material.TG_PROPULSIONELEMENT, 6),
            new CostData(Material.TG_WEAPONPARTS, 4),
            new CostData(Material.LEAD, 4)),

    Enzyme_Missile_Munitions_Premium("Premium",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 30d)
            ),
            new CostData(Material.PHOSPHORUS, 5),
            new CostData(Material.TUNGSTEN, 4),
            new CostData(Material.TG_BIOMECHANICALCONDUITS, 6),
            new CostData(Material.TG_PROPULSIONELEMENT, 6),
            new CostData(Material.TG_WEAPONPARTS, 5),
            new CostData(Material.LEAD, 6)),

    /*
    Explosives Munitions Basic
     */

    Explosives_Munitions_Basic("Basic",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d)
            ),
            new CostData(Material.IRON, 3),
            new CostData(Material.NICKEL, 3),
            new CostData(Material.CARBON, 4),
            new CostData(Material.SULPHUR, 4)),

    Explosives_Munitions_Standard("Standard",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 15d)
            ),
            new CostData(Material.SULPHUR, 6),
            new CostData(Material.PHOSPHORUS, 6),
            new CostData(Material.ARSENIC, 4),
            new CostData(Material.MERCURY, 2)),

    Explosives_Munitions_Premium("Premium",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 30d)
            ),
            new CostData(Material.PHOSPHORUS, 5),
            new CostData(Material.ARSENIC, 4),
            new CostData(Material.NIOBIUM, 5),
            new CostData(Material.MERCURY, 5),
            new CostData(Material.POLONIUM, 5)),

    /*
    Flechette Launcher Munitions
     */

    Flechette_Launcher_Munitions_Basic("Basic",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d)
            ),
            new CostData(Material.TUNGSTEN, 1),
            new CostData(Material.ELECTROCHEMICALARRAYS, 3),
            new CostData(Material.MECHANICALCOMPONENTS, 2),
            new CostData(Material.BORON, 2)),

    Flechette_Launcher_Munitions_Standard("Standard",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 5d)
            ),
                new CostData(Material.TUNGSTEN, 4),
                new CostData(Material.ELECTROCHEMICALARRAYS, 6),
                new CostData(Material.MECHANICALCOMPONENTS, 4),
                new CostData(Material.BORON, 4)),

    Flechette_Launcher_Munitions_Premium("Premium",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 10d)
            ),
            new CostData(Material.TUNGSTEN, 6),
            new CostData(Material.ELECTROCHEMICALARRAYS, 9),
            new CostData(Material.MECHANICALCOMPONENTS, 5),
            new CostData(Material.BORON, 6)),

    /*
    FSD Injection
     */

    FSD_Injection_Basic("Basic",new ItemEffectData
            (
                    new Pair<>(ItemEffect.FSD_Range_Boost, 25d)
            ),
            new CostData(Material.CARBON, 1),
            new CostData(Material.VANADIUM, 1),
            new CostData(Material.GERMANIUM, 1)),

    FSD_Injection_Standard("Standard",new ItemEffectData
            (
                    new Pair<>(ItemEffect.FSD_Range_Boost, 50d)
            ),
            new CostData(Material.CARBON, 1),
            new CostData(Material.VANADIUM, 1),
            new CostData(Material.GERMANIUM, 1),
            new CostData(Material.CADMIUM, 1),
            new CostData(Material.NIOBIUM, 1)),

    FSD_Injection_Premium("Premium",new ItemEffectData
            (
                    new Pair<>(ItemEffect.FSD_Range_Boost, 100d)
            ),
            new CostData(Material.CARBON, 1),
            new CostData(Material.GERMANIUM, 1),
            new CostData(Material.ARSENIC, 1),
            new CostData(Material.NIOBIUM, 1),
            new CostData(Material.YTTRIUM, 1),
            new CostData(Material.POLONIUM, 1)),

    /*
    Guardian Gauss Cannon Munitions
     */

    Guardian_Gauss_Cannon_Munitions_Basic("Basic",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d)
            ),
            new CostData(Material.MANGANESE, 3),
            new CostData(Material.FOCUSCRYSTALS, 2),
            new CostData(Material.GUARDIAN_POWERCONDUIT, 2),
            new CostData(Material.GUARDIAN_SENTINEL_WRECKAGECOMPONENTS, 4)),


    Guardian_Gauss_Cannon_Munitions_Standard("Standard",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 15d)
            ),
            new CostData(Material.MANGANESE, 5),
            new CostData(Material.HEATRESISTANTCERAMICS, 3),
            new CostData(Material.FOCUSCRYSTALS, 5),
            new CostData(Material.GUARDIAN_POWERCONDUIT, 4),
            new CostData(Material.GUARDIAN_SENTINEL_WEAPONPARTS, 3)),

    Guardian_Gauss_Cannon_Munitions_Premium("Premium",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 30d)
            ),
            new CostData(Material.MANGANESE, 8),
            new CostData(Material.HEATRESISTANTCERAMICS, 4),
            new CostData(Material.FILAMENTCOMPOSITES, 6),
            new CostData(Material.FOCUSCRYSTALS, 10)),

    /*
    Guardian Plasma Charger Munitions
     */

    Guardian_Plasma_Charger_Munitions_Basic("Basic",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d)
            ),
            new CostData(Material.CHROMIUM, 3),
            new CostData(Material.HEATDISPERSIONPLATE, 2),
            new CostData(Material.GUARDIAN_POWERCONDUIT, 3),
            new CostData(Material.GUARDIAN_SENTINEL_WRECKAGECOMPONENTS, 4)),

    Guardian_Plasma_Charger_Munitions_Standard("Standard",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 15d)
            ),
            new CostData(Material.CHROMIUM, 4),
            new CostData(Material.HEATEXCHANGERS, 2),
            new CostData(Material.PHASEALLOYS, 2),
            new CostData(Material.GUARDIAN_POWERCELL, 2),
            new CostData(Material.GUARDIAN_TECHCOMPONENT, 2)),

    Guardian_Plasma_Charger_Munitions_Premium("Premium",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 30d)
            ),
            new CostData(Material.CHROMIUM, 6),
            new CostData(Material.ZIRCONIUM, 2),
            new CostData(Material.HEATEXCHANGERS, 4),
            new CostData(Material.PHASEALLOYS, 6),
            new CostData(Material.GUARDIAN_POWERCELL, 4),
            new CostData(Material.GUARDIAN_SENTINEL_WEAPONPARTS, 3)),

    /*
    Guardian Shard Cannon Munitions
     */

    Guardian_Shard_Cannon_Munitions_Basic("Basic",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d)
            ),
            new CostData(Material.CARBON, 3),
            new CostData(Material.VANADIUM, 2),
            new CostData(Material.CRYSTALSHARDS, 3),
            new CostData(Material.GUARDIAN_POWERCELL, 3),
            new CostData(Material.GUARDIAN_SENTINEL_WRECKAGECOMPONENTS, 5)),

    Guardian_Shard_Cannon_Munitions_Standard("Standard",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 15d)
            ),
            new CostData(Material.CRYSTALSHARDS, 4),
            new CostData(Material.GUARDIAN_POWERCELL, 2),
            new CostData(Material.GUARDIAN_SENTINEL_WEAPONPARTS, 2)),

    Guardian_Shard_Cannon_Munitions_Premium("Premium",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 30d)
            ),
            new CostData(Material.CARBON, 8),
            new CostData(Material.SELENIUM, 3),
            new CostData(Material.VANADIUM, 4),
            new CostData(Material.CRYSTALSHARDS, 8)),

    /*
    High Velocity Munitions
     */

    High_Velocity_Munitions_Basic("Basic",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d)
            ),
            new CostData(Material.IRON, 2),
            new CostData(Material.VANADIUM, 1)),

    High_Velocity_Munitions_Standard("Standard",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 15d)
            ),
            new CostData(Material.IRON, 4),
            new CostData(Material.VANADIUM, 3),
            new CostData(Material.TUNGSTEN, 2),
            new CostData(Material.ZIRCONIUM, 2)),

    High_Velocity_Munitions_Premium("Premium",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 30d)
            ),
            new CostData(Material.VANADIUM, 4),
            new CostData(Material.TUNGSTEN, 4),
            new CostData(Material.ZIRCONIUM, 2),
            new CostData(Material.YTTRIUM, 2)),

    /*
    Large Calibre Munitions
     */

    Large_Calibre_Munitions_Basic("Basic",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d)
            ),
            new CostData(Material.NICKEL, 4),
            new CostData(Material.CARBON, 3),
            new CostData(Material.SULPHUR, 2)),

    Large_Calibre_Munitions_Standard("Standard",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 15d)
            ),
            new CostData(Material.TIN, 2),
            new CostData(Material.ZINC, 3),
            new CostData(Material.PHOSPHORUS, 3),
            new CostData(Material.ARSENIC, 1),
            new CostData(Material.ZIRCONIUM, 2)),

    Large_Calibre_Munitions_Premium("Premium",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 30d)
            ),
            new CostData(Material.ZINC, 8),
            new CostData(Material.TUNGSTEN, 2),
            new CostData(Material.ARSENIC, 1),
            new CostData(Material.MERCURY, 1),
            new CostData(Material.ANTIMONY, 2)),


    /*
    Plasma Munitions
     */

    Plasma_Munitions_Basic("Basic",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d)
            ),
            new CostData(Material.SULPHUR, 3),
            new CostData(Material.PHOSPHORUS, 4),
            new CostData(Material.MANGANESE, 1)),

    Plasma_Munitions_Standard("Standard",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 15d)
            ),
            new CostData(Material.PHOSPHORUS, 5),
            new CostData(Material.MANGANESE, 3),
            new CostData(Material.SELENIUM, 1),
            new CostData(Material.MOLYBDENUM, 4)),

    Plasma_Munitions_Premium("Premium",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 30d)
            ),
            new CostData(Material.SELENIUM, 5),
            new CostData(Material.CADMIUM, 4),
            new CostData(Material.MOLYBDENUM, 4),
            new CostData(Material.TECHNETIUM, 2)),

    /*
    Small Calibre Munitions
     */

    Small_Calibre_Munitions_Basic("Basic",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d)
            ),
            new CostData(Material.IRON, 2),
            new CostData(Material.NICKEL, 1),
            new CostData(Material.SULPHUR, 2)),

    Small_Calibre_Munitions_Standard("Standard",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 15d)
            ),
            new CostData(Material.IRON, 2),
            new CostData(Material.ZINC, 2),
            new CostData(Material.PHOSPHORUS, 2),
            new CostData(Material.SELENIUM, 2),
            new CostData(Material.ZIRCONIUM, 2)),

    Small_Calibre_Munitions_Premium("Premium",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 30d)
            ),
            new CostData(Material.SULPHUR, 2),
            new CostData(Material.PHOSPHORUS, 2),
            new CostData(Material.TUNGSTEN, 2),
            new CostData(Material.ZIRCONIUM, 2),
            new CostData(Material.MERCURY, 2),
            new CostData(Material.ANTIMONY, 1)),

    /*
    SRV Ammo Restock
     */

    SRV_Ammo_Restock_Basic("Basic",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d)
            ),
            new CostData(Material.SULPHUR, 2),
            new CostData(Material.PHOSPHORUS, 1)),

    SRV_Ammo_Restock_Standard("Standard",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 15d)
            ),
            new CostData(Material.PHOSPHORUS, 1),
            new CostData(Material.MANGANESE, 1),
            new CostData(Material.SELENIUM, 1),
            new CostData(Material.MOLYBDENUM, 1)),

    SRV_Ammo_Restock_Premium("Premium",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Rearm, 0d),
                    new Pair<>(ItemEffect.Damage_Boost, 30d)
            ),
            new CostData(Material.PHOSPHORUS, 2),
            new CostData(Material.SELENIUM, 2),
            new CostData(Material.MOLYBDENUM, 1),
            new CostData(Material.TECHNETIUM, 1)),

    /*
    SRV Refuel
     */

    SRV_Refuel_Basic("Basic",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Refuel, 0d)
            ),
            new CostData(Material.SULPHUR, 1),
            new CostData(Material.PHOSPHORUS, 1)),

    SRV_Refuel_Standard("Standard",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Refuel, 0d),
                    new Pair<>(ItemEffect.Fuel_Efficiency, 100d)
            ),
            new CostData(Material.SULPHUR, 1),
            new CostData(Material.PHOSPHORUS, 1),
            new CostData(Material.ARSENIC, 1),
            new CostData(Material.MERCURY, 1)),

    SRV_Refuel_Premium("Premium",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Refuel, 0d),
                    new Pair<>(ItemEffect.Fuel_Efficiency, 200d)
            ),
            new CostData(Material.SULPHUR, 1),
            new CostData(Material.ARSENIC, 1),
            new CostData(Material.MERCURY, 1),
            new CostData(Material.TECHNETIUM, 1)),
    /*
    SRV Repair
     */

    SRV_Repair_Basic("Basic",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Repair, 0d)
            ),
            new CostData(Material.IRON, 2),
            new CostData(Material.NICKEL, 1)),

    SRV_Repair_Standard("Standard",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Repair, 0d),
                    new Pair<>(ItemEffect.Hull_Strength, 50d)
            ),
            new CostData(Material.NICKEL, 3),
            new CostData(Material.MANGANESE, 1),
            new CostData(Material.VANADIUM, 1),
            new CostData(Material.MOLYBDENUM, 1)),


    SRV_Repair_Premium("Premium",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Repair, 0d),
                    new Pair<>(ItemEffect.Hull_Strength, 100d)
            ),
            new CostData(Material.ZINC, 1),
            new CostData(Material.CHROMIUM, 2),
            new CostData(Material.VANADIUM, 2),
            new CostData(Material.TUNGSTEN, 1),
            new CostData(Material.TELLURIUM, 1)),

    /*
    Heat Sink
     */

    Heat_Sink_Basic("Basic",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Refill, 0d)
            ),
            new CostData(Material.BASICCONDUCTORS, 2),
            new CostData(Material.HEATCONDUCTIONWIRING, 2)),

    Heat_Sink_Standard("Standard",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Refill, 0d),
                    new Pair<>(ItemEffect.Heat_Dissipation, 15d)
            ),
            new CostData(Material.BASICCONDUCTORS, 2),
            new CostData(Material.HEATCONDUCTIONWIRING, 2),
            new CostData(Material.HEATEXCHANGERS, 2)),

    Heat_Sink_Premium("Premium",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Refill, 0d),
                    new Pair<>(ItemEffect.Heat_Dissipation, 30d)
            ),
            new CostData(Material.BASICCONDUCTORS, 2),
            new CostData(Material.HEATCONDUCTIONWIRING, 2),
            new CostData(Material.HEATEXCHANGERS, 2),
            new CostData(Material.PROTOHEATRADIATORS, 1)),

    /*
    Chaff
     */

    Chaff_Basic("Basic",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Refill, 0d)
            ),
            new CostData(Material.COMPACTCOMPOSITES, 1),
            new CostData(Material.FILAMENTCOMPOSITES, 1)),

    Chaff_Standard("Standard",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Refill, 0d),
                    new Pair<>(ItemEffect.Chaff_Duration, 1d)
            ),
            new CostData(Material.COMPACTCOMPOSITES, 1),
            new CostData(Material.FILAMENTCOMPOSITES, 2),
            new CostData(Material.THERMICALLOYS, 1)),


    Chaff_Premium("Premium",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Refill, 0d),
                    new Pair<>(ItemEffect.Chaff_Duration, 2d)
            ),
            new CostData(Material.COMPACTCOMPOSITES, 1),
            new CostData(Material.FILAMENTCOMPOSITES, 2),
            new CostData(Material.THERMICALLOYS, 1),
            new CostData(Material.PROTORADIOLICALLOYS, 1)),


    /*
    Life Support
     */

    Life_Support("Refill",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Refill, 0d)
            ),
            new CostData(Material.IRON, 2),
            new CostData(Material.NICKEL, 1)),

    /*
    Limpets
     */

    Limpets("Refill",new ItemEffectData
            (
                    new Pair<>(ItemEffect.Refill, 0d)
            ),
            new CostData(Material.IRON, 10),
            new CostData(Material.NICKEL, 10)),

    ;

    private final CostData[] cost;
    private final ItemEffectData effects;
    private final String label;

    SynthesisRecipe(String label, ItemEffectData effects, CostData... cost)
    {
        this.label = label;
        this.effects = effects;
        this.cost = cost;
    }

    public Stream<CostData> costStream()
    {
        return Arrays.stream(cost);
    }

    public ItemEffectData effects()
    {
        return effects;
    }

    @Override
    public String toString()
    {
        return super.toString().replace("_"," ");
    }

    public String getLabel()
    {
        return label;
    }}
