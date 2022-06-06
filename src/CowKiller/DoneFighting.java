package CowKiller;

import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.script.TaskNode;

public class DoneFighting extends TaskNode {

    static StateMachine state;

    public DoneFighting(StateMachine state){
        state = state;
    }

    @Override
    public boolean accept() {
        return Players.localPlayer().isInCombat() && state.getState() == StateMachine.State.ATTACKING;
    }

    @Override
    public int execute() {
        state.setState(StateMachine.State.COLLECTING);
        return 0;
    }


}
