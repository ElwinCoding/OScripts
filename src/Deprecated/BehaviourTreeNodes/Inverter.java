package Deprecated.BehaviourTreeNodes;

import lombok.Builder;

import static org.dreambot.api.methods.MethodProvider.log;

@Builder
public class Inverter implements Behaviour{

    private Behaviour child;

    @Override
    public boolean execute() {
        Boolean guh = child.execute();
        return !guh;
    }
}
