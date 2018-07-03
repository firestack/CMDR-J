package com.controllerface.cmdr_j.data.commander;

import com.controllerface.cmdr_j.ProcurementBlueprint;
import com.controllerface.cmdr_j.ProcurementCost;
import com.controllerface.cmdr_j.ProcurementRecipe;
import com.controllerface.cmdr_j.data.procurements.CostData;
import com.controllerface.cmdr_j.data.procurements.ProcurementTask;
import com.controllerface.cmdr_j.structures.costs.commodities.Commodity;
import com.controllerface.cmdr_j.structures.costs.commodities.CommodityCostCategory;
import com.controllerface.cmdr_j.structures.costs.materials.Material;
import com.controllerface.cmdr_j.structures.costs.materials.MaterialSubCostCategory;
import com.controllerface.cmdr_j.structures.costs.materials.MaterialTradeType;
import com.controllerface.cmdr_j.structures.craftable.experimentals.ExperimentalBlueprint;
import com.controllerface.cmdr_j.structures.craftable.experimentals.ExperimentalRecipe;
import com.controllerface.cmdr_j.structures.craftable.modifications.ModificationBlueprint;
import com.controllerface.cmdr_j.structures.craftable.modifications.ModificationRecipe;
import com.controllerface.cmdr_j.structures.craftable.modifications.WeaponModificationRecipe;
import com.controllerface.cmdr_j.structures.craftable.synthesis.SynthesisBlueprint;
import com.controllerface.cmdr_j.structures.craftable.synthesis.SynthesisRecipe;
import com.controllerface.cmdr_j.structures.craftable.technologies.TechnologyBlueprint;
import com.controllerface.cmdr_j.structures.craftable.technologies.TechnologyRecipe;
import com.controllerface.cmdr_j.ui.UIFunctions;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableNumberValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Data container for an individual item in a player's inventory. This class also contains a graphical representation
 * of the item, along with some supplemental data about the item, which can be used to represent the item in a GUI app.
 *
 * Created by Controllerface on 3/27/2018.
 */
public class InventoryData implements Displayable
{

    /**
     * The actual inventory item being tracked
     */
    private final ProcurementCost inventoryItem;

    /**
     * Stores the current count of the inventory item
     */
    private int quantity;

    /**
     * Ordinal used when performing comparisons based on grade; used to sort collections of InventoryData objects.
     */
    private final int gradeOrdinal;

    /**
     * Ordinal used when performing comparisons based on category; used to sort collections of InventoryData objects.
     */
    private final int categoryOrdinal;

    /**
     * JavaFX UI component containing info about the inventory item and any other related information that may be
     * available for the item. Some items will have more info that others so this object may contain a wide variety
     * of child objects.
     */
    private final VBox mainGraphic = new VBox();

    /**
     * In the context of this inventory object, the graphical "progress" bar is used to denote what percentage of the
     * current capacity for the item is used. If the item does not have a maximum capacity, this bar may not be present
     * of if it is, may not containing meaningful information.
     *
     * todo: add some info for commodities, perhaps % of max capacity, just for UI sugar
     */
    private final ProgressBar capacityBar = new ProgressBar();

    /**
     * This is used to ensure the graphic is only completely rendered once, when this object's graphics are first
     * requested. Afterward, only the "live" components of the item's display are modified.
     */
    private final AtomicBoolean initialRenderComplete = new AtomicBoolean(false);

    /**
     * Describes the item's general "category", useful in text descriptions of the item
     */
    private final String categoryString;

    /**
     * Stores a newline (\n) delimited list of string names for all the tasks associated with this item
     */
    private final String assoctiatedString;

    private final SimpleIntegerProperty haveCount = new SimpleIntegerProperty();


    //private final Predicate<ProcurementCost> isInCache;
    //private final Function<ProcurementCost, Integer> pendingTradeYield;

    private final Function<ProcurementCost, Integer> checkInventory;
    private final Function<ProcurementCost, Integer> pendingTradeCost;
    private final Consumer<ProcurementTask> addTask;




