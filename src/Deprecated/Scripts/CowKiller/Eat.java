package Deprecated.Scripts.CowKiller;

import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.wrappers.items.Item;

public class Eat extends TaskNode {
    private int HEALTH_THRESHOLD = 5;
    
    private StateMachine sm;

    public Eat(StateMachine sm){
        this.sm = sm;
    }

    @Override
    public boolean accept() {
        return isHealthLow();
    }

    @Override
    public int execute() {
        eatFood();
        log("Health low. Eating Food.");
        return 0;
    }

    private boolean isHealthLow(){
        return Skills.getBoostedLevels(Skill.HITPOINTS) < HEALTH_THRESHOLD;
    }

    @Override
    public int priority() {
        return 2;
    }

    public void eatFood() {
        Item food = Inventory.get("Cooked meat");
        if (food != null) {
            food.interact("Eat");
        }
    }
}
