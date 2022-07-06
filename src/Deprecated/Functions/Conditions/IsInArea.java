package Deprecated.Functions.Conditions;

import Deprecated.Functions.Condition;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;

public class IsInArea implements Condition {
    private Area area;

    public IsInArea(Area area){
        this.area = area;
    }

    @Override
    public Boolean get() {
        return this.area.contains(Players.localPlayer().getTile());
    }
}
