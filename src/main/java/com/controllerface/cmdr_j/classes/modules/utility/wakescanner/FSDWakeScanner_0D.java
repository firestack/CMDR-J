package com.controllerface.cmdr_j.classes.modules.utility.wakescanner;

import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;

public class FSDWakeScanner_0D extends AbstractWakeScanner
{
    public FSDWakeScanner_0D()
    {
        super("0D FSD Wake Scanner", 
            new ItemEffects(
                  new ItemEffectData(ItemEffect.Mass, 1.3),
                  new ItemEffectData(ItemEffect.Integrity, 24.0),
                  new ItemEffectData(ItemEffect.PowerDraw, 0.4),
                  new ItemEffectData(ItemEffect.BootTime, 1.0),
                  new ItemEffectData(ItemEffect.ScannerRange, 2500.0),
                  new ItemEffectData(ItemEffect.MaxAngle, 15.0),
                  new ItemEffectData(ItemEffect.ScannerTimeToScan, 10.0)
            ));
    }
}