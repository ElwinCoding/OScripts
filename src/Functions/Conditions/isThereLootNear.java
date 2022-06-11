package Functions.Conditions;

import Functions.Condition;
import static org.dreambot.api.methods.MethodProvider.log;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.item.GroundItems;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.items.GroundItem;
import org.dreambot.api.wrappers.items.Item;


public class isThereLootNear implements Condition {
    private String loot_name;

    public isThereLootNear(String loot_name){
        this.loot_name = loot_name;
    }

    @Override
    public Boolean get() {
        log("Checking if loot near.");
        Tile player_location = Players.localPlayer().getTile();
        Area surrounding_area = Area.generateArea(3, player_location);
        GroundItem item = GroundItems.closest(loot_name);
        if (item == null){
            return false;
        }
        if (surrounding_area.contains(item.getTile())){
            item.interact("Take");
            return true;
        }
        return false;
    }
}
