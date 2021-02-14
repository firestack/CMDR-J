package com.controllerface.cmdr_j.server.events;

import com.controllerface.cmdr_j.enums.costs.commodities.Commodity;
import com.controllerface.cmdr_j.server.GameState;

import java.util.Map;
import java.util.function.BiConsumer;

public class SellDronesEvent implements BiConsumer<GameState, Map<String, Object>>
{
    @Override
    public void accept(GameState gameState, Map<String, Object> event)
    {
        var count = ((Number) event.get("Count")).intValue();
        gameState.adjustCargoCount(Commodity.DRONES, -1 * count);

        var sale = ((Number) event.get("TotalSale")).intValue();
        gameState.adjustCreditBalance(sale);
    }
}
