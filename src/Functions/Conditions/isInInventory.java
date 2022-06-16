package Functions.Conditions;

import Functions.Condition;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.interactive.Players;

public class isInInventory implements Condition {
    final private String item;

    public isInInventory(String item){
        this.item = item;
    }

    @Override
    public Boolean get() {
        return Inventory.contains(item);
    }
}
