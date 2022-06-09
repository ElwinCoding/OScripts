package BehaviourTreeNodes;

import lombok.Builder;


@Builder
public class Condition implements Behaviour {
    Functions.Condition func;

    public Condition(Functions.Condition func){
        this.func = func;
    }

    @Override
    public boolean execute() {
        return func.get();
    }

}
