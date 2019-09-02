package com.controllerface.cmdr_j.classes.procurements.recipes.hullreinforcement.thermic;

import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.procurements.CostData;
import com.controllerface.cmdr_j.classes.procurements.recipes.AbstractModificationRecipe;
import com.controllerface.cmdr_j.enums.costs.materials.Material;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.enums.equipment.ItemGrade;

public class HullReinforcement_Thermic_2 extends AbstractModificationRecipe
{
    public HullReinforcement_Thermic_2()
    {
        super(HullReinforcement_Thermic_2.class.getSimpleName(), ItemGrade.GRADE_2,
                new ItemEffects
                        (
                                new ItemEffectData(ItemEffect.ExplosiveResistance, -4d),
                                new ItemEffectData(ItemEffect.DefenceModifierHealthAddition, 6d),
                                new ItemEffectData(ItemEffect.KineticResistance, -4d),
                                new ItemEffectData(ItemEffect.ThermicResistance, 18.5d)
                        ),
                new CostData(Material.HEATDISPERSIONPLATE, 1),
                new CostData(Material.NICKEL, 1));
    }
}
