package Functions.Actions;

import Functions.Action;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.wrappers.items.Item;

public class BuryBones implements Action {
    @Override
    public Boolean get() {
        Item bones = Inventory.get(item -> item.hasAction("Bury"));
        return bones.interact("Bury");
    }
}
