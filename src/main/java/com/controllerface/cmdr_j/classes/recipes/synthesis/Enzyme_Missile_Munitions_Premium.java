package com.controllerface.cmdr_j.classes.recipes.synthesis;

import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.procurements.CostData;
import com.controllerface.cmdr_j.classes.recipes.AbstractSynthesisRecipe_Premium;
import com.controllerface.cmdr_j.enums.costs.materials.Material;
import com.controllerface.cmdr_j.enums.equipment.modules.stats.ItemEffect;

public class Enzyme_Missile_Munitions_Premium extends AbstractSynthesisRecipe_Premium
{
    public Enzyme_Missile_Munitions_Premium()
    {
        super("Enzyme Missile Munitions Premium", 
            new ItemEffects(
                  new ItemEffectData(ItemEffect.Rearm, 0.0),
                  new ItemEffectData(ItemEffect.Damage_Boost, 30.0)
            ),
            new CostData(Material.PHOSPHORUS, 5),
            new CostData(Material.TUNGSTEN, 4),
            new CostData(Material.TG_BIOMECHANICALCONDUITS, 6),
            new CostData(Material.TG_PROPULSIONELEMENT, 6),
            new CostData(Material.TG_WEAPONPARTS, 5),
            new CostData(Material.LEAD, 6));
    }
}