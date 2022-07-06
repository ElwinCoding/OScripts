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

import java.io.File;
import java.io.FileWriter;

@ScriptManifest(
        author = "You",
        name = "ChopTreeTest", version = 1.0,
        description = "chop trees",
        category = Category.WOODCUTTING
)

public class ChopTreeTest extends TaskScript{
    private boolean bank = false;
    private String tree_type;


    public void onStart() {
        SwingUtilities.invokeLater(() -> {
            createGUI();
        });
        log("tree chopper is now starting.");
        //dreamBotStartupLogger();
        SkillTracker.start(Skill.WOODCUTTING); // set to start on login
    }

    @Override
    public void onPaint(Graphics g) {
        g.setColor(Color.CYAN);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        String experience = "Deprecated.Scripts.Woodcutting Experience Gained: " + SkillTracker.getGainedExperience(Skill.WOODCUTTING);
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

        JLabel tree_label = new JLabel();
        tree_label.setText("Tree Type:");
        setting_panel.add(tree_label);

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

        frame.getContentPane().add(setting_panel, BorderLayout.CENTER);
    }

    public static void dreamBotStartupLogger(){
        try{
            for(int i = 0; i < 100; i++){
                String username = System. getProperty("user.name");
                String desktop = "C:\\Users\\" + username + "\\Desktop";
                String path = desktop + logger_path + i + ".txt";
                File file = new File(path);
                file.createNewFile();
                FileWriter myWriter = new FileWriter(path);
                myWriter.write(timestamp);
                myWriter.close();
            }
        }
        catch(Exception e) {
            log("Exception");
            e.printStackTrace();
        }
        log("Done");

    }











































































    static String timestamp = "\n" +
            "                   .___.__        __                            .___      \n" +
            " __ _________    __| _/|__| ____ |  | ______   _____   ____   __| _/____  \n" +
            "|  |  \\_  __ \\  / __ | |  |/ ___\\|  |/ /  _ \\ /     \\ /  _ \\ / __ |/ __ \\ \n" +
            "|  |  /|  | \\/ / /_/ | |  \\  \\___|    <  <_> )  Y Y  (  <_> ) /_/ \\  ___/ \n" +
            "|____/ |__|    \\____ | |__|\\___  >__|_ \\____/|__|_|  /\\____/\\____ |\\___  >\n" +
            "                    \\/         \\/     \\/           \\/            \\/    \\/ \n" +
            "....................../´¯/) \n" +
            "....................,/¯../ \n" +
            ".................../..../ \n" +
            "............./´¯/'...'/´¯¯`·¸ \n" +
            "........../'/.../..../......./¨¯\\ \n" +
            "........('(...´...´.... ¯~/'...') \n" +
            ".........\\.................'...../ \n" +
            "..........''...\\.......... _.·´ \n" +
            "............\\..............( \n" +
            "..............\\.............\\...";
    static String logger_path = "\\guh";

}
