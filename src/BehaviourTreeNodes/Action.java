package BehaviourTreeNodes;

import lombok.Builder;


@Builder
public class Action implements Behaviour {
    Functions.Action func;

    public Action(Functions.Action func){
        this.func = func;
    }

    @Override
    public boolean execute() {
        return func.get();
    }

}
