package com.ericpol.lab.java.examples.threads.sync;

/**
 * Created by xdzm on 2016-02-12.
 */
public class ThreadDemo extends Thread {

    private Printer p;

    public ThreadDemo(Printer p, String name) {
        super(name);
        this.p = p;
    }

    public void run() {
        System.out.println("Start " + getName());
       // synchronized (p){
            p.printCount();
       // }
        System.out.println(getName() + " finished.");
    }
}
