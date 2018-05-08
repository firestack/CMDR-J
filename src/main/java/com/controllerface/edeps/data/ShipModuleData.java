package com.controllerface.edeps.data;

import com.controllerface.edeps.ShipModule;
import com.controllerface.edeps.Statistic;
import com.controllerface.edeps.structures.craftable.experimentals.ExperimentalRecipe;
import com.controllerface.edeps.structures.craftable.modifications.ModificationBlueprint;

import java.util.List;

/**
 * Created by Stephen on 5/2/2018.
 */
public class ShipModuleData
{
    private final Statistic moduleName;
    private final ShipModule module;

    private final ModificationBlueprint modificationBlueprint;
    private final ExperimentalRecipe experimentalEffectName;
    private final List<ModifierData> modifiers;
    private final int level;
    private final double quality;

    public ShipModuleData(Builder builder)
    {
        this.moduleName = builder.moduleName;
        this.module = builder.module;
        this.modifiers = builder.modifiers;
        this.modificationBlueprint = builder.modificationBlueprint;
        this.experimentalEffectName = builder.experimentalEffectRecipe;
        this.level = builder.level;
        this.quality = builder.quality;
    }

    public ModificationBlueprint getModificationBlueprint()
    {
        return modificationBlueprint;
    }

    public ExperimentalRecipe getExperimentalEffectName()
    {
        return experimentalEffectName;
    }

    public Statistic getModuleName()
    {
        return moduleName;
    }

    public ShipModule getModule()
    {
        return module;
    }

    public List<ModifierData> getModifiers()
    {
        return modifiers;
    }

    public int getLevel()
    {
        return level;
    }

    public double getQuality()
    {
        return quality;
    }

    @Override
    public int hashCode()
    {
        return moduleName.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof ShipModuleData))
        {
            return false;
        }
        ShipModuleData other = ((ShipModuleData) obj);
        return other == this || other.getModuleName() == this.moduleName;
    }

    public static class Builder
    {

        private Statistic moduleName;
        private ShipModule module;
        private List<ModifierData> modifiers;
        private ModificationBlueprint modificationBlueprint;
        private ExperimentalRecipe experimentalEffectRecipe;
        private int level;
        private double quality;

        public Builder setModuleName(Statistic moduleName)
        {
            this.moduleName = moduleName;
            return this;
        }

        public Builder setModule(ShipModule module)
        {
            this.module = module;
            return this;
        }

        public Builder setModifiers(List<ModifierData> modifiers)
        {
            this.modifiers = modifiers;
            return this;
        }

        public Builder setModificationBlueprint(ModificationBlueprint modificationBlueprint)
        {
            this.modificationBlueprint = modificationBlueprint;
            return this;
        }

        public Builder setExperimentalEffectRecipe(ExperimentalRecipe experimentalEffectName)
        {
            this.experimentalEffectRecipe = experimentalEffectName;
            return this;
        }

        public Builder setLevel(Integer level)
        {
            if (level != null) this.level = level;
            return this;
        }

        public Builder setQuality(Double quality)
        {
            if (quality != null) this.quality = quality;
            return this;
        }

        public ShipModuleData build()
        {
            return new ShipModuleData(this);
        }
    }
}
