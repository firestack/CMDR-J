package com.controllerface.cmdr_j.classes.procurements.modules.passengercabin.size6;

import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.procurements.modules.passengercabin.AbstractCabin;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;

public class Cabin_6B extends AbstractCabin
{
    public Cabin_6B()
    {
        super("6B Luxury Class Passenger Cabin",
                new ItemEffects(
                        new ItemEffectData(ItemEffect.Mass, 40d),
                        new ItemEffectData(ItemEffect.CabinCapacity, 8d),
                        new ItemEffectData(ItemEffect.CabinClass, "Luxury")
                ));
    }
}
