package com.controllerface.cmdr_j.classes.recipes.misc.fastscan;

import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.tasks.CostData;
import com.controllerface.cmdr_j.classes.recipes.AbstractModificationRecipe;
import com.controllerface.cmdr_j.enums.costs.materials.Material;
import com.controllerface.cmdr_j.enums.equipment.modules.stats.ItemEffect;
import com.controllerface.cmdr_j.enums.equipment.modules.stats.ItemGrade;

public class Sensor_Misc_FastScan_3 extends AbstractModificationRecipe
{
    public Sensor_Misc_FastScan_3()
    {
        super(Sensor_Misc_FastScan_3.class.getSimpleName(), ItemGrade.GRADE_3,
                new ItemEffects
                        (
                                new ItemEffectData(ItemEffect.Integrity, -30d),
                                new ItemEffectData(ItemEffect.Range, -15d),
                                new ItemEffectData(ItemEffect.ScannerTimeToScan, -50d)
                        ),
                new CostData(Material.UNCUTFOCUSCRYSTALS, 1),
                new CostData(Material.SYMMETRICKEYS, 1),
                new CostData(Material.PHOSPHORUS, 1));
    }
}
