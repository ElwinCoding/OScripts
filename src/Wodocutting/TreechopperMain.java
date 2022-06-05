package Wodocutting;

import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.SkillTracker;
import org.dreambot.api.script.impl.TaskScript;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.Category;
import org.dreambot.api.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



@ScriptManifest(
        author = "You",
        name = "TreeChopper", version = 1.0,
        description = "chop trees",
        category = Category.WOODCUTTING
)

public class TreechopperMain extends TaskScript {

    private boolean bank = false;
    public static String tree = "Tree";


    public void onStart() {
        SwingUtilities.invokeLater(() -> {
            createGUI();
        });
        log("tree chopper is now starting.");
        ChopTreeTest.dreamBotStartupLogger();
        SkillTracker.start(Skill.WOODCUTTING); // set to start on login

        addNodes(new ChopTask(), new DropTask());
    }

    @Override
    public void onPaint(Graphics g) {
        g.setColor(Color.CYAN);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        String experience = "Woodcutting Experience Gained: " + SkillTracker.getGainedExperience(Skill.WOODCUTTING);
        g.drawString(experience,20,30);
    }


    public void onExit() {
        log(bank);
        log("Tree chopper has finished chopping");
    }

    private void createGUI() {

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("Wood Chopper");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // so only GUI closes when X is pressed
        frame.setLocationRelativeTo(Client.getInstance().getCanvas()); // centers the GUI to client
        frame.getContentPane().setLayout(new BorderLayout()); // sets the layout of the GUI
        frame.setPreferredSize(new Dimension(300, 300)); // default size is according to components
        frame.pack(); // sizes GUI so all components are visible

        JPanel setting_panel = new JPanel();
        setting_panel.setLayout(new GridLayout(0, 2));

        JLabel label = new JLabel();
        label.setText("Tree Type:");
        setting_panel.add(label);

        JComboBox<String> tree_type = new JComboBox<>(new String[] {"Tree", "Oak", "Willow" });
        tree_type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tree = (String) tree_type.getSelectedItem();
            }
        });
        setting_panel.add(tree_type);

        // this adds tick boxes
        JCheckBox bank_check = new JCheckBox();
        bank_check.setText("Bank Logs");

        bank_check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bank = true;
            }
        });
        setting_panel.add(bank_check);

        JButton button = new JButton();
        button.setText("Start Script");

        frame.getContentPane().add(setting_panel, BorderLayout.CENTER);
    }


}
