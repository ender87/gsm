package com.ericpol.lab.java.gsm.network.radio;

import com.ericpol.lab.java.gsm.network.core.MobileSwitchingCenter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xdzm on 2016-01-29.
 */
public class BaseStationController implements Serializable {

    private static final long serialVersionUID = 8548892439195410152L;

    private Set<BaseTransceiverStation> btsSet = new HashSet<BaseTransceiverStation>();

    private MobileSwitchingCenter msc;

    public void addBts(BaseTransceiverStation bts){
        btsSet.add(bts);
        bts.setBsc(this);
    }

    public Set<BaseTransceiverStation> getBtsSet() {
        return btsSet;
    }

    public MobileSwitchingCenter getMsc() {
        return msc;
    }

    public void setMsc(MobileSwitchingCenter msc) {
        this.msc = msc;
    }

    @Override
    public String toString() {
        return "BSC{" + btsSet + '}';
    }
}
