package Deprecated.Functions.Actions;

import Deprecated.Functions.Action;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.wrappers.items.Item;

import static org.dreambot.api.methods.MethodProvider.log;

public class EatFood implements Action {

    @Override
    public Boolean get() {
        // check if inventory tab is open
        log("Preparing to eat.");
        if (!Tabs.isOpen(Tab.INVENTORY)) {
            Tabs.openWithFKey(Tab.INVENTORY);
        }
        // eat the food if available
        Item food = Inventory.get(item -> item.hasAction("Eat"));
        if (food == null) {
            log("Found no food");
            return false;
        }
        else {
            food.interact("Eat");
            return true;
        }
    }
}
