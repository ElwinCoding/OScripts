package Scripts.Fishing;

import BehaviourTreeNodes.Action;
import Functions.Actions.DepositItem;
import Functions.Actions.GoToBank;
import Functions.Actions.WalkToDestination;
import Functions.Actions.CatchFish;
import Functions.Conditions.BaitCheck;
import Functions.Conditions.*;
import BehaviourTreeNodes.*;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

import javax.swing.*;


@ScriptManifest(
        author = "Ocean Man",
        name = "I smell the sea", version = 1.0,
        description = "Catch some fish",
        category = Category.FISHING

)

public class CatchSomeFish extends AbstractScript {

    private Behaviour root;

    @Override
    public int onLoop() {
        this.root.execute();
        return 1000;
    }

    @Override
    public void onStart() {
        log("Ready to get sum fish?");
        FishingGUI gui = new FishingGUI();
        SwingUtilities.invokeLater(() -> {
            gui.createGUI();
        });
        sleepUntil(() -> !gui.visible, 10000);

        log("gui has closed");
        log("Selected: "+ gui.action);

        Behaviour inventory_check = Selector.builder()
                .child(Inverter.builder()
                        .child(Condition.builder().func(new isInventoryFull()).build()).build())
                .child(
                        Sequence.builder()
                                .child(Action.builder().func(new GoToBank()).build())
                                .child(Action.builder().func(new DepositItem(gui.deposit_list)).build())
                                .build()
                )
                .build();

        Behaviour location = Selector.builder()
                .child(Condition.builder().func(new IsInArea(gui.area)).build())
                .child(Action.builder().func(new WalkToDestination(gui.area)).build())
                .build();

        Behaviour equipment = Sequence.builder()
                .child(Condition.builder().func(new SkillingEquipmentCheck(gui.equipment)).build())
                .child(Condition.builder().func(new BaitCheck(gui.bait)).build())
                .build();

        Behaviour fishing = Sequence.builder()
                .child(Inverter.builder()
                        .child(Condition.builder().func(new isAnimating()).build()).build())
                .child(Action.builder().func(new CatchFish(gui.action)).build())
                .build();

        this.root = Sequence.builder()
                .child(inventory_check)
                .child(equipment)
                .child(location)
                .child(fishing)
                .build();

        log("finished building");
    }


}

