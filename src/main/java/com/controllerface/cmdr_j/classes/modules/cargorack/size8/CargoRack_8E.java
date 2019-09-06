package com.controllerface.cmdr_j.classes.modules.cargorack.size8;

import com.controllerface.cmdr_j.classes.ItemEffectData;
import com.controllerface.cmdr_j.classes.ItemEffects;
import com.controllerface.cmdr_j.classes.modules.cargorack.AbstractCargoRack;
import com.controllerface.cmdr_j.enums.equipment.ItemEffect;

public class CargoRack_8E extends AbstractCargoRack
{
    public CargoRack_8E()
    {
        super("8E Cargo Rack", new ItemEffects(new ItemEffectData(ItemEffect.CargoCapacity, 256d)));
    }

}