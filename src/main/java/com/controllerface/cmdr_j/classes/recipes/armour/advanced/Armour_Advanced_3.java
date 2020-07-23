package com.controllerface.cmdr_j.classes.recipes.armour.advanced;

import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.tasks.CostData;
import com.controllerface.cmdr_j.classes.recipes.AbstractModificationRecipe;
import com.controllerface.cmdr_j.enums.costs.materials.Material;
import com.controllerface.cmdr_j.enums.equipment.modules.stats.ItemEffect;
import com.controllerface.cmdr_j.enums.equipment.modules.stats.ItemGrade;

public class Armour_Advanced_3 extends AbstractModificationRecipe
{
    public Armour_Advanced_3()
    {
        super(Armour_Advanced_3.class.getSimpleName(), ItemGrade.GRADE_3,
                new ItemEffects
                        (
                                new ItemEffectData(ItemEffect.ExplosiveResistance, 12.6d),
                                new ItemEffectData(ItemEffect.DefenceModifierHealthMultiplier, -3d),
                                new ItemEffectData(ItemEffect.KineticResistance, 10.8d),
                                new ItemEffectData(ItemEffect.Mass, -35d),
                                new ItemEffectData(ItemEffect.ThermicResistance, 9d)
                        ),
                new CostData(Material.CONDUCTIVECOMPONENTS, 1),
                new CostData(Material.HIGHDENSITYCOMPOSITES, 1),
                new CostData(Material.IRON, 1));
    }
}
