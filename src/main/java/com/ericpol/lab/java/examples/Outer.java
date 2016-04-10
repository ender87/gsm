package com.ericpol.lab.java.examples;

/**
 * Created by xdzm on 2016-02-10.
 */
public class Outer {
    private static int param = 5;

    static class Nested {
        void print(){
            System.out.println(param);
        }
    }
}
