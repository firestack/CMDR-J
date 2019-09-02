package com.controllerface.cmdr_j.classes.procurements.recipes.fsd.longrange;

import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.procurements.CostData;
import com.controllerface.cmdr_j.classes.procurements.recipes.AbstractModificationRecipe;
import com.controllerface.cmdr_j.enums.costs.materials.Material;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.enums.equipment.ItemGrade;

public class FSD_LongRange_2 extends AbstractModificationRecipe
{
    public FSD_LongRange_2()
    {
        super(FSD_LongRange_2.class.getSimpleName(), ItemGrade.GRADE_2,
                new ItemEffects
                        (
                                new ItemEffectData(ItemEffect.Integrity, -6d),
                                new ItemEffectData(ItemEffect.Mass, 15d),
                                new ItemEffectData(ItemEffect.FSDOptimalMass, 25d),
                                new ItemEffectData(ItemEffect.PowerDraw, 6d)
                        ),
                new CostData(Material.DISRUPTEDWAKEECHOES, 1),
                new CostData(Material.CHEMICALPROCESSORS, 1));
    }
}
