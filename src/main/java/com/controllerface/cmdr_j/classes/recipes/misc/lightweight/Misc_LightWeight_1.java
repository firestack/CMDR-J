package com.controllerface.cmdr_j.classes.recipes.misc.lightweight;

import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.procurements.CostData;
import com.controllerface.cmdr_j.classes.recipes.AbstractModificationRecipe;
import com.controllerface.cmdr_j.enums.costs.materials.Material;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.enums.equipment.ItemGrade;

public class Misc_LightWeight_1 extends AbstractModificationRecipe
{
    public Misc_LightWeight_1()
    {
        super(Misc_LightWeight_1.class.getSimpleName(), ItemGrade.GRADE_1,
                new ItemEffects
                        (
                                new ItemEffectData(ItemEffect.Integrity, -10d),
                                new ItemEffectData(ItemEffect.Mass, -45d)
                        ),
                new CostData(Material.PHOSPHORUS, 1));
    }
}