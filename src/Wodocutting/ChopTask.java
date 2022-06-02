/*
package Wodocutting;

import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.methods.container.impl.Inventory;

@Override
public int onLoop() {
        GameObject tree = GameObjects.closest("Tree");
        if (tree != null) {
        tree.interact("Chop Down");
        sleep(3000);
        }
        while (getLocalPlayer().isAnimating()) {
        sleep(2000);
        }
        log("bitch");
        Inventory.drop("Logs");
        return -1;
        }

public class ChopTask {
}
*/