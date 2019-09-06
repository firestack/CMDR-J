package com.controllerface.cmdr_j.classes.modules.core.distributor.size1;

import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.classes.modules.core.distributor.AbstractPowerDistributor;

public class PowerDistributor_1C extends AbstractPowerDistributor
{
    public PowerDistributor_1C()
    {
        super("1C Standard Power Distributor", 
            new ItemEffects(
                  new ItemEffectData(ItemEffect.Mass, 1.3),
                  new ItemEffectData(ItemEffect.Integrity, 40.0),
                  new ItemEffectData(ItemEffect.PowerDraw, 0.4),
                  new ItemEffectData(ItemEffect.BootTime, 5.0),
                  new ItemEffectData(ItemEffect.WeaponsCapacity, 12.0),
                  new ItemEffectData(ItemEffect.WeaponsRecharge, 1.5),
                  new ItemEffectData(ItemEffect.EnginesCapacity, 10.0),
                  new ItemEffectData(ItemEffect.EnginesRecharge, 0.5),
                  new ItemEffectData(ItemEffect.SystemsCapacity, 10.0),
                  new ItemEffectData(ItemEffect.SystemsRecharge, 0.5)
            ));
    }
}