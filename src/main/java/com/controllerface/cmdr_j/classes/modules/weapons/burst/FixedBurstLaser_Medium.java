package com.controllerface.cmdr_j.classes.modules.weapons.burst;

import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;

public class FixedBurstLaser_Medium extends AbstractBurstLaser
{
    public FixedBurstLaser_Medium()
    {
        super("Medium Fixed Burst Laser", 
            new ItemEffects(
                  new ItemEffectData(ItemEffect.Mass, 4.0),
                  new ItemEffectData(ItemEffect.Integrity, 40.0),
                  new ItemEffectData(ItemEffect.PowerDraw, 1.05),
                  new ItemEffectData(ItemEffect.DamagePerSecond, 13.045),
                  new ItemEffectData(ItemEffect.Damage, 3.53),
                  new ItemEffectData(ItemEffect.DistributorDraw, 0.5),
                  new ItemEffectData(ItemEffect.ThermalLoad, 0.78),
                  new ItemEffectData(ItemEffect.ArmourPenetration, 35.0),
                  new ItemEffectData(ItemEffect.MaximumRange, 3000.0),
                  new ItemEffectData(ItemEffect.RateOfFire, 3.695),
                  new ItemEffectData(ItemEffect.BurstRateOfFire, 11.0),
                  new ItemEffectData(ItemEffect.BurstSize, 3.0),
                  new ItemEffectData(ItemEffect.BreachDamage, 3.0),
                  new ItemEffectData(ItemEffect.MinBreachChance, 40.0),
                  new ItemEffectData(ItemEffect.MaxBreachChance, 80.0),
                  new ItemEffectData(ItemEffect.DamageType, "Thermal"),
                  new ItemEffectData(ItemEffect.DamageFalloffRange, 500.0)
            ));
    }
}