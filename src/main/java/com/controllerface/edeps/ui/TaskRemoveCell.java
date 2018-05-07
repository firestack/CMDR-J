package com.controllerface.edeps.ui;

import com.controllerface.edeps.ProcurementRecipe;
import com.controllerface.edeps.ProcurementType;
import com.controllerface.edeps.data.procurements.ProcurementRecipeData;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Pair;

import java.util.function.BiFunction;

/**
 * Created by Stephen on 4/2/2018.
 */
public class TaskRemoveCell extends TableCell<ProcurementRecipeData, Pair<ProcurementType, ProcurementRecipe>>
{
    private final Button remove = new Button("x");
    private final HBox controls = new HBox(remove);

    private final BiFunction<Integer, Pair<ProcurementType, ProcurementRecipe>, Integer> blueprintUpdate;

    public TaskRemoveCell(BiFunction<Integer, Pair<ProcurementType, ProcurementRecipe>, Integer> blueprintUpdate)
    {
        this.blueprintUpdate = blueprintUpdate;
    }

    @Override
    protected void updateItem(Pair<ProcurementType, ProcurementRecipe> item, boolean empty)
    {
        super.updateItem(item, empty);

        if (!empty)
        {
            Line line = new Line();
            line.setStroke(Color.BLACK);
            line.setStrokeWidth(3);
            line.setStartX(-3);
            line.setEndX(7);
            line.setStartY(1);
            line.setEndY(11);

            Line line2 = new Line();
            line2.setStroke(Color.BLACK);
            line2.setStrokeWidth(3);
            line2.setStartX(-3);
            line2.setEndX(7);
            line2.setStartY(11);
            line2.setEndY(1);

            Pane box  = new Pane(line, line2);

            remove.setGraphic(box);
            remove.setMaxWidth(20d);
            remove.setMinWidth(20d);
            remove.setMaxHeight(20d);
            remove.setMinHeight(20d);
            remove.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

            remove.setOnAction((e) ->
            {
                int val = blueprintUpdate.apply(-1, item);
                while (val > 0) val = blueprintUpdate.apply(-1, item);
            });

            remove.setTooltip(new Tooltip("Remove this recipe"));
            setGraphic(controls);
        }

        if (item==null) setGraphic(null);
    }
}
