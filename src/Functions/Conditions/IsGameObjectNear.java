package Functions.Conditions;

import Functions.Condition;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.interactive.GameObject;
import static org.dreambot.api.methods.MethodProvider.log;

public class IsGameObjectNear implements Condition {
    private final String object;

    public IsGameObjectNear(String object){
        this.object = object;
    }

    @Override
    public Boolean get() {
        log("checking if object near.");
        GameObject object_to_reach = GameObjects.closest(object);
        if(object_to_reach == null){
            return false;
        }
        Tile player_location = Players.localPlayer().getTile();
        Area surrounding_area = Area.generateArea(3, player_location);
        return surrounding_area.contains(object_to_reach);
    }
}
