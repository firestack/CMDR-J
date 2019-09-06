package com.controllerface.cmdr_j.classes.modules.core.lifesupport.size5;

import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.classes.modules.core.lifesupport.AbstractLifeSupport;

public class LifeSupport_5B extends AbstractLifeSupport
{
    public LifeSupport_5B()
    {
        super("5B Standard Life Support", 
            new ItemEffects(
                  new ItemEffectData(ItemEffect.Mass, 32.0),
                  new ItemEffectData(ItemEffect.Integrity, 106.0),
                  new ItemEffectData(ItemEffect.PowerDraw, 0.78),
                  new ItemEffectData(ItemEffect.BootTime, 1.0),
                  new ItemEffectData(ItemEffect.OxygenTimeCapacity, 900.0)
            ));
    }
}