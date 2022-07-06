package Deprecated.BehaviourTreeNodes;

import lombok.Builder;

@Builder
public class AlwaysFalse implements Behaviour{
    private Behaviour child;

    @Override
    public boolean execute() {
        child.execute();
        return false;
    }
}
