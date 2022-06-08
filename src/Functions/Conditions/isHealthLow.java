package Functions.Conditions;
import Functions.ConditionFunction;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;

import java.util.function.Supplier;



public class isHealthLow implements ConditionFunction {
    public int HEALTH_THRESHOLD = 7;

    @Override
    public Boolean get(){
        return Skills.getBoostedLevels(Skill.HITPOINTS) < HEALTH_THRESHOLD;
    }
}