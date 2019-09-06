package com.controllerface.cmdr_j.classes.modules.core.sensors.size5;

import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.classes.modules.core.sensors.AbstractSensors;

public class Sensors_5E extends AbstractSensors
{
    public Sensors_5E()
    {
        super("5E Standard Sensors", 
            new ItemEffects(
                  new ItemEffectData(ItemEffect.Mass, 20.0),
                  new ItemEffectData(ItemEffect.Integrity, 86.0),
                  new ItemEffectData(ItemEffect.PowerDraw, 0.33),
                  new ItemEffectData(ItemEffect.BootTime, 5.0),
                  new ItemEffectData(ItemEffect.SensorTargetScanAngle, 30.0),
                  new ItemEffectData(ItemEffect.MaxRange, 8000.0),
                  new ItemEffectData(ItemEffect.Range, 4640.0)
            ));
    }
}