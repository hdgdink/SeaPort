package kz.javalab.entity;

/**
 * Created by HdgDink on 28.07.2017.
 */
public class Pier {

    private int pierId;
    private boolean isEmpty;
    private int speedOfUnloading;
    private String pierType;

    public Pier(int pierId, boolean isEmpty, int speedOfUnloading, String pierType) {
        this.pierId = pierId;
        this.isEmpty = isEmpty;
        this.speedOfUnloading = speedOfUnloading;
        this.pierType = pierType;
    }



    public int getPierId() {
        return pierId;
    }

    public void setPierId(int pierId) {
        this.pierId = pierId;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public int getSpeedOfUnloading() {
        return speedOfUnloading;
    }

    public void setSpeedOfUnloading(int speedOfUnloading) {
        this.speedOfUnloading = speedOfUnloading;
    }

    public String getPierType() {
        return pierType;
    }

    public void setPierType(String pierType) {
        this.pierType = pierType;
    }

    @Override
    public String toString() {
        return "\nPier " + pierType + " Id= " + pierId + ", IsEmpty " + isEmpty;
    }
}
