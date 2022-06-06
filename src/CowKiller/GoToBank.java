package CowKiller;

import javafx.concurrent.Task;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.container.impl.bank.BankLocation;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.methods.depositbox.DepositBox;

public class GoToBank extends TaskNode {
    @Override
    public boolean accept() {
        return Inventory.isFull();
    }

    @Override
    public int execute() {
        Bank.openClosest();
        Bank.depositAllItems();
        return 0;
    }
}
