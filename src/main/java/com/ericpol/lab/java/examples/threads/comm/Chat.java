package com.ericpol.lab.java.examples.threads.comm;

/**
 * Created by xdzm on 2016-02-17.
 */
public class Chat {
    boolean flag = false;

    public synchronized void question(String q){
        if(flag){
            try {wait();} catch (InterruptedException e) {}
        }
        System.out.println(new ThreadLocal<Boolean>().get());
        System.out.println(q);
        flag = true;
        notify();
    }

    public synchronized void answer(String a){
        if(!flag){
            try {wait();} catch (InterruptedException e) {}
        }
        System.out.println(new ThreadLocal<Boolean>().get());
        System.out.println(a);
        flag = false;
        notify();
    }
}
