package com.controllerface.cmdr_j.classes.modules.shields.shieldcells.size3;

import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.modules.shields.shieldcells.AbstractShieldCellBank;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.classes.modules.AbstractModule;
import com.controllerface.cmdr_j.enums.craftable.experimentals.ExperimentalType;
import com.controllerface.cmdr_j.enums.craftable.modifications.ModificationType;

public class ShieldCellBank_3A extends AbstractShieldCellBank
{
    public ShieldCellBank_3A()
    {
        super("3A Shield Cell Bank",
            new ItemEffects(
                  new ItemEffectData(ItemEffect.Mass, 5.0),
                  new ItemEffectData(ItemEffect.Integrity, 77.0),
                  new ItemEffectData(ItemEffect.PowerDraw, 1.43),
                  new ItemEffectData(ItemEffect.BootTime, 25.0),
                  new ItemEffectData(ItemEffect.ShieldBankSpinUp, 5.0),
                  new ItemEffectData(ItemEffect.ShieldBankReinforcement, 41.0),
                  new ItemEffectData(ItemEffect.ShieldBankHeat, 340.0),
                  new ItemEffectData(ItemEffect.AmmoClipSize, 1.0),
                  new ItemEffectData(ItemEffect.AmmoMaximum, 3.0),
                  new ItemEffectData(ItemEffect.ShieldBankDuration, 2.3)
            ));
    }
}