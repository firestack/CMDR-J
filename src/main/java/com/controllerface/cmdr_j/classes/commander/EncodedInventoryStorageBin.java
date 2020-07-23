package com.controllerface.cmdr_j.classes.commander;

import com.controllerface.cmdr_j.classes.tasks.TaskCost;
import com.controllerface.cmdr_j.classes.tasks.Task;
import com.controllerface.cmdr_j.enums.costs.materials.Material;
import com.controllerface.cmdr_j.enums.costs.materials.MaterialSubCostCategory;
import com.controllerface.cmdr_j.enums.costs.materials.MaterialType;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Storage bin object for Encoded crafting materials
 *
 * NOTE: Mutable state data object
 *
 * Created by Controllerface on 3/21/2018.
 */
class EncodedInventoryStorageBin extends InventoryStorageBin
{
    EncodedInventoryStorageBin(Function<TaskCost, Integer> pendingTradeCost,
                               Consumer<Task> addTask)
    {
        super(pendingTradeCost, addTask);
    }

    @Override
    public boolean check(TaskCost item)
    {
        return item instanceof Material &&
                MaterialType.ENCODED.hasMaterial(((Material) item));
    }

    @Override
    public void init()
    {
        MaterialType.ENCODED.categories()
                .flatMap(MaterialSubCostCategory::materials)
                .forEach(this::initializeItem);
    }
}
