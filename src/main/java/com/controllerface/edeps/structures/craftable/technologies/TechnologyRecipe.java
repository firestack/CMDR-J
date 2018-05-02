package com.controllerface.edeps.structures.craftable.technologies;

import com.controllerface.edeps.ProcurementRecipe;
import com.controllerface.edeps.data.procurements.CostData;
import com.controllerface.edeps.data.ItemEffectData;
import com.controllerface.edeps.structures.equipment.ItemEffect;
import com.controllerface.edeps.structures.costs.commodities.Commodity;
import com.controllerface.edeps.structures.costs.materials.Material;
import com.controllerface.edeps.structures.equipment.ItemGrade;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Stephen on 4/12/2018.
 */
public enum TechnologyRecipe implements ProcurementRecipe
{
    // Human

    Corrosion_Resistant_Cargo_Rack(ItemGrade.Technology, "4E Cargo Rack", new ItemEffectData
            (
                    new Pair<>(ItemEffect.CausticResistance, 0d)
            ),
            new CostData(Material.CHEMICALMANIPULATORS, 18),
            new CostData(Material.IRON, 30),
            new CostData(Commodity.METAALLOYS, 28),
            new CostData(Commodity.RADIATIONBAFFLE, 30),
            new CostData(Commodity.NEOFABRICINSULATION, 12)),

    Enzyme_Missile_Rack_Fixed(ItemGrade.Technology, "Fixed", new ItemEffectData
            (
                    new Pair<>(ItemEffect.enzyme_munitions, 0d)
            ),
            new CostData(Material.TUNGSTEN, 35),
            new CostData(Material.UNKNOWNENERGYCELL, 30),
            new CostData(Material.UNKNOWNORGANICCIRCUITRY, 36),
            new CostData(Material.MOLYBDENUM, 34),
            new CostData(Commodity.RADIATIONBAFFLE, 6)),

    Meta_Alloy_Hull_Reinforcement(ItemGrade.Technology, "Hull Reinforcement Package", new ItemEffectData
            (
                    new Pair<>(ItemEffect.meta_alloy_reinforcement, 0d)
            ),
            new CostData(Material.FOCUSCRYSTALS, 30),
            new CostData(Material.SHIELDPATTERNANALYSIS, 26),
            new CostData(Material.CONFIGURABLECOMPONENTS, 20),
            new CostData(Commodity.METAALLOYS, 28),
            new CostData(Commodity.REINFORCEDMOUNTINGPLATE, 12)),

    Remote_Release_Flechette_Launcher_Fixed(ItemGrade.Technology, "Fixed", new ItemEffectData
            (
                    new Pair<>(ItemEffect.remote_release_shell, 0d)
            ),
            new CostData(Material.RHENIUM, 28),
            new CostData(Material.IRON, 40),
            new CostData(Material.MOLYBDENUM, 36),
            new CostData(Material.GERMANIUM, 32),
            new CostData(Commodity.CMMCOMPOSITE, 8)),

    Remote_Release_Flechette_Launcher_Turreted(ItemGrade.Technology, "Turreted", new ItemEffectData
            (
                    new Pair<>(ItemEffect.remote_release_shell, 0d)
            ),
            new CostData(Material.RHENIUM, 28),
            new CostData(Material.IRON, 36),
            new CostData(Material.MOLYBDENUM, 32),
            new CostData(Material.GERMANIUM, 34),
            new CostData(Commodity.ARTICULATIONMOTORS, 10)),

    Shock_Cannon_Fixed(ItemGrade.Technology, "Fixed", new ItemEffectData
            (
                    new Pair<>(ItemEffect.shock_shell, 0d)
            ),
            new CostData(Material.VANADIUM, 30),
            new CostData(Material.TUNGSTEN, 30),
            new CostData(Material.RHENIUM, 36),
            new CostData(Material.TECHNETIUM, 30),
            new CostData(Commodity.IONDISTRIBUTOR, 6)),

    Shock_Cannon_Gimballed(ItemGrade.Technology, "Gimbaled", new ItemEffectData
            (
                    new Pair<>(ItemEffect.shock_shell, 0d)
            ),
            new CostData(Material.TUNGSTEN, 32),
            new CostData(Material.RHENIUM, 30),
            new CostData(Material.TECHNETIUM, 28),
            new CostData(Material.VANADIUM, 36),
            new CostData(Commodity.POWERCONVERTER, 10)),

    Shock_Cannon_Turreted(ItemGrade.Technology, "Turreted", new ItemEffectData
            (
                    new Pair<>(ItemEffect.shock_shell, 0d)
            ),
            new CostData(Material.VANADIUM, 30),
            new CostData(Material.TUNGSTEN, 32),
            new CostData(Material.RHENIUM, 30),
            new CostData(Material.TECHNETIUM, 28),
            new CostData(Commodity.POWERTRANSFERBUS, 8)),


    // Guardian

