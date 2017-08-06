package kz.javalab.operation;

import kz.javalab.entity.Pier;
import kz.javalab.entity.Ship;

import java.util.concurrent.BlockingQueue;

/**
 * Created by HdgDink on 28.07.2017.
 */
public class Customs extends Thread {
    private final String EMPTY = " ";
    private final String PIER = "Pier ";
    private final String IS_FREE = " is free now!";
    private final String UNLOADED = " unloaded";
    private final String CAPACITY_IS = " capacity is ";
    private final String PROCESS_OF_UNLOAD = "Process of unloading ";
    private final String DOTS = ":";
    private final String UNLOADING_START = "Unloading starting.. ";
    private final String ON_PIER = " on pier ";
    private final String NUMBER = " #";
    private final String BIG = "Big";
    private final String MEDIUM = "Medium";
    private final String SMALL = "Small";
    private Ship currentShip = null;
    private Pier currentPier = null;
    private int quantityOfShips;
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
            System.out.println(UNLOADING_START + currentShip.getShipName() + ON_PIER
                    + currentPier.getPierType() + NUMBER + currentPier.getPierId());
            for (int j = 0; j < currentShip.getShipCapacity(); ) {
                System.out.println(PROCESS_OF_UNLOAD + currentShip.getShipName() + DOTS +
                        CAPACITY_IS + currentShip.getShipCapacity());
                currentShip.setShipCapacity(currentShip.getShipCapacity() - currentPier.getSpeedOfUnloading());
                Thread.sleep(1000);
            }
            System.out.println(currentShip.getShipType() + EMPTY + currentShip.getShipName() + UNLOADED);
            System.out.println(PIER + currentPier.getPierType() + NUMBER + currentPier.getPierId() + IS_FREE);
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











