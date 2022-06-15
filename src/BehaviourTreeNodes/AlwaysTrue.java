package BehaviourTreeNodes;

import lombok.Builder;

@Builder
public class AlwaysTrue implements Behaviour{
    private Behaviour child;

    @Override
    public boolean execute() {
        child.execute();
        return true;
    }
}
