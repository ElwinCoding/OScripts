package Functions.Actions;

import Functions.Action;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.bank.Bank;


public class GoToBank implements Action {
    @Override
    public Boolean get() {
        MethodProvider.log("Going to bank");
        MethodProvider.sleep(1000,3000);
        return Bank.openClosest();
    }
}
