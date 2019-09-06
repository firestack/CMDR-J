package com.controllerface.cmdr_j.classes.modules.shields.shieldcells.size5;

import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.modules.shields.shieldcells.AbstractShieldCellBank;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.classes.modules.AbstractModule;
import com.controllerface.cmdr_j.enums.craftable.experimentals.ExperimentalType;
import com.controllerface.cmdr_j.enums.craftable.modifications.ModificationType;

public class ShieldCellBank_5E extends AbstractShieldCellBank
{
    public ShieldCellBank_5E()
    {
        super("5E Shield Cell Bank",
            new ItemEffects(
                  new ItemEffectData(ItemEffect.Mass, 20.0),
                  new ItemEffectData(ItemEffect.Integrity, 77.0),
                  new ItemEffectData(ItemEffect.PowerDraw, 0.9),
                  new ItemEffectData(ItemEffect.BootTime, 25.0),
                  new ItemEffectData(ItemEffect.ShieldBankSpinUp, 5.0),
                  new ItemEffectData(ItemEffect.ShieldBankReinforcement, 21.0),
                  new ItemEffectData(ItemEffect.ShieldBankHeat, 540.0),
                  new ItemEffectData(ItemEffect.AmmoClipSize, 1.0),
                  new ItemEffectData(ItemEffect.AmmoMaximum, 4.0),
                  new ItemEffectData(ItemEffect.ShieldBankDuration, 5.1)
            ));
    }
}