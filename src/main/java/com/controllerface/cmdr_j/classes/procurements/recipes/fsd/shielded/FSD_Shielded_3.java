package com.controllerface.cmdr_j.classes.procurements.recipes.fsd.shielded;

import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.procurements.CostData;
import com.controllerface.cmdr_j.classes.procurements.recipes.AbstractModificationRecipe;
import com.controllerface.cmdr_j.enums.costs.materials.Material;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.enums.equipment.ItemGrade;

public class FSD_Shielded_3 extends AbstractModificationRecipe
{
    public FSD_Shielded_3()
    {
        super(FSD_Shielded_3.class.getSimpleName(), ItemGrade.GRADE_3,
                new ItemEffects
                        (
                                new ItemEffectData(ItemEffect.Integrity, 75d),
                                new ItemEffectData(ItemEffect.Mass, 12d),
                                new ItemEffectData(ItemEffect.FSDOptimalMass, 9d),
                                new ItemEffectData(ItemEffect.ThermalLoad, -20d)
                        ),
                new CostData(Material.CARBON, 1),
                new CostData(Material.SHIELDINGSENSORS, 1),
                new CostData(Material.ZINC, 1));
    }
}
