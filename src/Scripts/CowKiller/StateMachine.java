package Scripts.CowKiller;

public class StateMachine {
    enum State{
        ATTACKING,
        COLLECTING,
        IDLE,
        START_ATTACKING,
        BANKING
    }

    private State state = State.IDLE;

    public void setState(State newState){
        state = newState;
    }

    public State getState(){
        return state;
    }

}
