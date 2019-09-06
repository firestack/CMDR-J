package com.controllerface.cmdr_j.classes.modules.core.lifesupport.size2;

import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.classes.modules.core.lifesupport.AbstractLifeSupport;

public class LifeSupport_2B extends AbstractLifeSupport
{
    public LifeSupport_2B()
    {
        super("2B Standard Life Support", 
            new ItemEffects(
                  new ItemEffectData(ItemEffect.Mass, 4.0),
                  new ItemEffectData(ItemEffect.Integrity, 56.0),
                  new ItemEffectData(ItemEffect.PowerDraw, 0.51),
                  new ItemEffectData(ItemEffect.BootTime, 1.0),
                  new ItemEffectData(ItemEffect.OxygenTimeCapacity, 900.0)
            ));
    }
}