package com.ericpol.lab.java.gsm.phone.charger;

import com.ericpol.lab.java.gsm.phone.Phone;
import com.ericpol.lab.java.gsm.phone.Wireless;

public class ChargingController {

    private Charger charger;

    private Phone phone;

    private ChargingMonitor monitor = ChargingMonitor.getInstance();

    public ChargingController(Phone phone, Charger charger){
        this.phone = phone;
        this.charger = charger;
    }

    public void plugIn(final int hours) throws IncompatibleChargerException {

        compatibilityCheck();

        Runnable r = () -> {
            PhoneContext.set(phone);
            for(int i=1;i<=hours;i++) {
                synchronized (monitor) {
                    monitor.print(phone + " charging...");
                    if (charge()) {
                        monitor.print(phone + " battery full. charging interrupted.");
                        break;
                    }
                }
            }
            System.out.println(phone + " charging finished.");
        };

        new Thread(r, "phone" + phone.getId()).start();
    }

    private void compatibilityCheck() throws IncompatibleChargerException {

        if(charger.getProducer()!=phone.getProducer()){
            throw new IncompatibleChargerException("charger of producer " + charger.getProducer() +
            "does not match phone producer " + phone.getProducer());
        }
    }

    private boolean charge(){
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int battery = phone.getBattery();
        int increase = charger.getVoltage();
        boolean batteryFull = false;

        Wireless phoneWireless = phone.getClass().getAnnotation(Wireless.class);
        Wireless chargerWireless = charger.getClass().getAnnotation(Wireless.class);

        if(phoneWireless!=null && chargerWireless!=null){
            System.out.println("charging wirelessly...");
            increase=-phoneWireless.loss();
            increase=-chargerWireless.loss();
        }

        battery+=increase;
        if(battery>=Phone.MAX_BATTERY){
            batteryFull = true;
            phone.setBattery(Phone.MAX_BATTERY);
        } else {
            phone.setBattery(battery);
        }
        return batteryFull;
    }

    public Charger getCharger() {
        return charger;
    }

    public Phone getPhone() {
        return phone;
    }
}
