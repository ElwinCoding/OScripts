package Scripts.CowKiller;

import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.wrappers.interactive.NPC;


public class AttackCow extends TaskNode {
    
    private StateMachine sm;

    public AttackCow(StateMachine sm){
        this.sm = sm;
    }

    @Override
    public boolean accept() {
        return sm.getState() == StateMachine.State.START_ATTACKING;
    }

    @Override
    public int execute() {
        log("Executing AttackCow.");
        NPC cow = NPCs.closest("Cow calf");
        if(cow.canAttack() && !cow.isInCombat()){
            cow.interact("Attack");
            log("Attacking Cow.");
        }

        sm.setState(StateMachine.State.ATTACKING);
        return 1000;
    }
}
