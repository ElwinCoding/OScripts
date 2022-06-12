package CowKillerzReduxEdition;


import BehaviourTreeNodes.*;
import Functions.Actions.*;
import Functions.Conditions.*;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
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
        final Tile TILES[] = new Tile[]{
            new Tile(3241, 3299),
            new Tile(3264, 3299),
            new Tile(3266, 3297),
            new Tile(3266, 3255),
            new Tile(3253, 3255),
            new Tile(3253, 3278),
            new Tile(3245, 3278),
            new Tile(3244, 3281),
            new Tile(3242, 3283),
            new Tile(3242, 3293),
            new Tile(3241, 3293),
            new Tile(3241, 3298)
        };

        Area AREA = new Area(TILES);

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
            .child(Condition.builder().func(new CheckUnderAttack()).build())
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
            .child(Inverter.builder()
                .child(Condition.builder().func(new HasFood()).build())
                .build())
            .child(Action.builder().func(new EatFood()).build())
            .build();

        Behaviour return_to_area = Selector.builder()
            .child(Condition.builder().func(new isInventoryFull()).build())
            .child(Condition.builder().func(new IsInArea(AREA)).build())
            .child(Action.builder().func(new WalkToDestination(AREA)).build())
            .build();

        this.root = Sequence.builder()
            .child(health_check)
            .child(inv_full)
            .child(return_to_area)
            .child(attack_loot)
            .build();

    }
}
