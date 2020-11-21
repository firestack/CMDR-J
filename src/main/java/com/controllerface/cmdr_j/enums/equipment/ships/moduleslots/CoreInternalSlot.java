package com.controllerface.cmdr_j.enums.equipment.ships.moduleslots;

import com.controllerface.cmdr_j.classes.data.ItemEffectData;
import com.controllerface.cmdr_j.classes.commander.ShipModule;
import com.controllerface.cmdr_j.classes.commander.Statistic;
import com.controllerface.cmdr_j.enums.equipment.modules.stats.ItemEffect;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.controllerface.cmdr_j.enums.equipment.modules.CoreInternalModule.*;

/**
 * Created by Controllerface on 4/18/2018.
 */
public enum CoreInternalSlot implements Statistic
{
    Ship("Ship"),

    ShipIdent("Ship ID"),

    ShipName("Ship Name"),

    ShipCockpit("Cockpit"),

    CargoHatch("Cargo Hatch"),

    Armour("Bulkheads",
        adder_armour_grade1,
        adder_armour_grade2,
        adder_armour_grade3,
        adder_armour_mirrored,
        adder_armour_reactive,
        anaconda_armour_grade1,
        anaconda_armour_grade2,
        anaconda_armour_grade3,
        anaconda_armour_mirrored,
        anaconda_armour_reactive,
        asp_armour_grade1,
        asp_armour_grade2,
        asp_armour_grade3,
        asp_armour_mirrored,
        asp_armour_reactive,
        asp_scout_armour_grade1,
        asp_scout_armour_grade2,
        asp_scout_armour_grade3,
        asp_scout_armour_mirrored,
        asp_scout_armour_reactive,
        belugaliner_armour_grade1,
        belugaliner_armour_grade2,
        belugaliner_armour_grade3,
        belugaliner_armour_mirrored,
        belugaliner_armour_reactive,
        cobramkiii_armour_grade1,
        cobramkiii_armour_grade2,
        cobramkiii_armour_grade3,
        cobramkiii_armour_mirrored,
        cobramkiii_armour_reactive,
        cobramkiv_armour_grade1,
        cobramkiv_armour_grade2,
        cobramkiv_armour_grade3,
        cobramkiv_armour_mirrored,
        cobramkiv_armour_reactive,
        cutter_armour_grade1,
        cutter_armour_grade2,
        cutter_armour_grade3,
        cutter_armour_mirrored,
        cutter_armour_reactive,
        diamondback_armour_grade1,
        diamondback_armour_grade2,
        diamondback_armour_grade3,
        diamondback_armour_mirrored,
        diamondback_armour_reactive,
        diamondbackxl_armour_grade1,
        diamondbackxl_armour_grade2,
        diamondbackxl_armour_grade3,
        diamondbackxl_armour_mirrored,
        diamondbackxl_armour_reactive,
        dolphin_armour_grade1,
        dolphin_armour_grade2,
        dolphin_armour_grade3,
        dolphin_armour_mirrored,
        dolphin_armour_reactive,
        eagle_armour_grade1,
        eagle_armour_grade2,
        eagle_armour_grade3,
        eagle_armour_mirrored,
        eagle_armour_reactive,
        empire_courier_armour_grade1,
        empire_courier_armour_grade2,
        empire_courier_armour_grade3,
        empire_courier_armour_mirrored,
        empire_courier_armour_reactive,
        empire_eagle_armour_grade1,
        empire_eagle_armour_grade2,
        empire_eagle_armour_grade3,
        empire_eagle_armour_mirrored,
        empire_eagle_armour_reactive,
        empire_trader_armour_grade1,
        empire_trader_armour_grade2,
        empire_trader_armour_grade3,
        empire_trader_armour_mirrored,
        empire_trader_armour_reactive,
        federation_corvette_armour_grade1,
        federation_corvette_armour_grade2,
        federation_corvette_armour_grade3,
        federation_corvette_armour_mirrored,
        federation_corvette_armour_reactive,
        federation_dropship_armour_grade1,
        federation_dropship_armour_grade2,
        federation_dropship_armour_grade3,
        federation_dropship_armour_mirrored,
        federation_dropship_armour_reactive,
        federation_dropship_mkii_armour_grade1,
        federation_dropship_mkii_armour_grade2,
        federation_dropship_mkii_armour_grade3,
        federation_dropship_mkii_armour_mirrored,
        federation_dropship_mkii_armour_reactive,
        federation_gunship_armour_grade1,
        federation_gunship_armour_grade2,
        federation_gunship_armour_grade3,
        federation_gunship_armour_mirrored,
        federation_gunship_armour_reactive,
        ferdelance_armour_grade1,
        ferdelance_armour_grade2,
        ferdelance_armour_grade3,
        ferdelance_armour_mirrored,
        ferdelance_armour_reactive,
        hauler_armour_grade1,
        hauler_armour_grade2,
        hauler_armour_grade3,
        hauler_armour_mirrored,
        hauler_armour_reactive,
        independant_trader_armour_grade1,
        independant_trader_armour_grade2,
        independant_trader_armour_grade3,
        independant_trader_armour_mirrored,
        independant_trader_armour_reactive,
        krait_light_armour_grade1,
        krait_light_armour_grade2,
        krait_light_armour_grade3,
        krait_light_armour_mirrored,
        krait_light_armour_reactive,
        krait_mkii_armour_grade1,
        krait_mkii_armour_grade2,
        krait_mkii_armour_grade3,
        krait_mkii_armour_mirrored,
        krait_mkii_armour_reactive,
        mamba_armour_grade1,
        mamba_armour_grade2,
        mamba_armour_grade3,
        mamba_armour_mirrored,
        mamba_armour_reactive,
        orca_armour_grade1,
        orca_armour_grade2,
        orca_armour_grade3,
        orca_armour_mirrored,
        orca_armour_reactive,
        python_armour_grade1,
        python_armour_grade2,
        python_armour_grade3,
        python_armour_mirrored,
        python_armour_reactive,
        sidewinder_armour_grade1,
        sidewinder_armour_grade2,
        sidewinder_armour_grade3,
        sidewinder_armour_mirrored,
        sidewinder_armour_reactive,
        type6_armour_grade1,
        type6_armour_grade2,
        type6_armour_grade3,
        type6_armour_mirrored,
        type6_armour_reactive,
        type7_armour_grade1,
        type7_armour_grade2,
        type7_armour_grade3,
        type7_armour_mirrored,
        type7_armour_reactive,
        type9_armour_grade1,
        type9_armour_grade2,
        type9_armour_grade3,
        type9_armour_mirrored,
        type9_armour_reactive,
        type9_military_armour_grade1,
        type9_military_armour_grade2,
        type9_military_armour_grade3,
        type9_military_armour_mirrored,
        type9_military_armour_reactive,
        typex_2_armour_grade1,
        typex_2_armour_grade2,
        typex_2_armour_grade3,
        typex_2_armour_mirrored,
        typex_2_armour_reactive,
        typex_3_armour_grade1,
        typex_3_armour_grade2,
        typex_3_armour_grade3,
        typex_3_armour_mirrored,
        typex_3_armour_reactive,
        typex_armour_grade1,
        typex_armour_grade2,
        typex_armour_grade3,
        typex_armour_mirrored,
        typex_armour_reactive,
        viper_armour_grade1,
        viper_armour_grade2,
        viper_armour_grade3,
        viper_armour_mirrored,
        viper_armour_reactive,
        viper_mkiv_armour_grade1,
        viper_mkiv_armour_grade2,
        viper_mkiv_armour_grade3,
        viper_mkiv_armour_mirrored,
        viper_mkiv_armour_reactive,
        vulture_armour_grade1,
        vulture_armour_grade2,
        vulture_armour_grade3,
        vulture_armour_mirrored,
        vulture_armour_reactive),

