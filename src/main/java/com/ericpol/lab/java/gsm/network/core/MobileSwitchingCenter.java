package com.ericpol.lab.java.gsm.network.core;

import com.ericpol.lab.java.gsm.network.radio.BaseStationController;
import com.ericpol.lab.java.gsm.network.radio.BaseTransceiverStation;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class MobileSwitchingCenter implements Serializable {

    private static final long serialVersionUID = -1528961053304111704L;

    private Set<BaseStationController> bscSet = new HashSet<BaseStationController>();

    private VisitorLocationRegistry vlr = new VisitorLocationRegistry();

    public void addBsc(BaseStationController bsc){
        bscSet.add(bsc);
        bsc.setMsc(this);
    }

    public Set<BaseTransceiverStation> getBtsSet(){
        Set<BaseTransceiverStation> btsSet = new HashSet<BaseTransceiverStation>();
        for(BaseStationController bsc : bscSet){
            btsSet.addAll(bsc.getBtsSet());
        }
        return btsSet;
    }

    @Override
    public String toString() {
        return "MSC{" + bscSet +'}';
    }

    public boolean attach(int id, BaseTransceiverStation bts){
        System.out.println("attaching user " + id + " to BTS " + bts);
        vlr.register(bts, id);
        return true;
    }
}
