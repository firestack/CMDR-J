package com.controllerface.cmdr_j.server.events;

import com.controllerface.cmdr_j.classes.GenericBody;
import com.controllerface.cmdr_j.classes.StarSystem;
import com.controllerface.cmdr_j.classes.StellarBody;
import com.controllerface.cmdr_j.server.GameState;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class FSDJumpEvent implements BiConsumer<GameState, Map<String, Object>>
{
    @Override
    @SuppressWarnings("unchecked")
    public void accept(GameState gameState, Map<String, Object> event)
    {
        var name = ((String) event.get("StarSystem"));
        var address = ((Number) event.get("SystemAddress")).longValue();
        var coordinates = ((List<Double>) event.get("StarPos"));
        var system = new StarSystem(name, coordinates.get(0), coordinates.get(2), coordinates.get(1), address);

        gameState.setLocation(system);
        gameState.emitEngineerData();

        var bodyID = ((Number) event.get("BodyID")).intValue();
        var bodyName = ((String) event.get("Body"));
        var bodyType = StellarBody.BodyType.determineType(((String) event.get("BodyType")));
        var body = new GenericBody(bodyType, bodyName, bodyID, address);

        gameState.discoverStellarBody(body);
        gameState.emitCartographyData();

        var factions = ((List<Map<String, Object>>) event.get("Factions"));
        if (factions == null || factions.isEmpty())
        {
            gameState.clearFactionData();
        }
        else
        {
            gameState.acceptFactionData(factions);
        }
    }
}
