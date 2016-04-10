package com.ericpol.lab.java.gsm.utils;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by xdzm on 2016-02-11.
 */
public class ThreadPrintStream extends PrintStream {

    public ThreadPrintStream() {
        super(System.out);
    }

    public void println(String str) {
        super.println("[" + Thread.currentThread().getName() + "]\t" + str);
    }

    public void println(Object o){
        this.println(o.toString());
    }
}
