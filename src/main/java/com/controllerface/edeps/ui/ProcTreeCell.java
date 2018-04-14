package com.controllerface.edeps.ui;

import com.controllerface.edeps.ProcurementCost;
import com.controllerface.edeps.data.CostData;
import com.controllerface.edeps.data.ProcTreeData;
import com.sun.javafx.scene.control.skin.ProgressIndicatorSkin;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Stephen on 4/1/2018.
 */
public class ProcTreeCell extends TreeCell<ProcTreeData>
{
    private final Consumer<ProcTreeData> addMod;
    private final Function<ProcurementCost, Integer> checkMat;

    public ProcTreeCell(Consumer<ProcTreeData> addMod, Function<ProcurementCost, Integer> checkMat)
    {
        this.addMod = addMod;
        this.checkMat = checkMat;
    }

    @Override
    protected void updateItem(ProcTreeData item, boolean empty)
    {
        super.updateItem(item, empty);

        if (item == null)
        {
            setGraphic(null);
            setText(null);
            return;
        }

        if (item.getRecipe() != null && this.getTreeItem().isLeaf())
        {
            HBox cellBox = new HBox(10);
            VBox textBox = new VBox(1);
            Label gradeLabel = new Label(item.getRecipe().getLabel());

            Font existingFont = gradeLabel.getFont();
            Font boldFont = Font.font(existingFont.getFamily(), FontWeight.BOLD, existingFont.getSize());
            gradeLabel.setFont(boldFont);

            textBox.getChildren().add(gradeLabel);

            item.getRecipe().effects().pairStream()
                    .map(p ->
                    {
                        boolean moreIsGood = p.getKey().isMoreGood();
                        boolean valueIsPositive = p.getValue() >= 0;
                        boolean markGood = moreIsGood == valueIsPositive;
                        String buf = p.getKey().toString()
                                + ((valueIsPositive ? " +" : " ")
                                + p.getValue());
                        buf = buf.replace(".0","");
                        if (buf.contains("-") || buf.contains("+")) buf += "%";
                        buf = buf.replace("+0%","");
                        Label nextLabel = new Label(buf);
                        nextLabel.setTextFill(markGood ? Color.BLUE : Color.RED);
                        return nextLabel;
                    })
                    .sorted((a,b)->a.getTextFill() == b.getTextFill() // do the text fill styles match?
                            ? 0 // if so, return 0 indicating they are equal
                            : a.getTextFill() == Color.BLUE // is a green?
                                    ? -1 // if so return -1 for green first
                                    : 1) // otherwise, return 1 for red last
                    .forEach(l->textBox.getChildren().add(l));

            Button button = new Button();
            button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            button.setGraphic(textBox);
            ProgressIndicator progressIndicator = new ProgressIndicator(0);

            List<CostData> data = this.getItem()
                    .getRecipe()
                    .costStream()
                    .collect(Collectors.toList());

            int count = data.size();
            AtomicInteger good = new AtomicInteger(0);
            data.forEach(d->
            {
                if(checkMat.apply(d.getCost())>=d.getQuantity())
                {
                    good.incrementAndGet();
                }
            });

            AtomicInteger loops = new AtomicInteger(0);
            Set<CostData> missingSet = new HashSet<>();
            if (good.get() == count)
            {
                AtomicInteger innerGood = new AtomicInteger(count);
                while (innerGood.get() == count)
                {
                    loops.getAndIncrement();
                    innerGood.set(0);
                    data.forEach(m->
                    {
                        if(checkMat.apply(m.getCost()) >= (m.getQuantity()* loops.get() + 1))
                        {
                            innerGood.incrementAndGet();
                        }
                    });
                }
            }
            else
            {
                data.forEach(m ->
                {
                    int ch = checkMat.apply(m.getCost());
                    if(ch < m.getQuantity())
                    {
                        missingSet.add(m);
                    }
                });
            }

            // in order for text adjustments to be possible via CSS, we must get a skin and apply CSS first
            ProgressIndicatorSkin indicatorSkin = new ProgressIndicatorSkin(progressIndicator);
            progressIndicator.applyCss();

            // add a listener that modifies the display of the percentage counter
            progressIndicator.progressProperty().addListener((ov, t, newValue) ->
            {
                // If progress is 100% then show Text
                Text text = (Text) progressIndicator.lookup(".percentage");
                if (text != null)
                {
                    if (newValue.doubleValue() >= 1)
                    {
                        double w = text.getLayoutBounds().getWidth();
                        text.setText(String.valueOf(loops.get()));
                        progressIndicator.setPrefWidth(w);
                        progressIndicator.setStyle("-fx-progress-color: #6677ff;");
                        String msg = data.stream()
                                .map(d-> checkMat.apply(d.getCost()) + " x " +
                                        d.getCost().getLocalizedName()).collect(Collectors.joining("\n","\n","\n"));

                        progressIndicator.setTooltip(new Tooltip("You can craft " + loops.get() + " of this mod" + msg));
                    }
                    else
                    {
                        String suffix = missingSet.size() > 1 ? "s" : "";
                        String missingMessage = "You need the following material" + suffix + " to craft this mod:" +
                                missingSet.stream()
                                        .map(x-> x.getQuantity()+ " x " + x.getCost().getLocalizedName())
                                        .collect(Collectors.joining("\n","\n","\n"));
                        progressIndicator.setStyle(" -fx-progress-color: #ee5555;");
                        progressIndicator.setTooltip(new Tooltip(missingMessage));
                    }
                }
            });

            progressIndicator.setProgress(((double) good.get())/ ((double) count));
            progressIndicator.setSkin(indicatorSkin);

            button.setOnMouseClicked((e) -> addMod.accept(this.getItem()));
            button.setTooltip(new Tooltip("Click to add: \n   " + item.getType() + " : " + item.toString() + "\nto your procurement list"));

            cellBox.getChildren().addAll(progressIndicator, button);

            setGraphic(cellBox);
            setText(null);
        }
        else
        {
            setGraphic(null);
            setText(item.toString());
        }
    }
}
