package com.controllerface.cmdr_j.classes.recipes.personal.weapons;

import com.controllerface.cmdr_j.classes.data.CostData;
import com.controllerface.cmdr_j.classes.data.ItemEffectData;
import com.controllerface.cmdr_j.classes.data.ItemEffects;
import com.controllerface.cmdr_j.classes.recipes.AbstractModificationRecipe;
import com.controllerface.cmdr_j.classes.recipes.armour.advanced.Armour_Advanced_1;
import com.controllerface.cmdr_j.enums.costs.materials.Material;
import com.controllerface.cmdr_j.enums.costs.special.CreditCost;
import com.controllerface.cmdr_j.enums.equipment.modules.stats.ItemEffect;
import com.controllerface.cmdr_j.enums.equipment.modules.stats.ItemGrade;

public class GreaterRange extends AbstractModificationRecipe
{
    public GreaterRange()
    {
        super(GreaterRange.class.getSimpleName(), ItemGrade.MicroMaterial,
            new ItemEffects
                (
                    new ItemEffectData(ItemEffect.Improved_Weapon_Range, "enabled")
                ),
            new CostData(Material.COMPRESSIONLIQUEFIEDGAS, 1),
            new CostData(Material.BALLISTICDATA, 10),
            new CostData(Material.TOPOGRAPHICALSURVEYS, 10),
            new CostData(Material.METALCOIL, 10),
            new CostData(Material.RDX, 10),
            new CostData(Material.WEAPONCOMPONENT, 5),
            new CostData(CreditCost.CREDIT_COST, 500_000));
    }
}
