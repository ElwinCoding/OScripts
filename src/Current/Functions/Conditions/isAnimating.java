package Current.Functions.Conditions;

import Current.Functions.Leaf;
import Current.BehaviourNodes.States;

import static org.dreambot.api.Client.getLocalPlayer;

public class isAnimating implements Leaf {

    @Override
    public States get() {
        boolean check = getLocalPlayer().isAnimating();
        if (check) {
            return States.SUCCESS;
        }
        else {
            return States.FAILURE;
        }
    }
}
