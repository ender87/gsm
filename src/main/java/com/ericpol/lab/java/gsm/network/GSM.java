package com.ericpol.lab.java.gsm.network;

import com.ericpol.lab.java.gsm.network.core.MobileSwitchingCenter;
import com.ericpol.lab.java.gsm.network.radio.BaseStationController;
import com.ericpol.lab.java.gsm.network.radio.BaseTransceiverStation;
import com.ericpol.lab.java.gsm.utils.IDGenerator;
import com.ericpol.lab.java.gsm.utils.SerializationUtil;

/**
 * Created by xdzm on 2016-02-10.
 */
public class GSM {

    public static MobileSwitchingCenter getNetwork(){

        Object o = SerializationUtil.deserialize("msc.txt");
        if(o==null) {
            MobileSwitchingCenter msc = new MobileSwitchingCenter();

            BaseStationController bsc1 = new BaseStationController();
            BaseTransceiverStation bts11 = new BaseTransceiverStation(IDGenerator.newID());
            BaseTransceiverStation bts12 = new BaseTransceiverStation(IDGenerator.newID());
            BaseTransceiverStation bts13 = new BaseTransceiverStation(IDGenerator.newID());
            bsc1.addBts(bts11);
            bsc1.addBts(bts12);
            bsc1.addBts(bts13);
            msc.addBsc(bsc1);

            BaseStationController bsc2 = new BaseStationController();
            BaseTransceiverStation bts21 = new BaseTransceiverStation(IDGenerator.newID());
            BaseTransceiverStation bts22 = new BaseTransceiverStation(IDGenerator.newID());
            BaseTransceiverStation bts23 = new BaseTransceiverStation(IDGenerator.newID());
            BaseTransceiverStation bts24 = new BaseTransceiverStation(IDGenerator.newID());
            bsc2.addBts(bts21);
            bsc2.addBts(bts22);
            bsc2.addBts(bts23);
            bsc2.addBts(bts24);
            msc.addBsc(bsc2);

            BaseStationController bsc3 = new BaseStationController();
            BaseTransceiverStation bts31 = new BaseTransceiverStation(IDGenerator.newID());
            BaseTransceiverStation bts32 = new BaseTransceiverStation(IDGenerator.newID());
            bsc3.addBts(bts31);
            bsc3.addBts(bts32);
            msc.addBsc(bsc3);

            SerializationUtil.serialize(msc, "msc.txt");

            return msc;
        } else {
            return (MobileSwitchingCenter) o;
        }

    }

}
