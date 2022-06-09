package Functions.Conditions;

import Functions.Condition;
import org.dreambot.api.methods.container.impl.Inventory;

public class isInventoryFull implements Condition {

    @Override
    public Boolean get() { return Inventory.isFull(); }
}
