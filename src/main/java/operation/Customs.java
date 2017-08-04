package operation;

import kz.javalab.entity.Pier;
import kz.javalab.entity.Ship;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * Created by HdgDink on 28.07.2017.
 */
public class Customs extends Thread {

    Semaphore semaphore = new Semaphore(1);
    Ship currentShip;
    Pier currentPier;
    private BlockingQueue<Ship> queueOfShips;
    private BlockingQueue<Pier> queueOfPiersForBigShips;
    private BlockingQueue<Pier> queueOfPiersForSmallShips;
    private BlockingQueue<Pier> queueOfPiersForMedShips;

    @Override
    public void run() {
synchronized (this){
            currentShip = queueOfShips.poll();
            currentPier = queueOfPiersForBigShips.peek();
            System.out.println("Queue of ships = " + queueOfShips.size());
            if (currentShip.getShipType() == "Big") {
                if (currentPier.isEmpty() == true)
                    currentPier.setEmpty(false);
                System.out.println("Unloading ...." + currentShip.getShipName() + " PierID" + currentPier.getPierId());
                try {
                    Thread.sleep(2000);

                    System.out.println("Unloaded " + currentShip.getShipName() + " on pierID " + currentPier.getPierId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            }
        }


    public Customs(BlockingQueue<Ship> queueOfShips, BlockingQueue<Pier> queueOfPiersForBigShips,
                   BlockingQueue<Pier> queueOfPiersForSmallShips, BlockingQueue<Pier> queueOfPiersForMedShips) {
        this.queueOfShips = queueOfShips;
        this.queueOfPiersForBigShips = queueOfPiersForBigShips;
        this.queueOfPiersForMedShips = queueOfPiersForMedShips;
        this.queueOfPiersForSmallShips = queueOfPiersForSmallShips;
    }
}











