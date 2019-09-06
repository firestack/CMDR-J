package com.controllerface.cmdr_j.classes.recipes.armour.advanced;

import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.procurements.CostData;
import com.controllerface.cmdr_j.classes.recipes.AbstractModificationRecipe;
import com.controllerface.cmdr_j.enums.costs.materials.Material;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.enums.equipment.ItemGrade;

public class Armour_Advanced_2 extends AbstractModificationRecipe
{
    public Armour_Advanced_2()
    {
        super(Armour_Advanced_2.class.getSimpleName(), ItemGrade.GRADE_2,
                new ItemEffects
                        (
                                new ItemEffectData(ItemEffect.ExplosiveResistance, 8.4d),
                                new ItemEffectData(ItemEffect.DefenceModifierHealthMultiplier, -2d),
                                new ItemEffectData(ItemEffect.KineticResistance, 7.2d),
                                new ItemEffectData(ItemEffect.Mass, -25d),
                                new ItemEffectData(ItemEffect.ThermicResistance, 6d)
                        ),
                new CostData(Material.CONDUCTIVECOMPONENTS, 1),
                new CostData(Material.IRON, 1));
    }
}