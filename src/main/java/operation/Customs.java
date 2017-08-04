package operation;

import kz.javalab.entity.Pier;
import kz.javalab.entity.Ship;

import java.util.concurrent.BlockingQueue;

/**
 * Created by HdgDink on 28.07.2017.
 */
public class Customs extends Thread {

    private Ship currentShip;
    private Pier currentPier;
    private int quantityOfShips;
    private BlockingQueue<Ship> queueOfShips;
    private BlockingQueue<Pier> queueOfPiersForBigShips;
    private BlockingQueue<Pier> queueOfPiersForSmallShips;
    private BlockingQueue<Pier> queueOfPiersForMedShips;
    private String typeOfShip;


    @Override
    public void run() {
        for (int i = 0; i < quantityOfShips; i++) {
            if (!(queueOfShips.isEmpty())) {
                currentShip = queueOfShips.poll();
                if (currentShip != null) {

                    if (currentShip.getShipType() == "Big") {
                        if (!(queueOfPiersForBigShips.isEmpty())) {
                            currentPier = queueOfPiersForBigShips.poll();
                            System.out.println("Unloading starting.. " + currentShip.getShipName() + " on pierID " + currentPier.getPierId());
                            try {
                                Thread.sleep(2000);
                                System.out.println(currentShip.getShipName() + " unloaded");
                                queueOfPiersForBigShips.put(currentPier);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else try {
                            queueOfShips.put(currentShip);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (currentShip.getShipType() == "Medium") {
                        if (!(queueOfPiersForMedShips.isEmpty())) {
                            currentPier = queueOfPiersForMedShips.poll();
                            System.out.println("Unloading starting.. " + currentShip.getShipName() + " on pierID " + currentPier.getPierId());
                            try {
                                Thread.sleep(2000);
                                System.out.println(currentShip.getShipName() + " unloaded");
                                queueOfPiersForMedShips.put(currentPier);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else try {
                            queueOfShips.put(currentShip);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


    public Customs(BlockingQueue<Ship> queueOfShips, BlockingQueue<Pier> queueOfPiersForBigShips,
                   BlockingQueue<Pier> queueOfPiersForSmallShips, BlockingQueue<Pier> queueOfPiersForMedShips,
                   int quantityOfShips) {
        this.queueOfShips = queueOfShips;
        this.queueOfPiersForBigShips = queueOfPiersForBigShips;
        this.queueOfPiersForMedShips = queueOfPiersForMedShips;
        this.queueOfPiersForSmallShips = queueOfPiersForSmallShips;
        this.quantityOfShips = quantityOfShips;
    }
}











