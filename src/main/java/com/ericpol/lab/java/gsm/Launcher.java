package com.ericpol.lab.java.gsm;


import com.ericpol.lab.java.gsm.network.GSM;
import com.ericpol.lab.java.gsm.network.core.MobileSwitchingCenter;
import com.ericpol.lab.java.gsm.phone.Phone;
import com.ericpol.lab.java.gsm.phone.PhoneLoader;
import com.ericpol.lab.java.gsm.phone.Producer;
import com.ericpol.lab.java.gsm.phone.Shortcut;
import com.ericpol.lab.java.gsm.phone.charger.Charger;
import com.ericpol.lab.java.gsm.phone.htc.HTCDesire;
import com.ericpol.lab.java.gsm.phone.samsung.SamsungCharger;
import com.ericpol.lab.java.gsm.phone.samsung.SamsungS6;
import com.ericpol.lab.java.gsm.utils.IDGenerator;
import com.ericpol.lab.java.gsm.utils.ThreadPrintStream;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by xdzm on 2015-09-25.
 */
public class Launcher {

    public static void main(String[] args) {

        System.setOut(new ThreadPrintStream());
        System.out.println("starting ...");

        MobileSwitchingCenter msc = GSM.getNetwork();
        System.out.println("msc: " + msc);

        Map<Producer, Phone> flagshipPhones = PhoneLoader.getPhonesMap();

        Phone s6 = flagshipPhones.get(Producer.SAMSUNG);
        Phone htc = flagshipPhones.get(Producer.HTC);

        s6.register(msc);
        htc.register(msc);

        Charger samsungCharger = new SamsungCharger();
        Charger htcCharger = new Charger() {
            public int getVoltage() {
                return 4;
            }
            public Producer getProducer() {
                return Producer.HTC;
            }
        };

        s6.addContact("Jan", "Kowalski", "+48837468236");
        s6.addContact("Zenon", "Kowalski", "+4834534534", new Shortcut(2));
        s6.addContact("Jan", "Kowal", "+483453453");
        s6.addContact("Jan", "Kowalski", "+4856456456", new Shortcut(1));
        s6.addContact("Adam", "Nowak", "+483453532345");
        s6.addContact("Adam", "Nowak", "+483453532345", new Shortcut(2));

        s6.printContactBook();

        Phone.Contact c = s6.getContactByShortcut(new Shortcut(2));
        System.out.println("shortcut 2: " + c);

        htc.charge(htcCharger, 3);
        s6.charge(samsungCharger, 5);


        Phone loaded = PhoneLoader.loadPhone(IDGenerator.newID());
        System.out.println("loaded phone instance: " + loaded);


        System.out.println(s6);
        System.out.println(htc);

        System.out.println("[Launcher] done.");
    }






}
