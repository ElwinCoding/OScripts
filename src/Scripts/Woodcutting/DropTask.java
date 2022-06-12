package Scripts.Woodcutting;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.script.TaskNode;

public class DropTask extends TaskNode {

    @Override
    public boolean accept() {
        return Inventory.isFull();
    }

    @Override
    public int execute() {
        Inventory.dropAll(item -> item.getName().contains("Logs"));

        return Calculations.random(300,600);
    }
}
