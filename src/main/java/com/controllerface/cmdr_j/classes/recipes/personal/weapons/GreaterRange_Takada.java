package com.controllerface.cmdr_j.classes.recipes.personal.weapons;

import com.controllerface.cmdr_j.classes.data.CostData;
import com.controllerface.cmdr_j.classes.data.ItemEffectData;
import com.controllerface.cmdr_j.classes.data.ItemEffects;
import com.controllerface.cmdr_j.classes.recipes.AbstractModificationRecipe;
import com.controllerface.cmdr_j.enums.costs.materials.Material;
import com.controllerface.cmdr_j.enums.costs.special.CreditCost;
import com.controllerface.cmdr_j.enums.equipment.modules.stats.ItemEffect;
import com.controllerface.cmdr_j.enums.equipment.modules.stats.ItemGrade;

public class GreaterRange_Takada extends AbstractModificationRecipe
{
    public GreaterRange_Takada()
    {
        super(GreaterRange_Takada.class.getSimpleName(), ItemGrade.MicroMaterial,
            new ItemEffects
                (
                    new ItemEffectData(ItemEffect.Improved_Weapon_Range, "enabled")
                ),
            new CostData(Material.STELLARACTIVITYLOGS, 10),
            new CostData(Material.RISKASSESSMENTS, 15),
            new CostData(Material.MICROTRANSFORMER, 15),
            new CostData(Material.OPTICALLENS, 5),
            new CostData(Material.CIRCUITBOARD, 5),
            new CostData(CreditCost.CREDIT_COST, 500_000));
    }
}
