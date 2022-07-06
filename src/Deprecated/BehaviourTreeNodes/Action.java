package Deprecated.BehaviourTreeNodes;

import lombok.Builder;


@Builder
public class Action implements Behaviour {
    Deprecated.Functions.Action func;

    public Action(Deprecated.Functions.Action func){
        this.func = func;
    }

    @Override
    public boolean execute() {
        return func.get();
    }

}