    /**
     * Special formatting function for modifications and experimental effects. Since they have some odd cases
     * the basic .replace("_"," ") call isn't enough to make it look right
     */
    private static Function<String, String> formatModString = (s)->
    {
        int i = s.lastIndexOf("_");
        if (i == -1) return s;
        String r = s.substring(0,i).replace("_"," ");

        // remove duplicate "sensor sensor" strings, while preserving ACTUAL sensors (i.e. radar) labels
        if (r.startsWith("Sensor") && !"Sensor".equals(r)) r = r.replace("Sensor ","");

        // add spaces between capitalized groups. i.e. LooksLikeThis -> Looks Like This
        r = r.length() <= 3 ? r : Arrays.stream(r.split("(?=\\p{Lu})")).collect(Collectors.joining(" "));

        // fix up some cases where FSD is spaced out as F S D and has no trailing space
        return r.replace("F S D","FSD ");
    };

    InventoryData(ProcurementCost inventoryItem,
                  int quantity,
                  Function<ProcurementCost, Integer> checkInventory,
                  Function<ProcurementCost, Integer> pendingTradeCost,
                  Consumer<ProcurementTask> addTask)
    {
        this.inventoryItem = inventoryItem;
        this.quantity = quantity;
        this.gradeOrdinal = inventoryItem.getGrade().getNumericalValue();
        this.categoryOrdinal = MaterialSubCostCategory.findMatchingSubCategory(inventoryItem)
                .map(MaterialSubCostCategory::getNumericalValue)
                .orElse(-1);
        this.checkInventory = checkInventory;
        this.pendingTradeCost = pendingTradeCost;
        this.addTask = addTask;

        this.categoryString = getCategoryString();
        this.assoctiatedString = generateAssociatedString();

        mainGraphic.setAlignment(Pos.CENTER_LEFT);

        capacityBar.setPadding(new Insets(6,6,0,6));
    }

    /**
     * Renders the capacity bar UI element
     */
    private void renderProgress()
    {
        double progress = ((double) quantity / (double)getItem().getGrade().getMaximumQuantity());
        capacityBar.setProgress(progress);
        capacityBar.setStyle("-fx-accent: #ff7100");
    }

    /**
     * Generates a suitable "short description" of this item's category and classification.
     *
     * @return category string for this item
     */
    private String getCategoryString()
    {
        String category = "";
        if (inventoryItem instanceof Material)
        {
            Optional<MaterialSubCostCategory> matchingSubCategory =
                    MaterialSubCostCategory.findMatchingSubCategory(inventoryItem);

            category = matchingSubCategory.isPresent()
                    ? matchingSubCategory.get().toString()
                    : "(Unknown Material)" + inventoryItem;
        }
        else if (inventoryItem instanceof Commodity)
        {
            Optional<CommodityCostCategory> matchingCategory =
                    CommodityCostCategory.findMatchingCategory(inventoryItem);

            category = matchingCategory.isPresent()
                    ? matchingCategory.get().toString()
                    : "(Unknown Commodity)" + inventoryItem;
        }
        return category;
    }

    /**
     * Generates a Label object with text including a short description of the inventory item
     *
     * @return Label describing this item
     */
    private Label createNameLabel()
    {
        // build a string descriptor for this item and a Label used to display it in the GUI
        String itemDescriptor = categoryString + " :: " + getItem().getLocalizedName();
        Label nameLabel = new Label(itemDescriptor);
        nameLabel.setFont(UIFunctions.Fonts.size2Font);
        nameLabel.alignmentProperty().set(Pos.CENTER_LEFT);
        return nameLabel;
    }

    private Label createLocationHeaderLabel()
    {
        Label locationHeaderLabel = new Label("Relevant Locations");
        locationHeaderLabel.underlineProperty().setValue(true);
        locationHeaderLabel.setFont(UIFunctions.Fonts.size2Font);
        return locationHeaderLabel;
    }

