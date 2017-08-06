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
    private final String SHIP = "ship ";
    private final String NEW_SHIP = "New Ship on horizont";
    private final String BIG = "Big";
    private final String MEDIUM = "Medium";
    private final String SMALL = "Small";
    private int maxForType;
    private int maxForName;
    private int maxForCap;
    private int minForCap;
    private int capacityRnd;
    private int nameRnd;
    private int typeRnd;
    private int quantityOfShips;
    private List<String> listRnd = null;
    private Ship ship = null;
    private BlockingQueue<Ship> queueOfShips = null;
    private BlockingQueue<Pier> queueOfPiersForBigShips = null;
    private BlockingQueue<Pier> queueOfPiersForSmallShips = null;
    private BlockingQueue<Pier> queueOfPiersForMedShips = null;


    @Override
    public void run() {
        maxForType = 3;
        maxForName = 100;
        maxForCap = 120;
        minForCap = 10;
        quantityOfShips = 10;
        listRnd = new ArrayList(3);
        listRnd.add(BIG);
        listRnd.add(MEDIUM);
        listRnd.add(SMALL);
        queueOfShips = new ArrayBlockingQueue<Ship>(quantityOfShips);
        for (int i = 0; i < quantityOfShips; i++) {
            nameRnd = (int) (Math.random() * maxForName);
            typeRnd = (int) (Math.random() * maxForType);
            capacityRnd = minForCap + (int) (Math.random() * ((maxForCap - minForCap) + 1));
            System.out.println(NEW_SHIP);
            ship = new Ship(SHIP + nameRnd, listRnd.get(typeRnd), capacityRnd);
            System.out.println(ship.toString());

            try {
                queueOfShips.put(ship);
                new Customs(queueOfShips, queueOfPiersForBigShips, queueOfPiersForMedShips, queueOfPiersForSmallShips
                        , quantityOfShips).start();
                Thread.sleep(1000);
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
