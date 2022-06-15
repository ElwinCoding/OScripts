package Functions.Actions;

import Functions.Action;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;

public class WithdrawlItemCap implements Action {
    final private int number_of_items;
    final private String item_name;

    public WithdrawlItemCap(String item_name, int number_of_items){
        this.number_of_items = number_of_items;
        this.item_name = item_name;
    }
    @Override
    public Boolean get() {
        int item_count = Inventory.count(item -> item.getName().contains(item_name));
        int diff = number_of_items - item_count;
        if (diff < 1){
            return true;
        }
        return Bank.withdraw(item_name, diff);
    }
}
