package com.controllerface.cmdr_j.classes.recipes.powerplant.armoured;

import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.procurements.CostData;
import com.controllerface.cmdr_j.classes.recipes.AbstractModificationRecipe;
import com.controllerface.cmdr_j.enums.costs.materials.Material;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.enums.equipment.ItemGrade;

public class PowerPlant_Armoured_5 extends AbstractModificationRecipe
{
    public PowerPlant_Armoured_5()
    {
        super(PowerPlant_Armoured_5.class.getSimpleName(), ItemGrade.GRADE_5,
                new ItemEffects
                        (
                                new ItemEffectData(ItemEffect.HeatEfficiency, -12d),
                                new ItemEffectData(ItemEffect.Integrity, 120d),
                                new ItemEffectData(ItemEffect.PowerCapacity, 12d),
                                new ItemEffectData(ItemEffect.Mass, 20d)
                        ),
                new CostData(Material.COMPOUNDSHIELDING, 1),
                new CostData(Material.FEDCORECOMPOSITES, 1),
                new CostData(Material.TUNGSTEN, 1));
    }
}