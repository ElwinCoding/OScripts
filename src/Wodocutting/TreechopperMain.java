package Wodocutting;

import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.SkillTracker;
import org.dreambot.api.script.impl.TaskScript;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.Category;

import javax.swing.*;
import java.awt.*;

@ScriptManifest(author = "You", name = "TreeChopper", version = 1.0, description = "chop trees", category = Category.WOODCUTTING)


public class TreechopperMain extends TaskScript {

    private boolean bank;
    private String tree_type;


    public void onStart() {
        SwingUtilities.invokeLater(() -> {
            createGUI();
        });
        log("tree chopper is now starting.");
        SkillTracker.start(Skill.WOODCUTTING); // set to start on login
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

    private void createGUI() {

        JFrame frame = new JFrame();
        frame.setTitle("Wood Chopper");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }
}
