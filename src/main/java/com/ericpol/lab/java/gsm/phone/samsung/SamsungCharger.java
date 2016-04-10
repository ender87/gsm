package com.ericpol.lab.java.gsm.phone.samsung;

import com.ericpol.lab.java.gsm.phone.Producer;
import com.ericpol.lab.java.gsm.phone.Wireless;
import com.ericpol.lab.java.gsm.phone.charger.Charger;

/**
 * Created by xdzm on 2016-01-29.
 */
@Wireless(loss=2)
public class SamsungCharger implements Charger {

    public int getVoltage() {
        return 7;
    }

    public Producer getProducer() {
        return Producer.SAMSUNG;
    }
}
