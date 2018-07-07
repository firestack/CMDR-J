package com.controllerface.cmdr_j.ui.ship;

import com.controllerface.cmdr_j.data.commander.ShipStatisticData;
import com.controllerface.cmdr_j.ui.UIFunctions;
import javafx.scene.control.TableCell;

/**
 * Created by Controllerface on 5/7/2018.
 */
public class StatDisplayCell extends TableCell<ShipStatisticData, ShipStatisticData>
{
    @Override
    protected void updateItem(ShipStatisticData item, boolean empty)
    {
        super.updateItem(item, empty);

        if (item == null || empty)
        {
            setText(null);
            setGraphic(null);
            return;
        }

        super.setText(item.statDisplayValue());
        setFont(UIFunctions.Fonts.size3Font);
    }
}