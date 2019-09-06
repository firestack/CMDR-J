package com.controllerface.cmdr_j.classes.modules.shields.shieldcells.size1;

import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.modules.shields.shieldcells.AbstractShieldCellBank;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.classes.modules.AbstractModule;
import com.controllerface.cmdr_j.enums.craftable.experimentals.ExperimentalType;
import com.controllerface.cmdr_j.enums.craftable.modifications.ModificationType;

public class ShieldCellBank_1D extends AbstractShieldCellBank
{
    public ShieldCellBank_1D()
    {
        super("1D Shield Cell Bank",
            new ItemEffects(
                  new ItemEffectData(ItemEffect.Mass, 0.5),
                  new ItemEffectData(ItemEffect.Integrity, 24.0),
                  new ItemEffectData(ItemEffect.PowerDraw, 0.55),
                  new ItemEffectData(ItemEffect.BootTime, 25.0),
                  new ItemEffectData(ItemEffect.ShieldBankSpinUp, 5.0),
                  new ItemEffectData(ItemEffect.ShieldBankReinforcement, 16.0),
                  new ItemEffectData(ItemEffect.ShieldBankHeat, 170.0),
                  new ItemEffectData(ItemEffect.AmmoClipSize, 1.0),
                  new ItemEffectData(ItemEffect.AmmoMaximum, 1.0),
                  new ItemEffectData(ItemEffect.ShieldBankDuration, 1.0)
            ));
    }
}