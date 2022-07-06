package Deprecated.Functions.Actions;

import Deprecated.Functions.Action;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.wrappers.items.Item;

import java.util.List;

import static org.dreambot.api.methods.MethodProvider.log;

public class DepositItem implements Action {

    private List<String> item_names;

    public DepositItem(List<String> items_names) {
        this.item_names = items_names;
    }
    @Override
    public Boolean get() {
        for (String items : item_names) {
            Item item = Inventory.get(i -> i.getName().contains(items));
            if (item != null) {
                Bank.depositAll(item);
            }
            if (Inventory.contains(item)) {
                log("Did not successfully bank " + item);
                return false;
            }
        }
        log("Successfully banked");
        return true;
    }
}
