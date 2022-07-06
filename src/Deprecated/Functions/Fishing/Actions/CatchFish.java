package Deprecated.Functions.Fishing.Actions;

import Deprecated.Functions.Action;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.wrappers.interactive.NPC;

import static org.dreambot.api.Client.getLocalPlayer;
import static org.dreambot.api.methods.MethodProvider.log;
import static org.dreambot.api.methods.MethodProvider.sleepUntil;

public class CatchFish implements Action {

    private String action;

    public CatchFish(String spot) {
        this.action = spot;
    }

    @Override
    public Boolean get() {
        NPC fishing_spot = NPCs.closest(fspot -> fspot.hasAction(action));
        if (fishing_spot == null) {
            log("could not find " + action + " fishing spot");
            return false;
        }
        else {
            log("found fishing spot, preparing to fish");
            fishing_spot.interact(action);
        }
        sleepUntil(() -> getLocalPlayer().isAnimating(), 5000);
        return true;
    }
}
