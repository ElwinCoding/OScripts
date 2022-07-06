package Current.BehaviourNodes;

import Current.Functions.Leaf;
import lombok.Builder;

@Builder
public class Condition implements Behaviour{
    Leaf func;

    public Condition(Leaf func) {this.func = func;}

    @Override
    public States execute() {
        return func.get();
    }
}
