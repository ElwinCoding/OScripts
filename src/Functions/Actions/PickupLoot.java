package Functions.Actions;

import Functions.Action;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.item.GroundItems;
import org.dreambot.api.wrappers.items.GroundItem;

import java.util.List;

public class PickupLoot implements Action {

    private List<String> loot_names;

    public PickupLoot(List<String> loot_names){
        this.loot_names = loot_names;
    }

    @Override
    public Boolean get() {
        Boolean status = false;
        for(String loot_name : loot_names){
            GroundItem item = GroundItems.closest(loot_name);
            if (item != null){
                item.interact("Take");
                MethodProvider.sleep(600, 1200);
                status = true;
            }
        }
        return status;
    }
}
