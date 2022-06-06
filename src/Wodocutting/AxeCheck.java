package Wodocutting;

import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.equipment.Equipment;

public class AxeCheck {
    boolean Axe() {
        return (Equipment.contains(item -> item.getName().contains("axe"))) || (Inventory.contains(item -> item.getName().contains("axe")));
    }

    boolean getAxe() {
        return false;
    }
}
