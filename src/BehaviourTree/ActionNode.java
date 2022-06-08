package BehaviourTree;

import Functions.ActionFunction;
import lombok.Builder;


@Builder
public class ActionNode implements BehaviourNode {
    ActionFunction func;

    public ActionNode(ActionFunction func){
        this.func = func;
    }

    @Override
    public boolean execute() {
        return func.get();
    }

}
