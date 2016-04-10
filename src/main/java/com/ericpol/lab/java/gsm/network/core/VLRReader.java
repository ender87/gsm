package com.ericpol.lab.java.gsm.network.core;

import java.io.*;

/**
 * Created by xdzm on 2016-02-23.
 */
public class VLRReader {

    public static void main(String[] args) {

        BufferedReader r = null;

        try {
            r = new BufferedReader(new FileReader(VisitorLocationRegistry.VLR_FILE));
            String line = null;
            while((line = r.readLine())!=null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (r != null) {
                    r.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
