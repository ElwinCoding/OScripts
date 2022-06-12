package Scripts.Woodcutting;

import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.methods.walking.impl.Walking;
import static org.dreambot.api.methods.walking.web.node.impl.bank.WebBankArea.DRAYNOR_MARKET;

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
        sleep(1000,6000);
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
        Tile destination = DRAYNOR_MARKET.getArea().getRandomTile();
        Walking.walk(destination);
    }
}
