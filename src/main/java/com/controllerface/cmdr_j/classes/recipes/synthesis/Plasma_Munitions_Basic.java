package com.controllerface.cmdr_j.classes.recipes.synthesis;

import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.procurements.CostData;
import com.controllerface.cmdr_j.classes.recipes.AbstractSynthesisRecipe_Basic;
import com.controllerface.cmdr_j.enums.costs.materials.Material;
import com.controllerface.cmdr_j.enums.equipment.modules.stats.ItemEffect;

public class Plasma_Munitions_Basic extends AbstractSynthesisRecipe_Basic
{
    public Plasma_Munitions_Basic()
    {
        super("Plasma Munitions Basic", 
            new ItemEffects(
                  new ItemEffectData(ItemEffect.Rearm, 0.0)
            ),
            new CostData(Material.SULPHUR, 3),
            new CostData(Material.PHOSPHORUS, 4),
            new CostData(Material.MANGANESE, 1));
    }
}