    PowerPlant("Reactor Bay",
        int_powerplant_size2_class1,
        int_powerplant_size2_class2,
        int_powerplant_size2_class3,
        int_powerplant_size2_class4,
        int_powerplant_size2_class5,
        int_guardianpowerplant_size2,
        int_powerplant_size3_class1,
        int_powerplant_size3_class2,
        int_powerplant_size3_class3,
        int_powerplant_size3_class4,
        int_powerplant_size3_class5,
        int_guardianpowerplant_size3,
        int_powerplant_size4_class1,
        int_powerplant_size4_class2,
        int_powerplant_size4_class3,
        int_powerplant_size4_class4,
        int_powerplant_size4_class5,
        int_guardianpowerplant_size4,
        int_powerplant_size5_class1,
        int_powerplant_size5_class2,
        int_powerplant_size5_class3,
        int_powerplant_size5_class4,
        int_powerplant_size5_class5,
        int_guardianpowerplant_size5,
        int_powerplant_size6_class1,
        int_powerplant_size6_class2,
        int_powerplant_size6_class3,
        int_powerplant_size6_class4,
        int_powerplant_size6_class5,
        int_guardianpowerplant_size6,
        int_powerplant_size7_class1,
        int_powerplant_size7_class2,
        int_powerplant_size7_class3,
        int_powerplant_size7_class4,
        int_powerplant_size7_class5,
        int_guardianpowerplant_size7,
        int_powerplant_size8_class1,
        int_powerplant_size8_class2,
        int_powerplant_size8_class3,
        int_powerplant_size8_class4,
        int_powerplant_size8_class5,
        int_guardianpowerplant_size8),

