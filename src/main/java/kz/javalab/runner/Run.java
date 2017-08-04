package kz.javalab.runner;

import operation.PortCreator;

/**
 * Created by HdgDink on 27.07.2017.
 */
public class Run {
    public static void main(String[] args) {

        PortCreator portCreator = new PortCreator();
        portCreator.start();
    }
}

