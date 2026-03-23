package simulation;

import server.*;
import java.util.*;

public class SimulationController {

    private List<Player> players = new ArrayList<>();
    private List<Thread> threads = new ArrayList<>();
    private ActionQueue queue;

    public SimulationController(ActionQueue queue) {
        this.queue = queue;
    }

    public void start(int n) {
        for (int i = 1; i <= n; i++) {

            boolean cheater = (i % 4 == 0);

            Player p = new Player(i, queue, cheater);
            Thread t = new Thread(p);

            players.add(p);
            threads.add(t);
            t.start();
        }
    }

    public void stop() {
        for (Player p : players) {
            p.stop();
        }
    }
}
