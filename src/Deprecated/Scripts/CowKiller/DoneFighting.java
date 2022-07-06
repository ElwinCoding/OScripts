package Deprecated.Scripts.CowKiller;

import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.script.TaskNode;

public class DoneFighting extends TaskNode {

    private StateMachine sm;

    public DoneFighting(StateMachine sm){
        this.sm = sm;
    }

    @Override
    public int priority() {
        return 2;
    }

    @Override
    public boolean accept() {
        return (!Players.localPlayer().isInCombat()) && (sm.getState() == StateMachine.State.ATTACKING);
    }

    @Override
    public int execute() {
        log("done fighting");
        sm.setState(StateMachine.State.COLLECTING);
        return 0;
    }


}
