package com.ericpol.lab.java.gsm.utils;

import java.util.Date;
import java.util.Random;

public class IDGenerator {

    private static Random random = new Random(new Date().getTime());

    /**
     * provides randomm integer number
     * @return random integer number in 1 to 1000 range
     */
    public static int newID() {

        int newInt = random.nextInt(1000) + 1;
        return newInt;
    }
}
