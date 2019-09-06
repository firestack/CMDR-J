package com.controllerface.cmdr_j.classes.modules.core.powerplant.size6;

import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.classes.modules.core.powerplant.AbstractPowerPlant;

public class PowerPlant_6C extends AbstractPowerPlant
{
    public PowerPlant_6C()
    {
        super("6C Standard Power Plant", 
            new ItemEffects(
                  new ItemEffectData(ItemEffect.Mass, 20.0),
                  new ItemEffectData(ItemEffect.Integrity, 113.0),
                  new ItemEffectData(ItemEffect.PowerCapacity, 2.1),
                  new ItemEffectData(ItemEffect.HeatEfficiency, 0.5)
            ));
    }
}