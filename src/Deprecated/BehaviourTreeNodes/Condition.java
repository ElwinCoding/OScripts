package Deprecated.BehaviourTreeNodes;

import lombok.Builder;


@Builder
public class Condition implements Behaviour {
    Deprecated.Functions.Condition func;

    public Condition(Deprecated.Functions.Condition func){
        this.func = func;
    }

    @Override
    public boolean execute() {
        return func.get();
    }

}
