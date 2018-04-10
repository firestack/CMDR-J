package com.controllerface.edeps.ui;

import com.controllerface.edeps.enums.modifications.ModificationRecipe;
import com.controllerface.edeps.enums.modifications.ModificationType;
import com.controllerface.edeps.data.ModRecipeItem;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Pair;

import java.util.function.BiFunction;

/**
 * Created by Stephen on 4/8/2018.
 */
public class ModRollCell extends TableCell<ModRecipeItem, ModRecipeItem>
{
    private final Label countLabel = new Label();
    private final Button subtractButton = new Button("-");
    private final Button addButton = new Button("+");
    private final HBox buttonBox =  new HBox(subtractButton,countLabel, addButton);

    private final BiFunction<Integer, Pair<ModificationType, ModificationRecipe>, Integer> inventoryUpdate;

    public ModRollCell(BiFunction<Integer, Pair<ModificationType, ModificationRecipe>, Integer> inventoryUpdate)
    {
        this.inventoryUpdate = inventoryUpdate;
    }

    @Override
    protected void updateItem(ModRecipeItem item, boolean empty)
    {
        super.updateItem(item, empty);

        if (!empty)
        {
            // Plus
            Line line1 = new Line();
            line1.setStroke(Color.BLACK);
            line1.setStrokeWidth(3);
            line1.setStartX(-3);
            line1.setEndX(7);
            line1.setStartY(6);
            line1.setEndY(6);

            Line line2 = new Line();
            line2.setStroke(Color.BLACK);
            line2.setStrokeWidth(3);
            line2.setStartX(2);
            line2.setEndX(2);
            line2.setStartY(1);
            line2.setEndY(11);

            Line line1a = new Line();
            line1a.setStroke(Color.GREEN);
            line1a.setStrokeWidth(2);
            line1a.setStartX(-3);
            line1a.setEndX(7);
            line1a.setStartY(6);
            line1a.setEndY(6);

            Line line2a = new Line();
            line2a.setStroke(Color.GREEN);
            line2a.setStrokeWidth(2);
            line2a.setStartX(2);
            line2a.setEndX(2);
            line2a.setStartY(1);
            line2a.setEndY(11);

            // Minus
            Line line3 = new Line();
            line3.setStroke(Color.BLACK);
            line3.setStrokeWidth(3);
            line3.setStartX(-3);
            line3.setEndX(7);
            line3.setStartY(6);
            line3.setEndY(6);

            Line line3a = new Line();
            line3a.setStroke(Color.RED);
            line3a.setStrokeWidth(2);
            line3a.setStartX(-3);
            line3a.setEndX(7);
            line3a.setStartY(6);
            line3a.setEndY(6);

            Pane addGraphic  = new Pane(line1, line2, line1a, line2a);
            Pane subGraphic  = new Pane(line3, line3a);

            addButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            subtractButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            addButton.setGraphic(addGraphic);
            subtractButton.setGraphic(subGraphic);

            countLabel.setText(String.valueOf(item.getCount()));
            countLabel.setMaxSize(34, 20);
            countLabel.setMinSize(34, 20);
            countLabel.setAlignment(Pos.CENTER);
            addButton.setMaxWidth(20);
            addButton.setMinWidth(20);
            subtractButton.setMaxWidth(20);
            subtractButton.setMinWidth(20);

            addButton.setMaxHeight(20);
            addButton.setMinHeight(20);
            subtractButton.setMaxHeight(20);
            subtractButton.setMinHeight(20);

            subtractButton.setOnAction((e) -> inventoryUpdate.apply(-1, item.asPair()));

            addButton.setOnAction((e) -> inventoryUpdate.apply(1, item.asPair()));

            setGraphic(buttonBox);
        }

        if (item==null) setGraphic(null);
    }
}
