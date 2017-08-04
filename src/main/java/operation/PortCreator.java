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
    SeaPort seaPort = null;
    Pier pierForBigShipFirst = null;
    Pier pierForBigShipSecond = null;
    Pier pierForMediumShipFirst = null;
    Pier pierForMediumShipSecond = null;
    Pier pierForBoardFirst = null;
    Pier pierForBoardSecond = null;


    BlockingQueue<Pier> queueOfPiersForBigShips = new ArrayBlockingQueue<Pier>(2);
    BlockingQueue<Pier> queueOfPiersForMedShips = new ArrayBlockingQueue<Pier>(2);
    BlockingQueue<Pier> queueOfPiersForSmallShips = new ArrayBlockingQueue<Pier>(2);
    ShipCreator creator;

    public void run() {
        seaPort = new SeaPort();
        seaPort.setPortName(NAME_OF_PORT);
        pierForBigShipFirst = new Pier(1, true, 30, "For Big");
        pierForBigShipSecond = new Pier(2, true, 20, "For Big");
        pierForMediumShipFirst = new Pier(1, true, 30, "For Medium");
        pierForMediumShipSecond = new Pier(2, true, 30, "For Medium");
        pierForBoardFirst = new Pier(1, true, 30, "For Boards");
        pierForBoardSecond = new Pier(2, true, 30, "For Boards");

        queueOfPiersForBigShips.add(pierForBigShipFirst);
        queueOfPiersForBigShips.add(pierForBigShipSecond);
        try {

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





