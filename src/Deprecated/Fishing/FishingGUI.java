package Deprecated.Fishing;

import org.dreambot.api.Client;
import org.dreambot.api.methods.map.Area;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class FishingGUI {

    private HashMap<String, String> fishing_action;
    private HashMap<String, Area> fishing_spots;
    private HashMap<String, String> fishing_equipment;
    private HashMap<String, String> fishing_bait;

    public String action;
    public Area area;
    public String equipment;
    public String bait;
    public ArrayList<String> deposit_list;

    public boolean visible = true;

    public FishingGUI() {
        fishing_action = new HashMap<String, String>();
        fishing_action.put("Shrimp/Anchovy", "Net");
        fishing_action.put("Sardine/Herring", "Bait");
        fishing_action.put("Trout/Salmon", "Lure");
        fishing_action.put("Tuna/Swordfish", "Harpoon");
        fishing_action.put("Lobster", "Cage");

        fishing_spots = new HashMap<String, Area>();
        fishing_spots.put("Shrimp/Anchovy", new Area(3246, 3141, 3237, 3155)); // lumbridge swamp
        fishing_spots.put("Sardine/Herring", new Area(3246, 3141, 3237, 3155)); // lumbridge swamp
        fishing_spots.put("Trout/Salmon", new Area(3109, 3436, 3103, 3430)); // East of Barb Village

        fishing_equipment = new HashMap<String, String>();
        fishing_equipment.put("Shrimp/Anchovy", "Small fishing net");
        fishing_equipment.put("Sardine/Herring", "Deprecated.Fishing Rod");
        fishing_equipment.put("Trout/Salmon", "Fly fishing rod");

        fishing_bait = new HashMap<String, String>();
        fishing_bait.put("Sardine/Herring", "Deprecated.Fishing bait");
        fishing_bait.put("Trout/Salmon", "Feather");

        deposit_list = new ArrayList<String>() {{
            add("shrimp");
            add("anchovy");
            add("sardine");
            add("herring");
            add("trout");
            add("salmon");
            add("lobster");
            add("tuna");
            add("swordfish");
        }};
    }

    public void createGUI() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("Catch some fish");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // so only GUI closes when X is pressed
        frame.setLocationRelativeTo(Client.getInstance().getCanvas()); // centers the GUI to client
        frame.getContentPane().setLayout(new BorderLayout()); // sets the layout of the GUI
        frame.setPreferredSize(new Dimension(500, 300)); // default size is according to components
        frame.pack(); // sizes GUI so all components are visible

        JPanel setting_panel = new JPanel();
        setting_panel.setLayout(new GridLayout(0, 2));

        JLabel label = new JLabel("Which Fish", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        setting_panel.add(label);

        // adds a dropdown box
        JComboBox<String> fish_type = new JComboBox<>(new String[] {"Shrimp/Anchovy", "Sardine/Herring", "Trout/Salmon", "Tuna/Swordfish","Lobster" });
        fish_type.setFont(new Font("Arial", Font.PLAIN, 20));
        setting_panel.add(fish_type);

        JButton button = new JButton("Start Script");
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fish = fish_type.getSelectedItem().toString();
                action = fishing_action.get(fish);
                area = fishing_spots.get(fish);
                equipment = fishing_equipment.get(fish);
                bait = fishing_bait.get(fish); // may return null
                visible = false;
                frame.dispose();
            }
        });
        setting_panel.add(button);

        frame.getContentPane().add(setting_panel, BorderLayout.CENTER);
    }
}

