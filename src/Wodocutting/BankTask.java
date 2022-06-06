package Wodocutting;

import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.script.TaskNode;


public class BankTask extends TaskNode{

    @Override
    public boolean accept() {
        return !Inventory.isFull();
    }

    @Override
    public int execute() {

        return 5000;
    }
}
