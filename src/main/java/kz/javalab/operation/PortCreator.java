package kz.javalab.operation;

import kz.javalab.entity.Pier;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by HdgDink on 28.07.2017.
 */
public class PortCreator extends Thread {
    private final String FOR_BIG_SHIPS = "for big ships";
    private final String FOR_MEDIUM_SHIPS = "for medium ships";
    private final String FOR_BOARDS = "for boards";
    private final String WELCOME = "Welcome to the seaport LENIN'S PADDLES";
    private final int PIER_ID_ONE = 1;
    private final int PIER_ID_TWO = 2;

    private final int CAPACITY_OF_QUEUE = 2;
    private Pier pierForBigShipFirst = null;
    private Pier pierForBigShipSecond = null;
    private Pier pierForMediumShipFirst = null;
    private Pier pierForMediumShipSecond = null;
    private Pier pierForBoardFirst = null;
    private Pier pierForBoardSecond = null;
    private ShipCreator shipsCreator = null;
    private BlockingQueue<Pier> queueOfPiersForBigShips = null;
    private BlockingQueue<Pier> queueOfPiersForMedShips = null;
    private BlockingQueue<Pier> queueOfPiersForSmallShips = null;


    public void run() {
        queueOfPiersForBigShips = new ArrayBlockingQueue<Pier>(CAPACITY_OF_QUEUE);
        queueOfPiersForMedShips = new ArrayBlockingQueue<Pier>(CAPACITY_OF_QUEUE);
        queueOfPiersForSmallShips = new ArrayBlockingQueue<Pier>(CAPACITY_OF_QUEUE);

        pierForBigShipFirst = new Pier(PIER_ID_ONE, 17, FOR_BIG_SHIPS);
        pierForBigShipSecond = new Pier(PIER_ID_TWO, 26, FOR_BIG_SHIPS);
        pierForMediumShipFirst = new Pier(PIER_ID_ONE, 12, FOR_MEDIUM_SHIPS);
        pierForMediumShipSecond = new Pier(PIER_ID_TWO, 23, FOR_MEDIUM_SHIPS);
        pierForBoardFirst = new Pier(PIER_ID_ONE, 10, FOR_BOARDS);
        pierForBoardSecond = new Pier(PIER_ID_TWO, 12, FOR_BOARDS);

        try {
            queueOfPiersForBigShips.put(pierForBigShipFirst);
            queueOfPiersForBigShips.put(pierForBigShipSecond);
            queueOfPiersForMedShips.put(pierForMediumShipFirst);
            queueOfPiersForMedShips.put(pierForMediumShipSecond);
            queueOfPiersForSmallShips.put(pierForBoardFirst);
            queueOfPiersForSmallShips.put(pierForBoardSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(WELCOME);
        shipsCreator = new ShipCreator(queueOfPiersForBigShips, queueOfPiersForMedShips, queueOfPiersForSmallShips);
        shipsCreator.start();
    }
}





