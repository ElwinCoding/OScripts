package CowKiller;

import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.hotkeys.NPCAttackOption;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.wrappers.interactive.NPC;
import org.dreambot.api.methods.interactive.Players;


public class AttackCow extends TaskNode {

    @Override
    public boolean accept() {
        return !Inventory.isFull() && !Players.localPlayer().isInCombat();
    }

    @Override
    public int execute() {
        log("Executing AttackCow.");
        NPC cow = NPCs.closest("Cow calf");
        if(cow.canAttack() && !cow.isInCombat()){
            cow.interact("Attack");
            log("Attacking Cow.");
        }

        return 1000;
    }
}
