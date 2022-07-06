package Deprecated.Functions.Conditions;

import Deprecated.Functions.Condition;
import org.dreambot.api.methods.container.impl.Inventory;

import static org.dreambot.api.methods.MethodProvider.log;

public class isInInventory implements Condition {
    final private String item;

    public isInInventory(String item){
        this.item = item;
    }

    @Override
    public Boolean get() {
        log("Checking if in inventory.");
        return Inventory.contains(item);
    }
}
