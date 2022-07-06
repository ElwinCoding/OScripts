package Deprecated.Scripts.Woodcutting;

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

    private boolean drop = false;
    public static String tree = "Tree";
    private boolean running = false;


    public void onStart() {
        SwingUtilities.invokeLater(() -> {
            createGUI();
        });
        while (!running) {
            sleep(5000);
        }
        SkillTracker.start(Skill.WOODCUTTING); // set to start on login
        log("tree chopper is now starting.");

        AxeCheck check = new AxeCheck();
        log("checking axe");
        if (!check.Axe()) {
            log("axe not found, checking bank for axe");
            if (!check.getAxe()) {
                log("unable to locate axe, please restart script once axe is acquired");
                stop();
            }
        }
        else {
            log("axe is found");
        }

        log("Tree Chopper now starting");
        addNodes(new ChopTask());
        if (drop) {
            addNodes(new DropTask());
        }
        else {
            addNodes(new BankTask());
        }
    }

    // overlay for xp gained
    @Override
    public void onPaint(Graphics g) {
        g.setColor(Color.CYAN);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        String experience = "Deprecated.Scripts.Woodcutting Experience Gained: " + SkillTracker.getGainedExperience(Skill.WOODCUTTING);
        g.drawString(experience,20,30);
    }


    public void onExit() {
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
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        setting_panel.add(label);

        // adds a dropdown box
        JComboBox<String> tree_type = new JComboBox<>(new String[] {"Tree", "Oak", "Willow" });
        tree_type.setFont(new Font("Arial", Font.PLAIN, 20));
        setting_panel.add(tree_type);

        // this adds tick boxes
        JCheckBox drop_check = new JCheckBox();
        drop_check.setText("Drop Logs");
        setting_panel.add(drop_check);

        JButton button = new JButton();
        button.setText("Start Script");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drop = drop_check.isSelected();
                tree = tree_type.getSelectedItem().toString();
                if (tree == null) {
                    tree = "Tree";
                }
                running = true;
                frame.dispose();
            }
        });
        setting_panel.add(button);

        frame.getContentPane().add(setting_panel, BorderLayout.CENTER);
    }
}
