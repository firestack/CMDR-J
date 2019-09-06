package com.controllerface.cmdr_j.classes.modules.limpets.collectorlimpet.size1;

import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.modules.limpets.collectorlimpet.AbstractCollectorLimpet;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;

public class CollectorLimpet_1D extends AbstractCollectorLimpet
{
    public CollectorLimpet_1D()
    {
        super("1D Collector Limpet Controller",
                new ItemEffects(
                        new ItemEffectData(ItemEffect.Mass, 0.5d),
                        new ItemEffectData(ItemEffect.Integrity, 32d),
                        new ItemEffectData(ItemEffect.PowerDraw, 0.18d),
                        new ItemEffectData(ItemEffect.BootTime, 6d),
                        new ItemEffectData(ItemEffect.MaxActiveDrones, 1d),
                        new ItemEffectData(ItemEffect.DroneTargetRange, 600d),
                        new ItemEffectData(ItemEffect.DroneLifeTime, 600d),
                        new ItemEffectData(ItemEffect.DroneSpeed, 200d),
                        new ItemEffectData(ItemEffect.DroneMultiTargetSpeed, 60d)
                ));
    }
}