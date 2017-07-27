package kz.javalab.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HdgDink on 28.07.2017.
 */
public class Dock {
    private String dockType;
    private int unloadSpeed;

    private List<Pier> piers = new ArrayList<Pier>();

    public void addPiers(Pier pier) {
        piers.add(pier);
    }


}
