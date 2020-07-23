package com.controllerface.cmdr_j.classes.recipes.shieldcellbank.specialized;

import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.tasks.CostData;
import com.controllerface.cmdr_j.classes.recipes.AbstractModificationRecipe;
import com.controllerface.cmdr_j.enums.costs.materials.Material;
import com.controllerface.cmdr_j.enums.equipment.modules.stats.ItemEffect;
import com.controllerface.cmdr_j.enums.equipment.modules.stats.ItemGrade;

public class ShieldCellBank_Specialized_1 extends AbstractModificationRecipe
{
    public ShieldCellBank_Specialized_1()
    {
        super(ShieldCellBank_Specialized_1.class.getSimpleName(), ItemGrade.GRADE_1,
                new ItemEffects
                        (
                                new ItemEffectData(ItemEffect.BootTime, -8d),
                                new ItemEffectData(ItemEffect.Integrity, -5d),
                                new ItemEffectData(ItemEffect.PowerDraw, 10d),
                                new ItemEffectData(ItemEffect.ShieldBankReinforcement, 4d),
                                new ItemEffectData(ItemEffect.ThermalLoad, -6d)
                        ),
                new CostData(Material.LEGACYFIRMWARE, 1));
    }
}
