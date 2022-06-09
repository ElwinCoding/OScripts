package BehaviourTreeNodes;

import lombok.Builder;

@Builder
public class Inverter implements Behaviour{

    private Behaviour child;

    @Override
    public boolean execute() {
        return !child.execute();
    }
}
