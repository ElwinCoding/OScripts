package Deprecated.Functions.Conditions;

import Deprecated.Functions.Condition;

import static org.dreambot.api.Client.getLocalPlayer;

public class isAnimating implements Condition {

    @Override
    public Boolean get() {
        return getLocalPlayer().isAnimating();
    }
}
