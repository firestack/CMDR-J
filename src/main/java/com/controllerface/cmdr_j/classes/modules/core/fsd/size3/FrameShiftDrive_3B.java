package com.controllerface.cmdr_j.classes.modules.core.fsd.size3;

import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.classes.modules.core.fsd.AbstractFSD;

public class FrameShiftDrive_3B extends AbstractFSD
{
    public FrameShiftDrive_3B()
    {
        super("3B Standard Frame Shift Drive", 
            new ItemEffects(
                  new ItemEffectData(ItemEffect.Mass, 8.0),
                  new ItemEffectData(ItemEffect.Integrity, 96.0),
                  new ItemEffectData(ItemEffect.PowerDraw, 0.38),
                  new ItemEffectData(ItemEffect.BootTime, 10.0),
                  new ItemEffectData(ItemEffect.FSDOptimalMass, 125.0),
                  new ItemEffectData(ItemEffect.ThermalLoad, 14.0),
                  new ItemEffectData(ItemEffect.MaxFuelPerJump, 1.5)
            ));
    }
}