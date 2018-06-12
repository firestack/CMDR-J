package com.controllerface.edeps.ui.tasks;

import com.controllerface.edeps.ProcurementCost;
import com.controllerface.edeps.ProcurementRecipe;
import com.controllerface.edeps.ProcurementType;
import com.controllerface.edeps.data.procurements.ProcurementTaskData;
import com.controllerface.edeps.structures.costs.materials.MaterialTradeType;
import com.controllerface.edeps.ui.UIFunctions;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/**
 * Created by Controllerface on 4/8/2018.
 */
public class TaskDataCell extends TableCell<ProcurementTaskData, ProcurementTaskData>
{
    // main graphic node that contains the visible contents
    private final VBox descriptionContainer = new VBox();

    // objects with content that may change
    private final Label nameLabel = new Label();
    private final ProgressBar progressBar = new ProgressBar();

    private int lastCount = -1;
    private int lastTotal = -1;
    private int lastMissing = -1;
    private double lastProgress = -1;

    private final Function<ProcurementCost, Integer> checkInventory;
    private final Function<ProcurementCost, Integer> pendingTradeYield;

    public TaskDataCell(Function<ProcurementCost, Integer> checkInventory, Function<ProcurementCost, Integer> pendingTradeYield)
    {
        this.checkInventory = checkInventory;
        this.pendingTradeYield = pendingTradeYield;
    }

    @Override
    protected void updateItem(ProcurementTaskData item, boolean empty)
    {
        super.updateItem(item, empty);
        if (item == null || empty)
        {
            lastCount = -1;
            lastTotal = -1;
            lastMissing = -1;
            lastProgress = -1;
            super.setText(null);
            super.setGraphic(null);
            return;
        }

        item.prepareGraphic();
        setGraphic(item.getGraphic());
    }

//    private void createOrUpdate(ProcurementTaskData item)
//    {
//        Pair<ProcurementType, ProcurementRecipe> recipePair = item.asPair();
//
//        descriptionContainer.getChildren().clear();
//
//        TitledPane titledPane = new TitledPane();
//        titledPane.setAnimated(false);
//        titledPane.setExpanded(false);
//
//        VBox costEffectContainer = new VBox();
//        costEffectContainer.setBackground(new Background(new BackgroundFill(Color.rgb(0xDD, 0xDD, 0xDD), CornerRadii.EMPTY, Insets.EMPTY)));
//
//        Separator separator = new Separator();
//        separator.setPrefHeight(10);
//
//        nameLabel.setPrefHeight(20);
//        nameLabel.setFont(UIFunctions.Fonts.size2Font);
//        nameLabel.paddingProperty().set(new Insets(2, 5, 2, 5));
//
//        // effects
//        recipePair.getValue().effects().effectStream()
//                .map(UIFunctions.Convert.effectToLabel)
//                .sorted(UIFunctions.Sort.byGoodness)
//                .forEach(label -> costEffectContainer.getChildren().add(label));
//
//        costEffectContainer.getChildren().add(separator);
//
//        // costs
//        recipePair.getValue().costStream()
//                .map(c->
//                {
//                    boolean isYield = c.getQuantity() < 0;
//                    boolean hasEnough = isYield ||
//                            checkInventory.apply(c.getCost()) >= c.getQuantity() * item.getCount();
//
//                    String quantity = c.getQuantity() < 0
//                            ? "+" + Math.abs(c.getQuantity()) * item.getCount()
//                            : "-" + c.getQuantity() * item.getCount();
//
//                    Label next = new Label(quantity + " " + c.getCost().getLocalizedName());
//                    next.setFont(UIFunctions.Fonts.size1Font);
//                    next.setTextFill(hasEnough ? UIFunctions.Fonts.neutralBlack : UIFunctions.Fonts.negativeRed);
//                    return next;
//                })
//                .forEach(label -> costEffectContainer.getChildren().add(label));
//
//        titledPane.setContent(costEffectContainer);
//
//        updateProgressBar(item);
//
//        // clicking the progress bar should expand the enclosing titled pane
//        progressBar.setOnMouseClicked((e)->titledPane.setExpanded(!titledPane.isExpanded()));
//
//        titledPane.setGraphic(new HBox(progressBar, nameLabel));
//        ((HBox) titledPane.getGraphic()).setAlignment(Pos.CENTER);
//
//        descriptionContainer.getChildren().add(titledPane);
//
//        nameLabel.setText(recipePair.getKey().toString() + " :: " + recipePair.getValue().getDisplayLabel());
//        if (recipePair.getKey() instanceof MaterialTradeType)
//        {
//            nameLabel.setTextFill(UIFunctions.Fonts.darkOrange);
//        }
//        else nameLabel.setTextFill(UIFunctions.Fonts.neutralBlack);
//        updateProgressBar(item);
//    }
//
//    private Pair<Double, Boolean> calculateProgress(ProcurementTaskData procurementTaskData)
//    {
//        AtomicBoolean usesTrade = new AtomicBoolean(false);
//
//        // get the number of "rolls" required for this task
//        int count = procurementTaskData.getCount();
//
//        AtomicInteger accumulatedTotal = new AtomicInteger(0);
//
//        int missing = procurementTaskData.asPair().getValue().costStream()
//                .filter(c->c.getQuantity() > 0)
//                .mapToInt(cost->
//                {
//                    int banked = checkInventory.apply(cost.getCost());
//
//                    int calculatedCost = (cost.getQuantity() * count);
//
//                    accumulatedTotal.addAndGet(calculatedCost);
//
//                    int surplus = banked - calculatedCost;
//
//                    // only check pending trades if we're in the red without them
//                    if (surplus < 0)
//                    {
//                        Integer pendingYield = pendingTradeYield.apply(cost.getCost());
//                        if (pendingYield != null && pendingYield > 0)
//                        {
//                            usesTrade.set(true);
//                            surplus = banked + pendingYield - calculatedCost;
//                        }
//                    }
//
//                    return surplus < 0
//                            ? -1 * surplus
//                            : 0;
//                })
//                .sum();
//
//        if (count == lastCount && accumulatedTotal.get() == lastTotal && missing == lastMissing)
//        {
//            return new Pair<>(lastProgress, usesTrade.get());
//        }
//
//        lastCount = count;
//        lastTotal = accumulatedTotal.get();
//        lastMissing = missing;
//
//        lastProgress = lastMissing > 0
//                ? (double) (lastTotal - lastMissing) / (double)(lastTotal)
//                : 1;
//
//        return new Pair<>(lastProgress, usesTrade.get());
//    }
//
//    private void updateProgressBar(ProcurementTaskData procurementTaskData)
//    {
//        Pair<Double, Boolean> progressData = calculateProgress(procurementTaskData);
//        progressBar.setProgress(progressData.getKey());
//
//        if (progressData.getValue())
//        {
//            if (progressBar.getProgress() >= 1.0)
//            {
//                progressBar.setStyle("-fx-accent: #d9b3ff");
//            }
//            else progressBar.setStyle("-fx-accent: #ffaaaa");
//        }
//        else
//        {
//            if (progressBar.getProgress() >= 1.0)
//            {
//                progressBar.setStyle("-fx-accent: #00b3f7");
//            }
//            else progressBar.setStyle("-fx-accent: #ff0000 ");
//        }
//        progressBar.applyCss();
//    }
}