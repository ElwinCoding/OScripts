package Scripts.CowKiller;

import org.dreambot.api.script.TaskNode;

public class Decision extends TaskNode {

    private StateMachine sm;

    public Decision(StateMachine sm) {
        this.sm = sm;
    }

    @Override
    public boolean accept() {
        return sm.getState() == StateMachine.State.IDLE;
    }

    @Override
    public int execute() {
        log("decision");
        sm.setState(StateMachine.State.START_ATTACKING);
        return 0;
    }
}