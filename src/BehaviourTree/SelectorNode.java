package BehaviourTree;
import lombok.Builder;

import java.util.List;

@Builder
public class SelectorNode implements BehaviourNode{

    private List<BehaviourNode> children;

    @Override
    public boolean execute() {
        for(BehaviourNode bn: children) {
            if (bn.execute()) {
                return true;
            }
        }
        return false;
    }


}