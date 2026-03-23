package simulation;

import server.*;
import java.util.Random;

public class Player implements Runnable {

    private int id;
    private ActionQueue queue;
    private boolean cheater;
    private Random rand = new Random();
    private volatile boolean running = true;

    public Player(int id, ActionQueue queue, boolean cheater) {
        this.id = id;
        this.queue = queue;
        this.cheater = cheater;
    }

    public void stop() {
        running = false;
    }

    public void run() {
        while (running) {
            try {
                Thread.sleep(500);

                if (rand.nextBoolean())
                    queue.enqueue(new Action(id, "MOVE",
                            cheater ? 150 : rand.nextInt(50)));

                if (rand.nextBoolean())
                    queue.enqueue(new Action(id, "SHOOT",
                            cheater ? 100 : rand.nextInt(30)));

                if (rand.nextBoolean())
                    queue.enqueue(new Action(id, "SCORE",
                            cheater ? 600 : rand.nextInt(100)));

            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
