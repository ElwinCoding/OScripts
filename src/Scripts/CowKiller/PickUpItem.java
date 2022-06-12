package Scripts.CowKiller;

import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.item.GroundItems;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.wrappers.items.GroundItem;

public class PickUpItem extends TaskNode {
    
    private StateMachine sm;

    public PickUpItem(StateMachine sm){
        this.sm = sm;
    }
    
    @Override
    public boolean accept() {
        return sm.getState() == StateMachine.State.COLLECTING;
    }

    @Override
    public int execute() {
        sleep(3000);
        log("picking up");
        GroundItem item = GroundItems.closest("Cowhide");
        if (item != null){
            item.interact("Take");
        }
        sleep(5000);
        sm.setState(StateMachine.State.IDLE);
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
