package com.ericpol.lab.java.gsm.phone;

import com.ericpol.lab.java.gsm.phone.htc.HTCDesire;
import com.ericpol.lab.java.gsm.phone.samsung.SamsungS6;
import com.ericpol.lab.java.gsm.utils.IDGenerator;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class PhoneLoader {

    private static final String PHONE_CLASS_KEY = "phoneclass";

    public static Map<Producer, Phone> getPhonesMap() {

        Map flagshipPhones = new HashMap<Producer, Phone>();
        flagshipPhones.put(Producer.SAMSUNG, new SamsungS6(IDGenerator.newID()));
        flagshipPhones.put(Producer.HTC, new HTCDesire(IDGenerator.newID()));
        return flagshipPhones;
    }

    public static Phone loadPhone(int id){

        Properties props = new Properties();
        try {
            props.load(PhoneLoader.class.getResourceAsStream("phone.properties"));
            String phoneClass = props.getProperty(PHONE_CLASS_KEY);
            Class clazz = Class.forName(phoneClass);
            Constructor constructor = clazz.getConstructor(new Class[]{int.class});
            Object o = constructor.newInstance(id);
            return (Phone) o;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
