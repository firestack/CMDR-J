package com.controllerface.cmdr_j.classes.procurements.recipes.weapons.doubleshot;

import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.procurements.CostData;
import com.controllerface.cmdr_j.classes.procurements.recipes.AbstractModificationRecipe;
import com.controllerface.cmdr_j.enums.costs.materials.Material;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;
import com.controllerface.cmdr_j.enums.equipment.ItemGrade;

public class Weapon_DoubleShot_2 extends AbstractModificationRecipe
{
    public Weapon_DoubleShot_2()
    {
        super(Weapon_DoubleShot_2.class.getSimpleName(), ItemGrade.GRADE_2,
                new ItemEffects
                        (
                                new ItemEffectData(ItemEffect.BurstSize, 2d),
                                new ItemEffectData(ItemEffect.BurstRateOfFire, 800d),
                                new ItemEffectData(ItemEffect.AmmoClipSize, 4d),
                                new ItemEffectData(ItemEffect.Range, -4d)
                        ),
                new CostData(Material.CARBON, 1),
                new CostData(Material.MECHANICALEQUIPMENT, 1));
    }
}
