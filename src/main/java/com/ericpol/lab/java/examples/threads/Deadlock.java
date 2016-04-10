package com.ericpol.lab.java.examples.threads;

/**
 * Created by xdzm on 2016-02-17.
 */
public class Deadlock extends Thread{
    Object lock1;
    Object lock2;
    public Deadlock(String name, Object lock1, Object lock2){
        super(name);
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    public void run() {
        synchronized (lock1){
            System.out.println(getName() + " hold lock1");
            try { Thread.sleep(1000);} catch (InterruptedException e) {}
            System.out.println(getName() + " entering lock2");
            synchronized (lock2){
                System.out.println(getName() + " hold lock1 & lock2");
            }
        }
    }

    public static void main(String[] args){
        Object o1 = new Object();
        Object o2 = new Object();
        Deadlock d1 = new Deadlock("d1", o1, o2);
        Deadlock d2 = new Deadlock("d2", o1, o2);
        d1.start();
        d2.start();
    }
}
