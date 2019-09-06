package com.controllerface.cmdr_j.classes.modules.optional.afmu.size3;

import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.modules.optional.afmu.AbstractAFMU;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;

public class AFMU_3D extends AbstractAFMU
{
    public AFMU_3D()
    {
        super("3D Automated Field Maintenance Unit",
                new ItemEffects(
                        new ItemEffectData(ItemEffect.Integrity, 38d),
                        new ItemEffectData(ItemEffect.PowerDraw, 1.08d),
                        new ItemEffectData(ItemEffect.BootTime, 9d),
                        new ItemEffectData(ItemEffect.AFMRepairCapacity, 3200d),
                        new ItemEffectData(ItemEffect.AFMRepairConsumption, 10d),
                        new ItemEffectData(ItemEffect.AFMRepairPerAmmo, 0.016d)
                ));
    }
}