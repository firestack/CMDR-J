package com.controllerface.cmdr_j.classes.modules.shields.generators.size3;

import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.modules.shields.generators.AbstractShieldGenerator;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;

public class ShieldGenerator_3B extends AbstractShieldGenerator
{
    public ShieldGenerator_3B()
    {
        super("3B Shield Generator",
            new ItemEffects(
                  new ItemEffectData(ItemEffect.Mass, 8.0),
                  new ItemEffectData(ItemEffect.Integrity, 90.0),
                  new ItemEffectData(ItemEffect.PowerDraw, 2.16),
                  new ItemEffectData(ItemEffect.BootTime, 1.0),
                  new ItemEffectData(ItemEffect.ShieldGenMinimumMass, 83.0),
                  new ItemEffectData(ItemEffect.ShieldGenOptimalMass, 165.0),
                  new ItemEffectData(ItemEffect.ShieldGenMaximumMass, 413.0),
                  new ItemEffectData(ItemEffect.ShieldGenMinStrength, 60.0),
                  new ItemEffectData(ItemEffect.ShieldGenStrength, 110.0),
                  new ItemEffectData(ItemEffect.ShieldGenMaxStrength, 160.0),
                  new ItemEffectData(ItemEffect.RegenRate, 1.0),
                  new ItemEffectData(ItemEffect.BrokenRegenRate, 1.87),
                  new ItemEffectData(ItemEffect.DistributorDraw, 0.6),
                  new ItemEffectData(ItemEffect.ThermalLoad, 1.2),
                  new ItemEffectData(ItemEffect.KineticResistance, 40.0),
                  new ItemEffectData(ItemEffect.ThermicResistance, -20.0),
                  new ItemEffectData(ItemEffect.ExplosiveResistance, 50.0)
            ));
    }
}