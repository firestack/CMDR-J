package com.controllerface.cmdr_j.classes.modules.core.lifesupport.size5;

import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.classes.modules.core.lifesupport.AbstractLifeSupport;

public class LifeSupport_5A extends AbstractLifeSupport
{
    public LifeSupport_5A()
    {
        super("5A Standard Life Support", 
            new ItemEffects(
                  new ItemEffectData(ItemEffect.Mass, 20.0),
                  new ItemEffectData(ItemEffect.Integrity, 115.0),
                  new ItemEffectData(ItemEffect.PowerDraw, 0.85),
                  new ItemEffectData(ItemEffect.BootTime, 1.0),
                  new ItemEffectData(ItemEffect.OxygenTimeCapacity, 1500.0)
            ));
    }
}