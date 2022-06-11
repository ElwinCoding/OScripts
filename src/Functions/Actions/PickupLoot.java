package Functions.Actions;

import Functions.Action;
import org.dreambot.api.methods.item.GroundItems;
import org.dreambot.api.wrappers.items.GroundItem;

public class PickupLoot implements Action {

    private String loot_name;

    public PickupLoot(String loot_name){
        this.loot_name = loot_name;
    }

    @Override
    public Boolean get() {
        GroundItem item = GroundItems.closest(loot_name);
        if (item != null){
            item.interact("Take");
            return true;
        }
        return false;
    }
}
