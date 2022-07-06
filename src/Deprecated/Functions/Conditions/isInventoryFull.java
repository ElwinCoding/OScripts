package Deprecated.Functions.Conditions;

import Deprecated.Functions.Condition;
import org.dreambot.api.methods.container.impl.Inventory;
import static org.dreambot.api.methods.MethodProvider.log;

public class isInventoryFull implements Condition {

    @Override
    public Boolean get() {
        Boolean check = Inventory.isFull();
        /*
        if(check){
            log("Inventory Full.");
        }
        else{
            log("Inventory not full");
        }
         */
        return check;
    }
}
