package CowKiller;

public class StateMachine {
    enum State{
        ATTACKING,
        COLLECTING,
        IDLE,
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
