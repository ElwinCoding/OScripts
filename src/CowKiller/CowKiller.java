package CowKiller;
import Woodcutting.ChopTask;
import Woodcutting.DropTask;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.SkillTracker;
import org.dreambot.api.script.impl.TaskScript;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.Category;
import org.dreambot.api.Client;

@ScriptManifest(
        author = "You",
        name = "CowKiller", version = 1.0,
        description = "Kill some cows",
        category = Category.COMBAT
)

public class CowKiller extends TaskScript{

    StateMachine sm = new StateMachine();

    public void onStart(){
        addNodes(
                new AttackCow(sm),
                new GoToBank(sm),
                new PickUpItem(sm),
                new Eat(sm)
        );
        log("Cow Killer is now running.");
    }

    public void onExit(){
        log("It is over.");
    }
}
