package server;

import simulation.*;

public class Main {

    public static void main(String[] args) {

        ActionQueue queue = new ActionQueue();

        GameServer server = new GameServer(queue);
        new Thread(server).start();

        SimulationController controller = new SimulationController(queue);
        controller.start(10); // change to 50 for stress test

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {}

        controller.stop();
        server.stop();

        System.out.println("Simulation Ended");
    }
}