    private Label createLocationInfoLabel()
    {
        Label locationInfoLabel = new Label(getItem().getLocationInformation());
        locationInfoLabel.setFont(UIFunctions.Fonts.size1Font);
        locationInfoLabel.alignmentProperty().set(Pos.CENTER_LEFT);
        return locationInfoLabel;
    }

    private String generateAssociatedString()
    {
        List<ProcurementRecipe> synthesisRecipes = new ArrayList<>();
        List<ProcurementRecipe> modificationRecipes = new ArrayList<>();
        List<ProcurementRecipe> experimentalRecipes = new ArrayList<>();
        List<ProcurementRecipe> weaponModRecipes = new ArrayList<>();
        List<ProcurementRecipe> techBrokerRecipes = new ArrayList<>();

        inventoryItem.getAssociated().forEach(i->
        {
            if (i instanceof SynthesisRecipe) synthesisRecipes.add(i);
            if (i instanceof ModificationRecipe) modificationRecipes.add(i);
            if (i instanceof WeaponModificationRecipe) weaponModRecipes.add(i);
            if (i instanceof ExperimentalRecipe) experimentalRecipes.add(i);
            if (i instanceof TechnologyRecipe) techBrokerRecipes.add(i);
        });


        //todo: make these buttons instead of just strings
        String synthesis = synthesisRecipes.isEmpty()
                ? ""
                : Arrays.stream(SynthesisBlueprint.values())
                        .flatMap(blueprint-> blueprint.recipeStream()
                                .filter(synthesisRecipes::contains)
                                .distinct()
                                .map(r -> blueprint.name() + " :: " + r.getGrade())
                                .map(s -> s.replace("_", " ")))
                        .collect(Collectors.joining("\n - ","\nSynthesis:\n - ", "\n"));

        String modifications = modificationRecipes.isEmpty() && weaponModRecipes.isEmpty()
                ? ""
                : Arrays.stream(ModificationBlueprint.values())
                        .flatMap(blueprint-> blueprint.recipeStream()
                                .filter(recipe -> modificationRecipes.contains(recipe) || weaponModRecipes.contains(recipe))
                                .distinct()
                                .map(r->formatModString.apply(blueprint.name()) + " :: " + r.getDisplayLabel()))
                        .collect(Collectors.joining("\n - ","\nModifications:\n - ", "\n"));

        String experiments = experimentalRecipes.isEmpty()
                ? ""
                : Arrays.stream(ExperimentalBlueprint.values())
                        .flatMap(blueprint-> blueprint.recipeStream()
                                .filter(experimentalRecipes::contains)
                                .distinct()
                                .map(r -> blueprint.name() + " :: " + r.getDisplayLabel())
                                .map(s -> s.replace("_", " ")))
                        .collect(Collectors.joining("\n - ","\nExperimental Effects:\n - ", "\n"));

        String techUnlocks = techBrokerRecipes.isEmpty()
                ? ""
                : Arrays.stream(TechnologyBlueprint.values())
                        .flatMap(blueprint-> blueprint.recipeStream()
                                .filter(techBrokerRecipes::contains)
                                .distinct()
                                .map(r -> blueprint.name() + " :: " + r.getShortLabel())
                                .map(s -> s.replace("_", " ")))
                        .collect(Collectors.joining("\n - ","\nTech Broker Unlocks:\n - ", "\n"));

        return synthesis + modifications + experiments + techUnlocks;
    }


    /**
     * Generates a TitledPane object used to house all of the information about the item. The pane's "title" in this
     * case if the name of the inventory item. When the pane is expanded (by clicking on it) the full details and
     * extra information about the item is displayed.
     *
     * @return TitledPane used to hold item information
     */
    private TitledPane createItemDataPane()
    {
        TitledPane dataPanel = new TitledPane();
        dataPanel.setAnimated(false);
        dataPanel.expandedProperty().setValue(false);
        dataPanel.setGraphic(createNameLabel());
        dataPanel.alignmentProperty().set(Pos.CENTER_LEFT);
        dataPanel.setOnMouseEntered((e)->renderHave());
        return dataPanel;
    }

