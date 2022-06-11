package Functions.Actions;

import Functions.Action;
import org.dreambot.api.methods.container.impl.bank.Bank;

public class DepositAll implements Action{

    @Override
    public Boolean get() {
        return Bank.depositAllItems();
    }
}
