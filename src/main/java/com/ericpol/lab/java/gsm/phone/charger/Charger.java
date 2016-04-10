package com.ericpol.lab.java.gsm.phone.charger;

import com.ericpol.lab.java.gsm.phone.Producer;

public interface Charger {

	int getVoltage();

	Producer getProducer();

}
