package anticheat;

import server.Action;

public class SpeedHackRule implements CheatRule {

    public boolean check(Action action, PlayerRecord record) {
        return action.type.equals("MOVE") && action.value > 100;
    }

    public String getName() {
        return "SPEED_HACK";
    }
}
