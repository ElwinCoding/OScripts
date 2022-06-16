package Functions.Actions;

import Functions.Action;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.dialogues.Dialogues;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.wrappers.items.Item;
import static org.dreambot.api.methods.MethodProvider.log;

import java.awt.*;

public class CookFood implements Action{
    private final String cooking_device_name;
    private final String food_to_cook;

    public CookFood(String cooking_device, String food_to_cook){
        this.cooking_device_name = cooking_device;
        this.food_to_cook = food_to_cook;
    }

    @Override
    public Boolean get() {
        log("Cooking.");
        GameObject cooking_tool = GameObjects.closest(cooking_device_name);
        Item food = Inventory.get(food_to_cook);
        if(food.hasAction("Use")){
            food.useOn(cooking_tool);
        }
        else{
            return false;
        }

        while(!Dialogues.areOptionsAvailable()){
            Dialogues.chooseFirstOption();
        }

        MethodProvider.sleepUntil(() -> !Inventory.contains(food_to_cook),
            Calculations.random(50000, 60000));

        return true;
    }
}