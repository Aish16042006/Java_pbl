package anticheat;

import server.Action;
import java.util.*;

public class AntiCheatEngine {

    private Map<Integer, PlayerRecord> records = new HashMap<>();
    private List<CheatRule> rules = new ArrayList<>();

    public AntiCheatEngine() {
        rules.add(new SpeedHackRule());
        rules.add(new ScoreJumpRule());
        rules.add(new RapidFireRule());
    }

    public RiskResult evaluate(Action action) {

        records.putIfAbsent(action.playerId, new PlayerRecord());
        PlayerRecord record = records.get(action.playerId);

        for (CheatRule rule : rules) {
            if (rule.check(action, record)) {
                record.violations++;

                if (record.violations >= 3)
                    return new RiskResult(action.playerId, "BLOCKED", rule.getName());
                else
                    return new RiskResult(action.playerId, "SUSPICIOUS", rule.getName());
            }
        }

        return new RiskResult(action.playerId, "SAFE", "NONE");
    }
}
