package Deprecated.Scripts.CowKiller;
import org.dreambot.api.script.impl.TaskScript;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.Category;

@ScriptManifest(
        author = "You",
        name = "CowKiller", version = 1.0,
        description = "Kill some cows",
        category = Category.COMBAT
)

public class CowKiller extends TaskScript{

    public void onStart(){
        StateMachine sm = new StateMachine();
        addNodes(
                new AttackCow(sm),
                new GoToBank(sm),
                new PickUpItem(sm),
                new Eat(sm),
                new Decision(sm),
                new DoneFighting(sm)
        );
        log("Cow Killer is now running.");
    }

    public void onExit(){
        log("It is over.");
    }
}
