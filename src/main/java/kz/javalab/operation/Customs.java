package kz.javalab.operation;

import kz.javalab.entity.Pier;
import kz.javalab.entity.Ship;
import java.util.concurrent.BlockingQueue;

/**
 * Created by HdgDink on 28.07.2017.
 */
public class Customs extends Thread {
    private final String BIG = "Big";
    private final String MEDIUM = "Medium";
    private final String SMALL = "Small";
    private Ship currentShip = null;
    private Pier currentPier = null;
    private int quantityOfShips;
    private String shipType;
    private BlockingQueue<Pier> currentQueueOfPiers = null;
    private BlockingQueue<Ship> queueOfShips = null;
    private BlockingQueue<Pier> queueOfPiersForBigShips = null;
    private BlockingQueue<Pier> queueOfPiersForSmallShips = null;
    private BlockingQueue<Pier> queueOfPiersForMedShips = null;


    @Override
    public void run() {

        for (int i = 0; i <= quantityOfShips; i++) {
            if (!(queueOfShips.isEmpty())) {
                currentShip = queueOfShips.poll();
                if (currentShip != null) {
                    if (currentShip.getShipType() == BIG) {
                        currentQueueOfPiers = queueOfPiersForBigShips;

                        try {
                            unloadShip();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if (currentShip.getShipType() == MEDIUM) {
                        currentQueueOfPiers = queueOfPiersForMedShips;
                        try {
                            unloadShip();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if (currentShip.getShipType() == SMALL) {
                        currentQueueOfPiers = queueOfPiersForSmallShips;
                        try {
                            unloadShip();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private void unloadShip() throws InterruptedException {
        if (!(currentQueueOfPiers.isEmpty())) {
            currentPier = currentQueueOfPiers.poll();
            System.out.println("Unloading starting.. " + currentShip.getShipName() + " on pier "
                    + currentPier.getPierType() + " #" + currentPier.getPierId());
            for (int j = 0; j < currentShip.getShipCapacity(); ) {
                System.out.println("Process of unloading " + currentShip.getShipName() +
                        " capacity is " + currentShip.getShipCapacity());
                currentShip.setShipCapacity(currentShip.getShipCapacity() - currentPier.getSpeedOfUnloading());
                Thread.sleep(1000);
            }
            System.out.println(currentShip.getShipType() + " " + currentShip.getShipName() + " unloaded");
            System.out.println("Pier " + currentPier.getPierType() + " #" + currentPier.getPierId() + " is free now!");
            currentQueueOfPiers.put(currentPier);
        } else queueOfShips.put(currentShip);
    }


    public Customs(BlockingQueue<Ship> queueOfShips, BlockingQueue<Pier> queueOfPiersForBigShips,
                   BlockingQueue<Pier> queueOfPiersForMedShips, BlockingQueue<Pier> queueOfPiersForSmallShips,
                   int quantityOfShips) {
        this.queueOfShips = queueOfShips;
        this.queueOfPiersForBigShips = queueOfPiersForBigShips;
        this.queueOfPiersForMedShips = queueOfPiersForMedShips;
        this.queueOfPiersForSmallShips = queueOfPiersForSmallShips;
        this.quantityOfShips = quantityOfShips;
    }
}











