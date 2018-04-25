package com.controllerface.edeps.data;

import com.controllerface.edeps.Immutable;
import com.controllerface.edeps.structures.equipment.modules.HardPointSize;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stephen on 4/16/2018.
 *
 * NOTE: Immutable static data object
 *
 */
@Immutable
public class HardPointLayoutData
{
    private final HardPointSize[] slots;

    private HardPointLayoutData(Builder builder)
    {
        HardPointSize[] h = new HardPointSize[builder.slots.size()];
        this.slots = builder.slots.toArray(h);
    }

    public HardPointSize[] getSlots()
    {
        return slots;
    }

    public static Builder builder()
    {
        return new Builder();
    }

    public static class Builder
    {
        private List<HardPointSize> slots = new ArrayList<>();

        public Builder addHardPoint(HardPointSize size)
        {
            slots.add(size);
            return this;
        }

        public HardPointLayoutData build()
        {
            return new HardPointLayoutData(this);
        }
    }
}
