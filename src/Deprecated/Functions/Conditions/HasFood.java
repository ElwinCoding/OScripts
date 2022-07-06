package Deprecated.Functions.Conditions;

import Deprecated.Functions.Condition;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.wrappers.items.Item;

public class HasFood implements Condition {
    @Override
    public Boolean get() {
        Item food = Inventory.get(item -> item.hasAction("Eat"));
        if (food == null) {return false;}
        else {return true;}
    }
}