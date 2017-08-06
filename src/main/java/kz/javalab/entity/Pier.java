package kz.javalab.entity;

/**
 * Created by HdgDink on 28.07.2017.
 */
public class Pier {
    private int pierId;
    private int speedOfUnloading;
    private String pierType;

    public Pier(int pierId, int speedOfUnloading, String pierType) {
        this.pierId = pierId;
        this.speedOfUnloading = speedOfUnloading;
        this.pierType = pierType;
    }

    public int getPierId() {
        return pierId;
    }

    public int getSpeedOfUnloading() {
        return speedOfUnloading;
    }

    public String getPierType() {
        return pierType;
    }

    @Override
    public String toString() {
        return "\nPier " + pierType + " Id= " + pierId;
    }
}
