package anticheat;

import server.Action;

public class RapidFireRule implements CheatRule {

    public boolean check(Action action, PlayerRecord record) {
        return action.type.equals("SHOOT") && action.value > 80;
    }

    public String getName() {
        return "RAPID_FIRE";
    }
}
