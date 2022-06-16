package Scripts.Cooking;

import BehaviourTreeNodes.*;
import Functions.Actions.*;
import Functions.Conditions.IsInArea;
import Functions.Conditions.IsGameObjectNear;
import Functions.Conditions.isInInventory;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

@ScriptManifest(
    author = "You",
    name = "Cooking", version = 1.0,
    description = "Cooks food",
    category = Category.COOKING
)
public class Cooking extends AbstractScript {
    private Behaviour root;
    private static final String ITEM_TO_COOK = "Raw beef";
    private static final String COOKING_DEVICE = "Range";
    private static final Area AREA = new Area(3271, 3183, 3275, 3179);

    @Override
    public void onStart() {
        Behaviour bank = Selector.builder()
            .child(Condition.builder().func(new isInInventory(ITEM_TO_COOK)).build())
            .child(Sequence.builder()
                .child(Action.builder().func(new GoToBank()).build())
                .child(Action.builder().func(new DepositAll()).build())
                .child(Action.builder().func(new WithdrawlItem(ITEM_TO_COOK, 28)).build())
                .build())
            .build();

        Behaviour go_to_range = Selector.builder()
            .child(Condition.builder().func(new IsInArea(AREA)).build())
            .child(Inverter.builder()
                .child(Condition.builder().func(new isInInventory(ITEM_TO_COOK)).build()).build())
            .child(Action.builder().func(new WalkToDestination(AREA)).build())
            .build();

        Behaviour cook_on_range = Selector.builder()
            .child(Inverter.builder()
                .child(Condition.builder().func(new IsGameObjectNear(COOKING_DEVICE)).build()).build())
            .child(Inverter.builder()
                .child(Condition.builder().func(new isInInventory(ITEM_TO_COOK)).build()).build())
            .child(Action.builder().func(new CookFood(COOKING_DEVICE, ITEM_TO_COOK)).build())
            .build();

        this.root = Sequence.builder()
            .child(bank)
            .child(go_to_range)
            .child(cook_on_range)
            .build();
    }

    @Override
    public int onLoop() {
        this.root.execute();
        return 100;
    }
}
