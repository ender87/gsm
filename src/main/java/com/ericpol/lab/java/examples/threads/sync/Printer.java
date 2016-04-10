package com.ericpol.lab.java.examples.threads.sync;

/**
 * Created by xdzm on 2016-02-12.
 */
public class Printer {

    public void printCount(){
        for (int i=0; i<5; i++){
            System.out.println("counter=" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
