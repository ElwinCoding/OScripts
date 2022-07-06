package Current.BehaviourNodes;

import Current.Functions.Leaf;
import lombok.Builder;

@Builder
public class Action implements Behaviour{
    Leaf func;

    public Action(Leaf func) {this.func = func;}

    @Override
    public States execute() {
        return func.get();
    }
}