    private void renderHave()
    {
        Integer committedCost = pendingTradeCost.apply(inventoryItem);
        int committed = (committedCost == null) ? 0 : committedCost;
        int have = checkInventory.apply(inventoryItem) - committed;
        haveCount.set(have);
    }

    /**
     * Renders the main UI component
     */
    private void render()
    {
        // render any progress first
        renderProgress();

        // just in case there was somehow something placed in the main component, we should clear it out
        mainGraphic.getChildren().clear();

        // this pane is the main UI element. By default it is not expanded, containing just a short description of
        // the item. When expanded, it will show more detailed information about the item including any relevant
        // locations in-game where the player might find or purchase the item, as well as known uses (if any) and
        // if tradeable at a material trader, any relevant trades.
        TitledPane itemDataPane = createItemDataPane();

        // add the data pane to the main graphic object
        mainGraphic.getChildren().add(itemDataPane);

        List<Button> buttons = new ArrayList<>();

        VBox itemDetails = new VBox();


        // WORKING AREA: upgrade/downgrade trade listings
        if (getItem() instanceof Material)
        {

            Optional<MaterialSubCostCategory> materialSubCostCategory =
                    MaterialSubCostCategory.findMatchingSubCategory(getItem());

            if (materialSubCostCategory.isPresent())
            {

                buttons = materialSubCostCategory.get().materials()
                        .filter(material -> material != inventoryItem)
                        .map(material -> material.getTradeBlueprint().orElse(null))
                        .filter(Objects::nonNull)
                        .flatMap(ProcurementBlueprint::recipeStream)
                        .filter(r->r.costStream().findFirst().get().getCost() == inventoryItem)
                        .map(recipe->
                        {
                            Optional<CostData> possibleTradeCost = recipe.costStream().findFirst();
                            Optional<CostData> possibleTradeYield = recipe.costStream().reduce((a, b) -> b);

                            if (possibleTradeCost.isPresent() && possibleTradeYield.isPresent())
                            {
                                if (materialSubCostCategory.get().hasMaterial(((Material) possibleTradeCost.get().getCost())))
                                {
                                    CostData tradeCost = possibleTradeCost.get();
                                    CostData tradeYield = possibleTradeYield.get();

                                    Optional<MaterialTradeType> tradeType =
                                            MaterialTradeType.findMatchingTradeType(((Material) tradeCost.getCost()));

                                    if (tradeType.isPresent())
                                    {
                                        Region from = UIFunctions.Convert.createMaterialIconRegion(tradeCost.getCost().getGrade().getIcon(), 25, 22);
                                        Region to = UIFunctions.Convert.createMaterialIconRegion(tradeYield.getCost().getGrade().getIcon(), 25, 22);

                                        Label toLabel = new Label(" to ");
                                        toLabel.setFont(UIFunctions.Fonts.size1Font);
                                        HBox convBox = new HBox(from, toLabel, to);

                                        ProcurementTask tradeTask = new ProcurementTask(tradeType.get(), recipe);

                                        VBox btnhldr = new VBox();
                                        HBox btnlbl = new HBox();

                                        Label descOpen = new Label();
                                        Label descHave = new Label();
                                        Label descClose = new Label();

                                        descOpen.setFont(UIFunctions.Fonts.size1Font);
                                        descHave.setFont(UIFunctions.Fonts.size1Font);
                                        descClose.setFont(UIFunctions.Fonts.size1Font);

                                        renderHave();

//                                        Integer committedCost = pendingTradeCost.apply(tradeCost.getCost());
//                                        int committed = (committedCost == null) ? 0 : committedCost;
//                                        int have = checkInventory.apply(tradeCost.getCost()) - committed;
//                                        haveCount.set(String.valueOf(have));

                                        String x = tradeCost.getQuantity()
                                                + " "
                                                + tradeCost.getCost().getLocalizedName()
                                                + " for "
                                                + Math.abs(tradeYield.getQuantity())
                                                + " "
                                                + tradeYield.getCost().getLocalizedName()
                                                + " (";

                                        descOpen.setText(x);
                                        descHave.textProperty().bind(haveCount.asString());
                                        descClose.setText(")");

                                        Region region1 = new Region();
                                        HBox.setHgrow(region1, Priority.ALWAYS);
                                        Region region2 = new Region();
                                        HBox.setHgrow(region2, Priority.ALWAYS);

                                        btnlbl.getChildren().add(descOpen);
                                        btnlbl.getChildren().add(descHave);
                                        btnlbl.getChildren().add(descClose);

                                        btnlbl.getChildren().add(region1);
                                        btnlbl.getChildren().add(convBox);
                                        btnhldr.getChildren().add(btnlbl);

                                        Button button = new Button();
                                        button.setGraphic(btnhldr);
                                        button.prefWidthProperty().bind(itemDetails.widthProperty());
                                        button.setOnMouseClicked((e) -> {
                                            addTask.accept(tradeTask);
                                            renderHave();
                                        });
                                        return button;
                                    }
                                }
                            }
                            return null;
                        })
                        .collect(Collectors.toList());
            }

        }
        // END WORKING AREA



        itemDetails.getChildren().add(createLocationHeaderLabel());
        itemDetails.getChildren().add(createLocationInfoLabel());
        itemDetails.setBackground(new Background(new BackgroundFill(
                Color.rgb(0xEE, 0xEE, 0xEE), CornerRadii.EMPTY, Insets.EMPTY)));

        Separator separator = new Separator();
        separator.paddingProperty().set(new Insets(5,0,5,0));
        itemDetails.getChildren().add(separator);


        if (!buttons.isEmpty()) itemDetails.getChildren().addAll(buttons);


        if (assoctiatedString.isEmpty())
        {
            Label noUses = new Label();
            noUses.setFont(UIFunctions.Fonts.size1Font);
            noUses.setText("No Crafting Uses");
            itemDetails.getChildren().add(noUses);
        }
        else
        {
            TitledPane knownUsesPane = new TitledPane();
            knownUsesPane.setAnimated(false);
            knownUsesPane.setExpanded(false);

            Label useLabel = new Label("Known Uses");
            useLabel.setFont(UIFunctions.Fonts.size1Font);

            Label associatedTasks = new Label(assoctiatedString.trim());
            associatedTasks.setFont(UIFunctions.Fonts.size1Font);


            VBox vBox = new VBox();
            HBox hBox = new HBox();
            hBox.getChildren().add(associatedTasks);
            vBox.getChildren().add(knownUsesPane);
            vBox.alignmentProperty().set(Pos.CENTER_LEFT);

            knownUsesPane.setContent(hBox);
            knownUsesPane.setGraphic(useLabel);
            itemDetails.getChildren().add(vBox);
            itemDetails.setAlignment(Pos.CENTER_LEFT);
        }

        itemDataPane.setContent(itemDetails);
    }

    @Override
    public String toString()
    {
        return inventoryItem + " : " + quantity;
    }

    public ProcurementCost getItem()
    {
        return inventoryItem;
    }

    public int getGradeOrdinal()
    {
        return gradeOrdinal;
    }

    public int getCategoryOrdinal()
    {
        return categoryOrdinal;
    }

    public int getQuantity()
    {
        return quantity;
    }

    boolean adjustCount(int adjustment)
    {
        this.quantity += adjustment;
        renderProgress();
        return quantity >= 0;
    }

    public void prepareGraphic()
    {
        if (!initialRenderComplete.getAndSet(true))
        {
            render();
        }
    }

    public Node getGraphic()
    {
        return mainGraphic;
    }

    public ProgressBar getProgressBar()
    {
        return capacityBar;
    }
}
