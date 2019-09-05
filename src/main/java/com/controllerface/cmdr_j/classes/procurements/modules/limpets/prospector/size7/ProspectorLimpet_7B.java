package com.controllerface.cmdr_j.classes.procurements.modules.limpets.prospector.size7;

import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.procurements.modules.limpets.prospector.AbstractProspectorLimpet;
import com.controllerface.cmdr_j.enums.craftable.modifications.ModificationType;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;

public class ProspectorLimpet_7B extends AbstractProspectorLimpet
{
    public ProspectorLimpet_7B()
    {
        super("7B Prospector Limpet Controller",
                new ItemEffects(
                        new ItemEffectData(ItemEffect.Mass, 128d),
                        new ItemEffectData(ItemEffect.Integrity, 157d),
                        new ItemEffectData(ItemEffect.PowerDraw, 0.97d),
                        new ItemEffectData(ItemEffect.BootTime, 4d),
                        new ItemEffectData(ItemEffect.MaxActiveDrones, 8d),
                        new ItemEffectData(ItemEffect.DroneLifeTime, 600d),
                        new ItemEffectData(ItemEffect.DroneSpeed, 200d)
                ));
    }
}
