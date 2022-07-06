package Deprecated.Functions.Actions;

import Deprecated.Functions.Action;
import org.dreambot.api.methods.container.impl.bank.Bank;

import static org.dreambot.api.methods.MethodProvider.log;

public class WithdrawlItem implements Action {

    final private int number_of_items;
    final private String item_name;

    public WithdrawlItem(String item_name, int number_of_items){
        this.number_of_items = number_of_items;
        this.item_name = item_name;
    }

    @Override
    public Boolean get() {
        return Bank.withdraw(item_name, number_of_items);
    }
}
