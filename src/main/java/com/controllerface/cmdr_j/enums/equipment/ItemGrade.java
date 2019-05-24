package com.controllerface.cmdr_j.enums.equipment;

import com.controllerface.cmdr_j.ui.UIFunctions;
import javafx.scene.shape.SVGPath;

/**
 * An enumeration of items grades in Elite: Dangerous. Some grade values may be used for multiple purposes
 *
 * Created by Controllerface on 3/20/2018.
 */
public enum ItemGrade
{
    /*
    Generic Grades, used for materials and engineering modifications
     */
    GRADE_1(1, "Grade 1"),
    GRADE_2(2, "Grade 2"),
    GRADE_3(3, "Grade 3"),
    GRADE_4(4, "Grade 4"),
    GRADE_5(5, "Grade 5"),

    VERY_COMMON(1, 300, "Very Common", UIFunctions.Icons.materialGrade1),
    COMMON(2, 250, "Common", UIFunctions.Icons.materialGrade2),
    STANDARD(3, 200, "Standard", UIFunctions.Icons.materialGrade3),
    RARE(4, 150, "Rare", UIFunctions.Icons.materialGrade4),
    VERY_RARE(5, 100, "Very Rare", UIFunctions.Icons.materialGrade5),

    /*
    Used for Engineer experimental effects
     */
    Experimental(6, "Experimental"),

    /*
    Used for items unlocked via Tech Brokers
     */
    Technology(7, "Tech Broker"),

    /*
    Synthesis Grades
     */
    SYNTHESIS_BASIC(1, "Basic"),
    SYNTHESIS_STANDARD(2, "Standard"),
    SYNTHESIS_PREMIUM(3, "Premium"),

    /*
    Cargo Types. These are used mainly for differentiating where certain items are found, and making sorting of items
    in the inventory tab easier
     */

    Drone(0, "Limpet Drone", "Starport Restock Services"),   // standard commodities and salvage
    Space(1, "Commodity", "Starport Commodity Markets"),   // standard commodities and salvage
    Planet(2, "Planetary Port", "Planetary Port Commodity Markets"),  // only available at planetary ports
    Mining(3, "Asteroid Mining", "Asteroid and Planetary Ring Mining"),  // attainable by mining only
    Mission(4, "Mission", "Mission Rewards"), // mission reward exclusive
    POI(5, "Planetary POI", "Planetary Points of Interest"),     // must be found at planetary POI
    Salvage(6, "Salvage", "Various locations:\n - Combat Wreckage\n - Unidentified Signal Sources\n - Ancient Ruins"),   // salvage
    Rare(7, "Rare Commodity", "Exclusive to Star Port"),    // rare commodities, from specific star ports
    Faction(8, "Faction", "Power Play Faction Contact"), // power play specific items

    MaterialTrade(0, -1, "Trade"),

    Any(0,-1,"Any"),
    ;

    private final int numericalValue;
    private final int maximumQuantity;
    private final String text;
    private final String locationDescription;
    private final SVGPath icon;

    ItemGrade(int numericalValue, String text)
    {
        this(numericalValue, -1, text, "", null);
    }

    ItemGrade(int numericalValue, int maximumQuantity, String text)
    {
        this(numericalValue, maximumQuantity, text, "", null);
    }

    ItemGrade(int numericalValue, int maximumQuantity, String text, SVGPath icon)
    {
        this(numericalValue, maximumQuantity, text, "", icon);
    }

    ItemGrade(int numericalValue, String text, String locationDescription)
    {
        this(numericalValue, -1, text, locationDescription, null);
    }

    ItemGrade(int numericalValue, int maximumQuantity, String text, String locationDescription, SVGPath icon)
    {
        this.numericalValue = numericalValue;
        this.maximumQuantity = maximumQuantity;
        this.text = text;
        this.locationDescription = locationDescription;
        this.icon = icon;
    }

    @Override
    public String toString()
    {
        return text;
    }

    public String getLocationDescription()
    {
        return locationDescription;
    }

    public int getNumericalValue()
    {
        return numericalValue;
    }

    public int getMaximumQuantity()
    {
        return maximumQuantity;
    }

    public SVGPath getIcon()
    {
        return icon;
    }

    public static int compare(ItemGrade a, ItemGrade b)
    {
        return Integer.compare(a.numericalValue, b.numericalValue);
    }
}