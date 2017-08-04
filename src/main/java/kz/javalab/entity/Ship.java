package kz.javalab.entity;

/**
 * Created by HdgDink on 27.07.2017.
 */
public class Ship {
    private String shipName;
    private String shipType;
    private int shipCapacity;

    public  void createShip(){

    }

    public Ship(String shipName, String shipType, int shipCapacity) {
        this.shipName = shipName;
        this.shipType = shipType;
        this.shipCapacity = shipCapacity;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public int getShipCapacity() {
        return shipCapacity;
    }

    public void setShipCapacity(int shipCapacity) {
        this.shipCapacity = shipCapacity;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "shipName='" + shipName + '\'' +
                ", shipType='" + shipType + '\'' +
                ", shipCapacity=" + shipCapacity +
                '}';
    }
}
