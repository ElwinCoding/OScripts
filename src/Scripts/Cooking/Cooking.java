package Scripts.Cooking;

import BehaviourTreeNodes.*;
import Functions.Actions.DepositAll;
import Functions.Actions.GoToBank;
import Functions.Actions.WalkToDestination;
import Functions.Actions.WithdrawlItem;
import Functions.Conditions.IsInArea;
import Functions.Conditions.isInInventory;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.script.AbstractScript;

public class Cooking extends AbstractScript {
    private Behaviour root;
    private static final String ITEM_TO_COOK = "Raw beef";
    private static final Area AREA = new Area(3271, 3183, 3275, 3179);

    @Override
    public void onStart() {
        Behaviour bank = Selector.builder()
            .child(Inverter.builder()
                    .child(Condition.builder().func(new isInInventory(ITEM_TO_COOK)).build()).build())
            .child(Action.builder().func(new GoToBank()).build())
            .child(Action.builder().func(new DepositAll()).build())
            .child(Action.builder().func(new WithdrawlItem(ITEM_TO_COOK, 28)).build())
            .build();

        Behaviour go_to_range = Selector.builder()
            .child(Inverter.builder()
                .child(Condition.builder().func(new IsInArea(AREA)).build()).build())
            .child(Condition.builder().func(new isInInventory(ITEM_TO_COOK)).build())
            .child(Action.builder().func(new WalkToDestination(AREA)).build())
            .build();
    }

    @Override
    public int onLoop() {
        this.root.execute();
        return 0;
    }
}