    MainEngines("Main Engines",
        int_engine_size2_class1,
        int_engine_size2_class2,
        int_engine_size2_class3,
        int_engine_size2_class4,
        int_engine_size2_class5,
        int_engine_size2_class5_fast,
        int_engine_size3_class1,
        int_engine_size3_class2,
        int_engine_size3_class3,
        int_engine_size3_class4,
        int_engine_size3_class5,
        int_engine_size3_class5_fast,
        int_engine_size4_class1,
        int_engine_size4_class2,
        int_engine_size4_class3,
        int_engine_size4_class4,
        int_engine_size4_class5,
        int_engine_size5_class1,
        int_engine_size5_class2,
        int_engine_size5_class3,
        int_engine_size5_class4,
        int_engine_size5_class5,
        int_engine_size6_class1,
        int_engine_size6_class2,
        int_engine_size6_class3,
        int_engine_size6_class4,
        int_engine_size6_class5,
        int_engine_size7_class1,
        int_engine_size7_class2,
        int_engine_size7_class3,
        int_engine_size7_class4,
        int_engine_size7_class5,
        int_engine_size8_class1,
        int_engine_size8_class2,
        int_engine_size8_class3,
        int_engine_size8_class4,
        int_engine_size8_class5),

    FrameShiftDrive("Hyper Drive",
        int_hyperdrive_size2_class1,
        int_hyperdrive_size2_class2,
        int_hyperdrive_size2_class3,
        int_hyperdrive_size2_class4,
        int_hyperdrive_size2_class5,
        int_hyperdrive_size3_class1,
        int_hyperdrive_size3_class2,
        int_hyperdrive_size3_class3,
        int_hyperdrive_size3_class4,
        int_hyperdrive_size3_class5,
        int_hyperdrive_size4_class1,
        int_hyperdrive_size4_class2,
        int_hyperdrive_size4_class3,
        int_hyperdrive_size4_class4,
        int_hyperdrive_size4_class5,
        int_hyperdrive_size5_class1,
        int_hyperdrive_size5_class2,
        int_hyperdrive_size5_class3,
        int_hyperdrive_size5_class4,
        int_hyperdrive_size5_class5,
        int_hyperdrive_size6_class1,
        int_hyperdrive_size6_class2,
        int_hyperdrive_size6_class3,
        int_hyperdrive_size6_class4,
        int_hyperdrive_size6_class5,
        int_hyperdrive_size7_class1,
        int_hyperdrive_size7_class2,
        int_hyperdrive_size7_class3,
        int_hyperdrive_size7_class4,
        int_hyperdrive_size7_class5),

    LifeSupport("Life Support",
        int_lifesupport_size1_class1,
        int_lifesupport_size1_class2,
        int_lifesupport_size1_class3,
        int_lifesupport_size1_class4,
        int_lifesupport_size1_class5,
        int_lifesupport_size2_class1,
        int_lifesupport_size2_class2,
        int_lifesupport_size2_class3,
        int_lifesupport_size2_class4,
        int_lifesupport_size2_class5,
        int_lifesupport_size3_class1,
        int_lifesupport_size3_class2,
        int_lifesupport_size3_class3,
        int_lifesupport_size3_class4,
        int_lifesupport_size3_class5,
        int_lifesupport_size4_class1,
        int_lifesupport_size4_class2,
        int_lifesupport_size4_class3,
        int_lifesupport_size4_class4,
        int_lifesupport_size4_class5,
        int_lifesupport_size5_class1,
        int_lifesupport_size5_class2,
        int_lifesupport_size5_class3,
        int_lifesupport_size5_class4,
        int_lifesupport_size5_class5,
        int_lifesupport_size6_class1,
        int_lifesupport_size6_class2,
        int_lifesupport_size6_class3,
        int_lifesupport_size6_class4,
        int_lifesupport_size6_class5,
        int_lifesupport_size7_class1,
        int_lifesupport_size7_class2,
        int_lifesupport_size7_class3,
        int_lifesupport_size7_class4,
        int_lifesupport_size7_class5,
        int_lifesupport_size8_class1,
        int_lifesupport_size8_class2,
        int_lifesupport_size8_class3,
        int_lifesupport_size8_class4,
        int_lifesupport_size8_class5),

