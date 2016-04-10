package com.ericpol.lab.java.examples.threads.sync;

/**
 * Created by xdzm on 2016-02-12.
 */
public class ThreadTest {

    public static void main(String[] args){
        Printer p = new Printer();
        ThreadDemo td1 = new ThreadDemo(p, "thread1");
        ThreadDemo td2 = new ThreadDemo(p, "thread2");
        td1.start();
        td2.start();

    }

}