    Guardian_FSD_Booster(ItemGrade.Technology, "FSD Boost Module", new ItemEffectData
            (
                    new Pair<>(ItemEffect.fsd_boost, 0d)
            ),
            new CostData(Material.GUARDIAN_MODULEBLUEPRINT, 8),
            new CostData(Material.GUARDIAN_POWERCELL, 42),
            new CostData(Material.GUARDIAN_TECHCOMPONENT, 42),
            new CostData(Material.FOCUSCRYSTALS, 24),
            new CostData(Commodity.HNSHOCKMOUNT, 8)),

    Guardian_Gauss_Cannon_Fixed(ItemGrade.Technology, "Fixed", new ItemEffectData
            (
                    new Pair<>(ItemEffect.gauss_shell, 0d)
            ),
            new CostData(Material.GUARDIAN_WEAPONBLUEPRINT, 4),
            new CostData(Material.GUARDIAN_POWERCELL, 36),
            new CostData(Material.GUARDIAN_TECHCOMPONENT, 42),
            new CostData(Material.MANGANESE, 30),
            new CostData(Commodity.MAGNETICEMITTERCOIL, 10)),

    Guardian_Hybrid_Power_Distributor(ItemGrade.Technology, "Power Distributor", new ItemEffectData
            (
                    new Pair<>(ItemEffect.hybrid_power, 0d)
            ),
            new CostData(Material.GUARDIAN_MODULEBLUEPRINT, 4),
            new CostData(Material.ANCIENTBIOLOGICALDATA, 27),
            new CostData(Material.GUARDIAN_POWERCELL, 45),
            new CostData(Material.PHASEALLOYS, 36),
            new CostData(Commodity.HEATSINKINTERLINK, 6)),

    Guardian_Hybrid_Power_Plant(ItemGrade.Technology, "Power Plant", new ItemEffectData
            (
                    new Pair<>(ItemEffect.hybrid_power, 0d)
            ),
            new CostData(Material.GUARDIAN_MODULEBLUEPRINT, 4),
            new CostData(Material.GUARDIAN_POWERCONDUIT, 36),
            new CostData(Material.ANCIENTTECHNOLOGICALDATA, 42),
            new CostData(Material.HEATRESISTANTCERAMICS, 30),
            new CostData(Commodity.ENERGYGRIDASSEMBLY, 10)),

    Guardian_Plasma_Charger_Fixed(ItemGrade.Technology, "Fixed", new ItemEffectData
            (
                    new Pair<>(ItemEffect.plasma_weapon, 0d)
            ),
            new CostData(Material.GUARDIAN_WEAPONBLUEPRINT, 8),
            new CostData(Material.GUARDIAN_POWERCONDUIT, 38),
            new CostData(Material.GUARDIAN_SENTINEL_WEAPONPARTS, 34),
            new CostData(Material.CHROMIUM, 28),
            new CostData(Commodity.MICROWEAVECOOLINGHOSES, 12)),

    Guardian_Plasma_Charger_Turreted(ItemGrade.Technology, "Turreted", new ItemEffectData
            (
                    new Pair<>(ItemEffect.plasma_weapon, 0d)
            ),
            new CostData(Material.GUARDIAN_WEAPONBLUEPRINT, 10),
            new CostData(Material.GUARDIAN_POWERCONDUIT, 42),
            new CostData(Material.GUARDIAN_SENTINEL_WEAPONPARTS, 42),
            new CostData(Material.CHROMIUM, 33),
            new CostData(Commodity.ARTICULATIONMOTORS, 10)),

    Guardian_Shard_Cannon_Fixed(ItemGrade.Technology, "Fixed", new ItemEffectData
            (
                    new Pair<>(ItemEffect.shard_shell, 0d)
            ),
            new CostData(Material.GUARDIAN_WEAPONBLUEPRINT, 8),
            new CostData(Material.GUARDIAN_SENTINEL_WRECKAGECOMPONENTS, 40),
            new CostData(Material.GUARDIAN_TECHCOMPONENT, 36),
            new CostData(Material.CARBON, 35),
            new CostData(Commodity.POWERTRANSFERBUS, 12)),

    Guardian_Shard_Cannon_Turreted(ItemGrade.Technology, "Turreted", new ItemEffectData
            (
                    new Pair<>(ItemEffect.shard_shell, 0d)
            ),
            new CostData(Material.GUARDIAN_WEAPONBLUEPRINT, 10),
            new CostData(Material.GUARDIAN_SENTINEL_WRECKAGECOMPONENTS, 28),
            new CostData(Material.GUARDIAN_TECHCOMPONENT, 40),
            new CostData(Material.CARBON, 30),
            new CostData(Commodity.MICROCONTROLLERS, 12));


    private final ItemGrade grade;
    private final CostData[] cost;
    private final ItemEffectData effects;
    private final String label;

    TechnologyRecipe(ItemGrade grade, String label, ItemEffectData effects, CostData... cost)
    {
        this.grade = grade;
        this.label = label;
        this.effects = effects;
        this.cost = cost;
    }

    @Override
    public ItemGrade getGrade()
    {
        return grade;
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
    }

    @Override
    public String getName()
    {
        return name();
    }
}
