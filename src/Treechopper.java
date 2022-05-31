import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.Category;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.wrappers.interactive.Character;
@ScriptManifest(author = "You", name = "TreeChopper", version = 1.0, description = "chop trees", category = Category.WOODCUTTING)


public class Treechopper extends AbstractScript {


    public void onStart() {
        log("tree chopper is now starting.");
    }


    @Override
    public int onLoop() {
        GameObject tree = GameObjects.closest("Tree");
        if (tree != null) {
            tree.interact("Chop Down");
            sleep(2000);
        }
        while (getLocalPlayer().isAnimating()) {
            sleep(1000);
        }
        log("fuck");
        Inventory.drop("Logs");
        return -1;
    }

    public void onExit() {
        log("Tree chopper has finished chopping");
    }
}
