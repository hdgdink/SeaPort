package kz.javalab.entity;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by HdgDink on 27.07.2017.
 */
public class SeaPort  {

    private String portName;

    public BlockingQueue<Pier> getPiers() {
        return piers;
    }

    public BlockingQueue<Pier> piers = new ArrayBlockingQueue<Pier>(6);



    public void addPier(Pier pier) {
        piers.add(pier);
    }

     public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }



    @Override
    public String toString() {
        return "SeaPort " + portName + ", piers: " + piers;
    }
}
