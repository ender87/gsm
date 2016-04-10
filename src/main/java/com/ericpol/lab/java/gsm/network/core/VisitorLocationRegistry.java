package com.ericpol.lab.java.gsm.network.core;

import com.ericpol.lab.java.gsm.network.radio.BaseTransceiverStation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;

/**
 * Created by xdzm on 2016-02-22.
 */
public class VisitorLocationRegistry implements Serializable{

    private static final long serialVersionUID = -7780032390955373642L;

    static final String VLR_FILE = "vlr.txt";

    public void register(BaseTransceiverStation bts, int phoneId){

        Writer w = null;

        try {
            w = new FileWriter(VLR_FILE, true);
            w.write("user " + phoneId + " connected to " + bts + "\n\r");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (w != null) {
                    w.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
