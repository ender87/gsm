package com.ericpol.lab.java.gsm.utils;

import java.io.*;

/**
 * Created by xdzm on 2016-02-22.
 */
public class SerializationUtil {

    public static void serialize(Object o, String fileName){

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
           oos.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserialize(String fileName){

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
