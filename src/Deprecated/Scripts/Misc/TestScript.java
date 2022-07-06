package Deprecated.Scripts.Misc;

import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.Category;

@ScriptManifest(author = "You", name = "My First Script", version = 1.0, description = "hello", category = Category.WOODCUTTING)


public class TestScript extends AbstractScript {
    @Override
    public int onLoop() {
        log("My first script!");
        log("hello world");
        return 5000;
    }
}
