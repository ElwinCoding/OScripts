package Current.BehaviourNodes;

import lombok.Builder;

@Builder
public class Inverter implements Behaviour{

    private Behaviour child;

    @Override
    public States execute() {
        States result = child.execute();
        if (result == States.FAILURE) {
            return States.RUNNING;
        }
        else if (result == States.SUCCESS) {
            return States.FAILURE;
        }
        else {
            return States.RUNNING;
        }
    }
}
