package anticheat;

public enum SeverityLevel {
    LOW(1),
    MEDIUM(5),
    HIGH(10);

    public int weight;

    SeverityLevel(int weight) {
        this.weight = weight;
    }
}
