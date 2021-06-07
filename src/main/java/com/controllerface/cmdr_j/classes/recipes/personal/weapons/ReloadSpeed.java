package com.controllerface.cmdr_j.classes.recipes.personal.weapons;

import com.controllerface.cmdr_j.classes.data.CostData;
import com.controllerface.cmdr_j.classes.data.ItemEffectData;
import com.controllerface.cmdr_j.classes.data.ItemEffects;
import com.controllerface.cmdr_j.classes.recipes.AbstractModificationRecipe;
import com.controllerface.cmdr_j.enums.costs.materials.Material;
import com.controllerface.cmdr_j.enums.equipment.modules.stats.ItemEffect;
import com.controllerface.cmdr_j.enums.equipment.modules.stats.ItemGrade;

public class ReloadSpeed extends AbstractModificationRecipe
{
    public ReloadSpeed()
    {
        super(ReloadSpeed.class.getSimpleName(), ItemGrade.MicroMaterial,
            new ItemEffects
                (
                    // todo: add actual effects
                    new ItemEffectData(ItemEffect.Ground_Gear, 1d)
                ),
            new CostData(Material.IRON, 1));
    }
}
