package anticheat;

public class RiskResult {
    public int playerId;
    public String status;
    public String ruleTriggered;

    public RiskResult(int playerId, String status, String rule) {
        this.playerId = playerId;
        this.status = status;
        this.ruleTriggered = rule;
    }
}
