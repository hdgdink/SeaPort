package operation;

import kz.javalab.entity.Pier;
import kz.javalab.entity.SeaPort;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by HdgDink on 28.07.2017.
 */
public class PortCreator extends Thread {
    private final String NAME_OF_PORT = "LENIN'S PADDLES";
    private final int CAPACITY_OF_QUEUE = 2;
    private SeaPort seaPort = null;
    private Pier pierForBigShipFirst = null;
    private Pier pierForBigShipSecond = null;
    private Pier pierForMediumShipFirst = null;
    private Pier pierForMediumShipSecond = null;
    private Pier pierForBoardFirst = null;
    private Pier pierForBoardSecond = null;
    private ShipCreator creator = null;
    private BlockingQueue<Pier> queueOfPiersForBigShips = new ArrayBlockingQueue<Pier>(CAPACITY_OF_QUEUE);
    private BlockingQueue<Pier> queueOfPiersForMedShips = new ArrayBlockingQueue<Pier>(CAPACITY_OF_QUEUE);
    private BlockingQueue<Pier> queueOfPiersForSmallShips = new ArrayBlockingQueue<Pier>(CAPACITY_OF_QUEUE);


    public void run() {
        seaPort = new SeaPort();
        seaPort.setPortName(NAME_OF_PORT);
        pierForBigShipFirst = new Pier(1, true, 30, "For Big");
        pierForBigShipSecond = new Pier(2, true, 20, "For Big");
        pierForMediumShipFirst = new Pier(1, true, 30, "For Medium");
        pierForMediumShipSecond = new Pier(2, true, 30, "For Medium");
        pierForBoardFirst = new Pier(1, true, 30, "For Boards");
        pierForBoardSecond = new Pier(2, true, 30, "For Boards");

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

        System.out.println(seaPort.toString());
        creator = new ShipCreator(queueOfPiersForBigShips, queueOfPiersForMedShips, queueOfPiersForSmallShips);
        creator.start();
    }
}





