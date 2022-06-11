package Functions.Conditions;

import Functions.Condition;
import org.dreambot.api.methods.interactive.Players;

public class CheckUnderAttack implements Condition {
    @Override
    public Boolean get() {
        return Players.localPlayer().isInCombat();
    }
}
