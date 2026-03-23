package server;

public class Action {
    public int playerId;
    public String type;
    public double value;
    public long timestamp;

    public Action(int playerId, String type, double value) {
        this.playerId = playerId;
        this.type = type;
        this.value = value;
        this.timestamp = System.currentTimeMillis();
    }
}
