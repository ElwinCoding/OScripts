package Functions.Conditions;

import Functions.Condition;
import org.dreambot.api.methods.container.impl.Inventory;

import static org.dreambot.api.methods.MethodProvider.log;

public class BaitCheck implements Condition {

    String bait;

    public BaitCheck(String bait) {
        this.bait = bait;
    }

    @Override
    public Boolean get() {
        //log("checking for bait");
        if (bait == null) {
            //log("there is no applicable bait");
            return true;
        }
        return Inventory.contains(item -> item.getName().contains(bait));
    }
}
