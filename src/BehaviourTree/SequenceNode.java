package BehaviourTree;

import lombok.Builder;
import lombok.Singular;

import java.util.List;

@Builder
public class SequenceNode implements BehaviourNode {
    @Singular
    private List<BehaviourNode> children;

    @Override
    public boolean execute() {
        for(BehaviourNode bn: children) {
             if (!bn.execute()) {
                 return false;
             }
        }
        return true;
    }
}
