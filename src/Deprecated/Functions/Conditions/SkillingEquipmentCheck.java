package Deprecated.Functions.Conditions;

import Deprecated.Functions.Condition;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.script.ScriptManager;

import static org.dreambot.api.methods.MethodProvider.log;


public class SkillingEquipmentCheck implements Condition {

    String equipment;

    public SkillingEquipmentCheck(String equipment) {
        this.equipment = equipment;
    }

    @Override
    public Boolean get() {
        //log("checking for correct equipment");
        boolean check = Inventory.contains(item -> item.getName().contains(equipment));
        if (!check) {
            log("please get the correct equipment");
            ScriptManager.getScriptManager().stop();
        }
        return true;
    }
}
