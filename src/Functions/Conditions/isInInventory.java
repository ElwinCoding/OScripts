package Functions.Conditions;

import Functions.Condition;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.interactive.Players;
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
