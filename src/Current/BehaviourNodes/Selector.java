package Current.BehaviourNodes;

import lombok.Builder;
import lombok.Singular;

import java.util.List;

@Builder
public class Selector implements Behaviour{
    @Singular
    private List<Behaviour> children;

    @Override
    public States execute() {
        for(Behaviour bn: children) {
            if (bn.execute() == States.RUNNING) {
                return States.RUNNING;
            }
            else if (bn.execute() == States.SUCCESS) {
                return States.SUCCESS;
            }
        }
        return States.FAILURE;
    }
}
