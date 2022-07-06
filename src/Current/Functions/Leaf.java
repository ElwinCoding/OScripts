package Current.Functions;

import Current.BehaviourNodes.States;

import java.util.function.Supplier;

public interface Leaf extends Supplier<States> {

    @Override
    States get();
}
