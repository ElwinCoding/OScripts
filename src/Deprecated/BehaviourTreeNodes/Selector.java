package Deprecated.BehaviourTreeNodes;
import lombok.Builder;
import lombok.Singular;

import java.util.List;

@Builder
public class Selector implements Behaviour {
    @Singular
    private List<Behaviour> children;

    @Override
    public boolean execute() {
        for(Behaviour bn: children) {
            if (bn.execute()) {
                return true;
            }
        }
        return false;
    }


}