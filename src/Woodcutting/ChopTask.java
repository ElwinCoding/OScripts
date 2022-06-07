package Woodcutting;

import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.script.TaskNode;

public class ChopTask extends TaskNode {

    String name = TreechopperMain.tree;

    @Override
    // check if inventory
    public boolean accept() {
        return !Inventory.isFull() && !isChopping();
    }

    @Override
    // perform task
    public int execute() {
        GameObject tree = GameObjects.closest(name);
        if (tree == null) {
            travel(name);
            tree = GameObjects.closest(name);
        }
        tree.interact("Chop Down");
        return 3000;
    }

    // return if character is performing action
    private boolean isChopping() {
        return getLocalPlayer().isAnimating();
    }

    private void travel(String name) {

    }
}
