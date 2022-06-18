package Functions.Conditions;

import Functions.Condition;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.wrappers.items.Item;

public class IsBonesInInventory implements Condition {

    @Override
    public Boolean get() {
        Item bones = Inventory.get(item -> item.hasAction("Bury"));
        if(bones == null){
            return false;
        }
        else{
            return true;
        }
    }
}
