package kz.javalab.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HdgDink on 27.07.2017.
 */
public class SeaPort {
    private String portName;

    List<Dock> docks = new ArrayList<>();

    public void addDocks (Dock dock){
        docks.add(dock);
    }


}
