package Functions.Conditions;
import Functions.Condition;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;


public class isHealthLow implements Condition {
    public int HEALTH_THRESHOLD = 7;

    @Override
    public Boolean get(){
        return Skills.getBoostedLevels(Skill.HITPOINTS) < HEALTH_THRESHOLD;
    }
}
