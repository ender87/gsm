package com.ericpol.lab.java.gsm.phone.charger;

/**
 * Created by xdzm on 2016-02-23.
 */
public class ChargingMonitor {

    private static ChargingMonitor instance;

    private ChargingMonitor(){}

    public synchronized static ChargingMonitor getInstance(){
        if(instance==null){
            instance = new ChargingMonitor();
        }
        return instance;
    }

    public void print(String msg){
        System.out.println("monitoring context: " + PhoneContext.get());
        System.out.println(msg);
    }

}
