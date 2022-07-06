package Deprecated.Functions.Conditions;

import Deprecated.Functions.Condition;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;


public class isHealthLow implements Condition {
    public int HEALTH_THRESHOLD = 7;

    @Override
    public Boolean get(){
        MethodProvider.log("Checking Health.");
        return (Skills.getBoostedLevels(Skill.HITPOINTS) > HEALTH_THRESHOLD);
    }
}
