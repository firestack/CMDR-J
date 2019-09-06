package com.controllerface.cmdr_j.classes.modules.core.powerplant.size2;

import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.classes.modules.core.powerplant.AbstractPowerPlant;

public class PowerPlant_2E extends AbstractPowerPlant
{
    public PowerPlant_2E()
    {
        super("2E Standard Power Plant", 
            new ItemEffects(
                  new ItemEffectData(ItemEffect.Mass, 2.5),
                  new ItemEffectData(ItemEffect.Integrity, 46.0),
                  new ItemEffectData(ItemEffect.PowerCapacity, 6.4),
                  new ItemEffectData(ItemEffect.HeatEfficiency, 1.0)
            ));
    }
}