package com.controllerface.cmdr_j.classes.modules.core.sensors.size2;

import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.classes.modules.core.sensors.AbstractSensors;

public class Sensors_2B extends AbstractSensors
{
    public Sensors_2B()
    {
        super("2B Standard Sensors", 
            new ItemEffects(
                  new ItemEffectData(ItemEffect.Mass, 4.0),
                  new ItemEffectData(ItemEffect.Integrity, 61.0),
                  new ItemEffectData(ItemEffect.PowerDraw, 0.38),
                  new ItemEffectData(ItemEffect.BootTime, 5.0),
                  new ItemEffectData(ItemEffect.SensorTargetScanAngle, 30.0),
                  new ItemEffectData(ItemEffect.MaxRange, 8000.0),
                  new ItemEffectData(ItemEffect.Range, 5720.0)
            ));
    }
}