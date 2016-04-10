package com.ericpol.lab.java.gsm.phone.charger;

import com.ericpol.lab.java.gsm.phone.Phone;

/**
 * Created by xdzm on 2016-02-23.
 */
public class PhoneContext {

    private static ThreadLocal<Phone> tl = new ThreadLocal<>();

    public static void set(Phone p){
        tl.set(p);
    }

    public static Phone get(){
        return tl.get();
    }
}
