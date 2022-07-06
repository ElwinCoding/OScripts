package Deprecated.Scripts.Woodcutting;

import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.script.TaskNode;


public class BankTask extends TaskNode{

    @Override
    public boolean accept() {
        return Inventory.isFull();
    }

    @Override
    public int execute() {
        log("walking to bank");
        while (!Bank.openClosest()) {
            sleepUntil(() -> getLocalPlayer().isMoving(),5000);
        }
        Bank.depositAll("Logs");
        return 5000;
    }
}
