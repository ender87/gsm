package com.ericpol.lab.java.gsm.network.radio;

import java.io.Serializable;

/**
 * Created by xdzm on 2016-01-29.
 */
public class BaseTransceiverStation implements Serializable{

    private static final long serialVersionUID = 5817899226091153386L;

    private int id;

    private BaseStationController bsc;


    public BaseTransceiverStation(int id) {
        this.id = id;
    }

    public boolean attach(int id){
        return getBsc().getMsc().attach(id, this);
    }

    public int getId() {
        return id;
    }

    public BaseStationController getBsc() {
        return bsc;
    }

    public void setBsc(BaseStationController bsc) {
        this.bsc = bsc;
    }

    @Override
    public String toString() {
        return "BTS{" + id + '}';
    }
}
