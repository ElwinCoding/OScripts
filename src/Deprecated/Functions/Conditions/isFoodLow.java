package Deprecated.Functions.Conditions;

import Deprecated.Functions.Condition;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;

public class isFoodLow implements Condition {
    private int number_of_food;

    public isFoodLow(int number_of_food){
        this.number_of_food = number_of_food;
    }

    @Override
    public Boolean get() {
        if (!Tabs.isOpen(Tab.INVENTORY)) {
            Tabs.openWithFKey(Tab.INVENTORY);
        }
        int count = Inventory.count(item -> item.hasAction("Eat"));
        if (count < number_of_food){
            return false;
        }
        else {
            return true;
        }
    }
}
