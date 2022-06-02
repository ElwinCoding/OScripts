package Wodocutting;

import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.SkillTracker;
import org.dreambot.api.script.impl.TaskScript;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.Category;

import java.awt.*;

@ScriptManifest(author = "You", name = "TreeChopper", version = 1.0, description = "chop trees", category = Category.WOODCUTTING)


public class TreechopperMain extends TaskScript {


    public void onStart() {
        log("tree chopper is now starting.");
        SkillTracker.start(Skill.WOODCUTTING);
    }

    @Override
    public void onPaint(Graphics g) {
        g.setColor(Color.CYAN);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        String experience = "Woodcutting Experience Gained: " + SkillTracker.getGainedExperience(Skill.WOODCUTTING);
        g.drawString(experience,20,30);
    }


    public void onExit() {
        log("Tree chopper has finished chopping");
    }
}
