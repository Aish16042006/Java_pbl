package server;

import anticheat.*;

public class GameServer implements Runnable {

    private ActionQueue queue;
    private boolean running = true;
    private AntiCheatEngine engine = new AntiCheatEngine();

    public GameServer(ActionQueue queue) {
        this.queue = queue;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        System.out.println("Server Started");

        while (running) {
            Action action = queue.dequeue();

            if (action != null) {
                RiskResult result = engine.evaluate(action);

                System.out.println(
                        "Player " + result.playerId +
                        " | Status: " + result.status +
                        " | Rule: " + result.ruleTriggered
                );
            }
        }
    }
}
