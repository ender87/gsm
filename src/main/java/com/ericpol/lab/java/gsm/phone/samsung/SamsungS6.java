package com.ericpol.lab.java.gsm.phone.samsung;

import com.ericpol.lab.java.gsm.phone.Phone;
import com.ericpol.lab.java.gsm.phone.Producer;
import com.ericpol.lab.java.gsm.phone.Wireless;

/**
 * Created by xdzm on 2016-01-29.
 */

@Wireless(loss=1)
public class SamsungS6 extends Phone {

    public SamsungS6(int id) {
        super(id);
    }

    public Producer getProducer() {
        return Producer.SAMSUNG;
    }

    public String getModel() {
        return "S6";
    }

    public int getPowerConsumption() {
        return 6;
    }
}
