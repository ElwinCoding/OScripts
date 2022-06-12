package Functions.Actions;

import Functions.Action;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.walking.impl.Walking;

import static org.dreambot.api.methods.MethodProvider.sleep;


public class WalkToDestination implements Action {
    private Area area;

    public WalkToDestination(Area area){
        this.area = area;
    }

    @Override
    public Boolean get() {
        Walking.walk(this.area.getCenter());
        sleep((int)(Math.random() * 400) + 900);
        return this.area.contains(Players.localPlayer().getTile());
    }
}
