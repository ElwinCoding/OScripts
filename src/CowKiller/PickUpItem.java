package CowKiller;

import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.item.GroundItems;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.wrappers.interactive.NPC;
import org.dreambot.api.wrappers.items.GroundItem;

public class PickUpItem extends TaskNode {
    @Override
    public boolean accept() {
        log(!Inventory.isFull() && !isPlayerInCombat());
        return !Inventory.isFull() && !isPlayerInCombat() && isItemNear();
    }

    @Override
    public int execute() {
        GroundItem item = GroundItems.closest("Cowhide");
        if (item != null){
            item.interact("Take");
        }
        return 1000;
    }

    private static boolean isPlayerInCombat(){
        return Players.localPlayer().isInCombat();
    }

    private static boolean isItemNear(){
        GroundItem item = GroundItems.closest("Cowhide");
        double distance_to_item = Players.localPlayer().distance(item.getTile());
        if(distance_to_item < 2){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int priority() {
        return 2;
    }
}
