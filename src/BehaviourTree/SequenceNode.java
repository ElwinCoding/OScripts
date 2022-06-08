package BehaviourTree;

import java.util.List;

public class SequenceNode implements BehaviourNode {

    public List<BehaviourNode> children;

    @Override
    public boolean evaluate() {
        for(BehaviourNode bn: children) {
            boolean result = bn.evaluate();
        }
        return false;
    }
}