    PowerDistributor("Power Coupling",
        int_powerdistributor_size1_class1,
        int_powerdistributor_size1_class2,
        int_powerdistributor_size1_class3,
        int_powerdistributor_size1_class4,
        int_powerdistributor_size1_class5,
        int_guardianpowerdistributor_size1,
        int_powerdistributor_size2_class1,
        int_powerdistributor_size2_class2,
        int_powerdistributor_size2_class3,
        int_powerdistributor_size2_class4,
        int_powerdistributor_size2_class5,
        int_guardianpowerdistributor_size2,
        int_powerdistributor_size3_class1,
        int_powerdistributor_size3_class2,
        int_powerdistributor_size3_class3,
        int_powerdistributor_size3_class4,
        int_powerdistributor_size3_class5,
        int_guardianpowerdistributor_size3,
        int_powerdistributor_size4_class1,
        int_powerdistributor_size4_class2,
        int_powerdistributor_size4_class3,
        int_powerdistributor_size4_class4,
        int_powerdistributor_size4_class5,
        int_guardianpowerdistributor_size4,
        int_powerdistributor_size5_class1,
        int_powerdistributor_size5_class2,
        int_powerdistributor_size5_class3,
        int_powerdistributor_size5_class4,
        int_powerdistributor_size5_class5,
        int_guardianpowerdistributor_size5,
        int_powerdistributor_size6_class1,
        int_powerdistributor_size6_class2,
        int_powerdistributor_size6_class3,
        int_powerdistributor_size6_class4,
        int_powerdistributor_size6_class5,
        int_guardianpowerdistributor_size6,
        int_powerdistributor_size7_class1,
        int_powerdistributor_size7_class2,
        int_powerdistributor_size7_class3,
        int_powerdistributor_size7_class4,
        int_powerdistributor_size7_class5,
        int_guardianpowerdistributor_size7,
        int_powerdistributor_size8_class1,
        int_powerdistributor_size8_class2,
        int_powerdistributor_size8_class3,
        int_powerdistributor_size8_class4,
        int_powerdistributor_size8_class5,
        int_guardianpowerdistributor_size8),

    Radar("Sensor Suite",
        int_sensors_size1_class1,
        int_sensors_size1_class2,
        int_sensors_size1_class3,
        int_sensors_size1_class4,
        int_sensors_size1_class5,
        int_sensors_size2_class1,
        int_sensors_size2_class2,
        int_sensors_size2_class3,
        int_sensors_size2_class4,
        int_sensors_size2_class5,
        int_sensors_size3_class1,
        int_sensors_size3_class2,
        int_sensors_size3_class3,
        int_sensors_size3_class4,
        int_sensors_size3_class5,
        int_sensors_size4_class1,
        int_sensors_size4_class2,
        int_sensors_size4_class3,
        int_sensors_size4_class4,
        int_sensors_size4_class5,
        int_sensors_size5_class1,
        int_sensors_size5_class2,
        int_sensors_size5_class3,
        int_sensors_size5_class4,
        int_sensors_size5_class5,
        int_sensors_size6_class1,
        int_sensors_size6_class2,
        int_sensors_size6_class3,
        int_sensors_size6_class4,
        int_sensors_size6_class5,
        int_sensors_size7_class1,
        int_sensors_size7_class2,
        int_sensors_size7_class3,
        int_sensors_size7_class4,
        int_sensors_size7_class5,
        int_sensors_size8_class1,
        int_sensors_size8_class2,
        int_sensors_size8_class3,
        int_sensors_size8_class4,
        int_sensors_size8_class5),

    FuelTank("Fuel Tank",
        int_fueltank_size1_class3,
        int_fueltank_size2_class3,
        int_fueltank_size3_class3,
        int_fueltank_size4_class3,
        int_fueltank_size5_class3,
        int_fueltank_size6_class3,
        int_fueltank_size7_class3,
        int_fueltank_size8_class3),

    ;

    private final String text;
    private final ShipModule[] compatibleModules;

    CoreInternalSlot(String text, ShipModule... compatibleModules)
    {
        this.text = text;
        this.compatibleModules = compatibleModules;
    }

    @Override
    public String getName()
    {
        return name();
    }

    @Override
    public String getText()
    {
        return text;
    }

    @Override
    public String format(Object raw)
    {
        return raw.toString();
    }

    public static boolean typeMatches(Statistic statistic)
    {
        return Arrays.stream(CoreInternalSlot.values()).anyMatch(v -> v.equals(statistic));
    }

    public List<ShipModule> findModulesBySize(int size)
    {
        return Stream.of(compatibleModules)
            .filter(module -> module.itemEffects().effectByName(ItemEffect.Size)
                .map(ItemEffectData::getDoubleValue)
                .map(Double::intValue)
                .filter(moduleSize -> moduleSize <= size)
                .isPresent())
            .collect(Collectors.toList());
    }

    public List<ShipModule> findModulesByExactSize(int size)
    {
        return Stream.of(compatibleModules)
            .filter(module -> module.itemEffects().effectByName(ItemEffect.Size)
                .map(ItemEffectData::getDoubleValue)
                .map(Double::intValue)
                .filter(moduleSize -> moduleSize == size)
                .isPresent())
            .collect(Collectors.toList());
    }
}
