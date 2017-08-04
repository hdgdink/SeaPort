package operation;

import kz.javalab.entity.Pier;
import kz.javalab.entity.Ship;


/**
 * Created by HdgDink on 05.08.2017.
 */
public class Unloader extends Thread {
    private Ship currentShip = null;
    private Pier currentPier = null;

    @Override
    public void run() {
        System.out.println("Unloading starting.. " + currentShip.getShipName() + " on pier "
                + currentPier.getPierType() + " #" + currentPier.getPierId());
        for (int i=0; i<currentShip.getShipCapacity();){
            System.out.println("Process of unloading of"+currentShip.getShipName()+" capacity is "+currentShip.getShipCapacity());
            currentShip.setShipCapacity(currentShip.getShipCapacity()-currentPier.getSpeedOfUnloading());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(currentShip.getShipName() + " unloaded");
    }

    public Unloader(Ship currentShip, Pier currentPier) {
        this.currentShip = currentShip;
        this.currentPier = currentPier;
    }

}
