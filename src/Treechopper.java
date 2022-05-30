import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.Category;

@ScriptManifest(author = "You", name = "TreeChopper", version = 1.0, description = "chop trees", category = Category.WOODCUTTING)


public class Treechopper extends AbstractScript {


    public void onStart() {
        log("tree chopper is now starting.");
    }


    @Override
    public int onLoop() {

        return -1;
    }
}
