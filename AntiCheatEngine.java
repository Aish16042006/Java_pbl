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

        // Ensure player record exists
        records.putIfAbsent(action.playerId, new PlayerRecord());
        PlayerRecord record = records.get(action.playerId);

        // Check all rules
        for (CheatRule rule : rules) {

            if (rule.check(action, record)) {

                // Increase violation count
                record.violations++;

                // Create violation object
                RuleViolation violation = new RuleViolation(
                        action.playerId,
                        rule.getName(),
                        SeverityLevel.HIGH,
                        action.timestamp,
                        action.value
                );

                // Log violation to file
                ViolationLogger.log(violation);

                // Decide status
                if (record.violations >= 3) {
                    return new RiskResult(action.playerId, "BLOCKED", rule.getName());
                } else {
                    return new RiskResult(action.playerId, "SUSPICIOUS", rule.getName());
                }
            }
        }

        // If no rule triggered
        return new RiskResult(action.playerId, "SAFE", "NONE");
    }
}
