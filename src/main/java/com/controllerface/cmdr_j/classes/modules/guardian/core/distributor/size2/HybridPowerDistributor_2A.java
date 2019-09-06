package com.controllerface.cmdr_j.classes.modules.guardian.core.distributor.size2;

import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.modules.guardian.AbstractGuardianModule;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;

public class HybridPowerDistributor_2A extends AbstractGuardianModule
{
    public HybridPowerDistributor_2A()
    {
        super("2A Guardian Hybrid Power Distributor",
                new ItemEffects(
                        new ItemEffectData(ItemEffect.guardian, 1d)
                ));
    }
}