package operation;

import kz.javalab.entity.Pier;
import kz.javalab.entity.Ship;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by HdgDink on 28.07.2017.
 */
public class ShipCreator extends Thread {
    private int max;
    private int rnd;
    Ship ship;
    private int capacityOfQueue;
    BlockingQueue<Ship> queueOfShips = new ArrayBlockingQueue<>(capacityOfQueue);
    private BlockingQueue<Pier> queueOfPiersForBigShips;
    private BlockingQueue<Pier> queueOfPiersForSmallShips;
    private BlockingQueue<Pier> queueOfPiersForMedShips;


    @Override
    public void run() {
        max = 100;
        capacityOfQueue = 10;

        for (int i = 0; i < capacityOfQueue; i++) {
            rnd = (int) (Math.random() * max);
            System.out.println("New Ship on horizont");
            ship = new Ship("ship " + rnd, "Big", 50);
            System.out.println(ship.toString());

            try {
                queueOfShips.put(ship);
                Thread.sleep(1000);
                new Customs(queueOfShips, queueOfPiersForBigShips, queueOfPiersForMedShips, queueOfPiersForSmallShips).start();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public ShipCreator(BlockingQueue<Pier> queueOfPiersForBigShips,
                       BlockingQueue<Pier> queueOfPiersForMedShips, BlockingQueue<Pier> queueOfPiersForSmallShips) {

        this.queueOfPiersForBigShips = queueOfPiersForBigShips;
        this.queueOfPiersForMedShips = queueOfPiersForMedShips;
        this.queueOfPiersForSmallShips = queueOfPiersForSmallShips;
    }
}
