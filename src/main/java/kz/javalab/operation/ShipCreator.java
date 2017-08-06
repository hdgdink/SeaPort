package kz.javalab.operation;

import kz.javalab.entity.Pier;
import kz.javalab.entity.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by HdgDink on 28.07.2017.
 */
public class ShipCreator extends Thread {
    private final String BIG = "Big";
    private final String MEDIUM = "Medium";
    private final String SMALL = "Small";
    private int maxForString;
    private int typeRnd;
    private List<String> listRnd = null;
    private int max;
    private int rnd;
    private Ship ship = null;
    private int quantityOfShips;
    private BlockingQueue<Ship> queueOfShips = null;
    private BlockingQueue<Pier> queueOfPiersForBigShips = null;
    private BlockingQueue<Pier> queueOfPiersForSmallShips = null;
    private BlockingQueue<Pier> queueOfPiersForMedShips = null;


    @Override
    public void run() {
        maxForString = 3;
        max = 100;
        quantityOfShips = 10;
        listRnd = new ArrayList(3);
        listRnd.add(BIG);
        listRnd.add(MEDIUM);
        listRnd.add(SMALL);
        queueOfShips = new ArrayBlockingQueue<Ship>(quantityOfShips);
        for (int i = 0; i < quantityOfShips; i++) {
            rnd = (int) (Math.random() * max);
            typeRnd = (int) (Math.random() * maxForString);
            System.out.println("New Ship on horizont");
            ship = new Ship("ship " + rnd, /*listRnd.get(typeRnd)*/"Big", 50);
            System.out.println(ship.toString());

            try {
                queueOfShips.put(ship);
                Thread.sleep(1000);
                new Customs(queueOfShips, queueOfPiersForBigShips, queueOfPiersForMedShips, queueOfPiersForSmallShips
                        , quantityOfShips).start();
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
