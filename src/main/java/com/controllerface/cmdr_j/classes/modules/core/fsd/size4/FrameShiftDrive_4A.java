package com.controllerface.cmdr_j.classes.modules.core.fsd.size4;

import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.classes.modules.core.fsd.AbstractFSD;

public class FrameShiftDrive_4A extends AbstractFSD
{
    public FrameShiftDrive_4A()
    {
        super("4A Standard Frame Shift Drive", 
            new ItemEffects(
                  new ItemEffectData(ItemEffect.Mass, 10.0),
                  new ItemEffectData(ItemEffect.Integrity, 100.0),
                  new ItemEffectData(ItemEffect.PowerDraw, 0.45),
                  new ItemEffectData(ItemEffect.BootTime, 10.0),
                  new ItemEffectData(ItemEffect.FSDOptimalMass, 525.0),
                  new ItemEffectData(ItemEffect.ThermalLoad, 18.0),
                  new ItemEffectData(ItemEffect.MaxFuelPerJump, 3.0)
            ));
    }
}