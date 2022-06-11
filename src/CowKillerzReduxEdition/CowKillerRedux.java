package CowKillerzReduxEdition;


import BehaviourTreeNodes.*;
import Functions.Actions.*;
import Functions.Conditions.CheckUnderAttack;
import Functions.Conditions.isHealthLow;
import Functions.Conditions.isInventoryFull;
import Functions.Conditions.isThereLootNear;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

@ScriptManifest(
    author = "You",
    name = "Cowkiller Redux", version = 1.0,
    description = "Killz cowz",
    category = Category.COMBAT
)

public class CowKillerRedux extends AbstractScript {


    private Behaviour root;

    @Override
    public int onLoop() {
        this.root.execute();
        return 100;
    }

    @Override
    public void onStart() {

        Behaviour attack_loot = Selector.builder()
            .child(
                Sequence.builder()
                    .child(Condition.builder().func(new isThereLootNear("Cowhide")).build())
                    .child(Inverter.builder()
                        .child(Condition.builder().func(new isInventoryFull()).build()).build()
                    )
                    .child(Action.builder().func(new PickupLoot("Cowhide")).build())
                    .build()
            )
            //.child(Condition.builder().func(new CheckUnderAttack()).build())
            .child(Action.builder().func(new AttackNearest("Cow")).build())
            .build();


        Behaviour inv_full = Selector.builder()
            .child(
                Inverter.builder().child(Condition.builder().func(new isInventoryFull()).build()).build()
            )
            .child(
                Sequence.builder()
                    .child(Action.builder().func(new GoToBank()).build()) // open bank
                    .child(Action.builder().func(new DepositAll()).build()) // dump inventory
                    .build()
            )
            .build();

        Behaviour health_check = Selector.builder()
            .child(Condition.builder().func(new isHealthLow()).build())
            .child(Action.builder().func(new EatFood()).build())
            .build();

        this.root = Sequence.builder()
            .child(health_check)
            .child(inv_full)
            .child(attack_loot)
            .build();

    }
}
