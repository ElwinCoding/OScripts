package Deprecated.Scripts.Misc;

import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.Category;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.wrappers.interactive.NPC;
import org.dreambot.api.methods.dialogues.Dialogues;

@ScriptManifest(author = "You", name = "Tutorial Island", version = 1.0, description = "Getting off Tutorial Island", category = Category.MISC)


public class Tutorial extends AbstractScript {

    public void onStart() {
        log("The script has started.");
    }

     private boolean Gielinor() {
         NPC guide = NPCs.closest("Gielinor Guide");
         if (guide != null) {
             guide.interact();
             while (!Dialogues.areOptionsAvailable()) {
                 Dialogues.clickContinue();
                 sleep(1000,7000);
             }
         }
         return false;
     }

    @Override
    public int onLoop() {
        if (!Gielinor()) {
            log("Gielinor has broke.");
        }
        else {
            log("talk sucess.");
        }
        return -1;
    }

    @Override
    public void onExit() {
        log("The script has finished.");
    }
}
