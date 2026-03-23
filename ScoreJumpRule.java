package anticheat;

import server.Action;

public class ScoreJumpRule implements CheatRule {

    public boolean check(Action action, PlayerRecord record) {
        return action.type.equals("SCORE") && action.value > 300;
    }

    public String getName() {
        return "SCORE_JUMP";
    }
}
