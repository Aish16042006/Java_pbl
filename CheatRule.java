package anticheat;

import server.Action;

public interface CheatRule {
    boolean check(Action action, PlayerRecord record);
    String getName();
}
