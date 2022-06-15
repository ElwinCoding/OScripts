package Functions.Actions;

import Functions.Action;

import static org.dreambot.api.Client.getLocalPlayer;
import static org.dreambot.api.methods.MethodProvider.log;
import static org.dreambot.api.methods.MethodProvider.sleepUntil;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.utilities.impl.Condition;
import org.dreambot.api.wrappers.interactive.NPC;

public class AttackNearest implements Action {
    private String npc_name;

    public AttackNearest(String npc_name){
        this.npc_name = npc_name;
    }

    @Override
    public Boolean get() {
        NPC npc = NPCs.closest(npc_name);
        if (npc == null){
            return false;
        }
        if(npc.canAttack() && !npc.isInCombat() && npc.canReach()){
            npc.interact("Attack");
            log("Attacking.");
            log("Preparing to sleep.");
            sleepUntil(() -> getLocalPlayer().isInCombat(), 1200);
            log("Woke up.");
            return true;
        }
        return false;
    }
}