package Woodcutting;

import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.script.TaskNode;

public class ChopTask extends TaskNode {

    @Override
    // check if inventory
    public boolean accept() {
        return !Inventory.isFull() && !isChopping();
    }

    @Override
    // perform task
    public int execute() {
        GameObject tree = GameObjects.closest(TreechopperMain.tree);
        if (tree != null) {
            tree.interact("Chop Down");
        }
        return 5000;
    }

    // return if character is performing action
    private boolean isChopping() {
        return getLocalPlayer().isAnimating();
    }
}
