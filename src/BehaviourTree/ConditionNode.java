package BehaviourTree;

import Functions.ConditionFunction;
import lombok.Builder;

import java.util.function.Supplier;


@Builder
public class ConditionNode implements BehaviourNode{
    ConditionFunction func;

    public ConditionNode(ConditionFunction func){
        this.func = func;
    }

    @Override
    public boolean execute() {
        return func.get();
    }

}
