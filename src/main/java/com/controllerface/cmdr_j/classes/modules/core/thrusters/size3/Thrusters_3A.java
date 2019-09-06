package com.controllerface.cmdr_j.classes.modules.core.thrusters.size3;

import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.classes.modules.core.thrusters.AbstractThrusters;

public class Thrusters_3A extends AbstractThrusters
{
    public Thrusters_3A()
    {
        super("3A Standard Thrusters", 
            new ItemEffects(
                  new ItemEffectData(ItemEffect.Mass, 5.0),
                  new ItemEffectData(ItemEffect.Integrity, 70.0),
                  new ItemEffectData(ItemEffect.PowerDraw, 3.72),
                  new ItemEffectData(ItemEffect.BootTime, 0.0),
                  new ItemEffectData(ItemEffect.EngineMinimumMass, 60.0),
                  new ItemEffectData(ItemEffect.EngineOptimalMass, 120.0),
                  new ItemEffectData(ItemEffect.MaximumMass, 180.0),
                  new ItemEffectData(ItemEffect.EngineMinPerformance, 96.0),
                  new ItemEffectData(ItemEffect.EngineOptPerformance, 100.0),
                  new ItemEffectData(ItemEffect.EngineMaxPerformance, 16.0),
                  new ItemEffectData(ItemEffect.EngineHeatRate, 1.3)
            ));
    }
}