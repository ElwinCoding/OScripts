package Functions.Actions;

import Functions.Action;
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
        if(npc.canAttack() && !npc.isInCombat()){
            npc.interact("Attack");
            log("Attacking.");
            CheckUnderAttack predicate = new CheckUnderAttack();
            log("Preparing to sleep.");
            sleepUntil(predicate, 1200);
            log("Woke up.");
            return true;
        }
        return false;
    }
}

class CheckUnderAttack implements org.dreambot.api.utilities.impl.Condition{
    @Override
    public boolean verify() {
        return Players.localPlayer().isInCombat();
    }
}
