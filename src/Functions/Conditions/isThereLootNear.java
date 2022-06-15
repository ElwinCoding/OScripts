package Functions.Conditions;

import Functions.Condition;
import static org.dreambot.api.methods.MethodProvider.log;
import static org.dreambot.api.methods.MethodProvider.sleep;

import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.item.GroundItems;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.items.GroundItem;
import org.dreambot.api.wrappers.items.Item;

import java.util.List;
import java.util.Random;


public class isThereLootNear implements Condition {
    final private List<String> loot_names;

    public isThereLootNear(List<String> loot_names){
        this.loot_names = loot_names;
    }

    @Override
    public Boolean get() {
        log("Checking if loot near.");
        Tile player_location = Players.localPlayer().getTile();
        Area surrounding_area = Area.generateArea(3, player_location);
        Boolean loot_near = false;
        for(String loot_name : this.loot_names) {
            GroundItem item = GroundItems.closest(loot_name);
            if (item != null && item.canReach() && surrounding_area.contains(item.getTile())) {
                item.interact("Take");
                sleep(500 + (int) (Math.random() * 800));
                loot_near = true;
            }
        }
        return loot_near;
    }
}
