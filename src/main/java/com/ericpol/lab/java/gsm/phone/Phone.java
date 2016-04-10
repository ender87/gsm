package com.ericpol.lab.java.gsm.phone;

import com.ericpol.lab.java.gsm.network.radio.BaseTransceiverStation;
import com.ericpol.lab.java.gsm.phone.charger.Charger;
import com.ericpol.lab.java.gsm.phone.charger.ChargingController;
import com.ericpol.lab.java.gsm.network.core.MobileSwitchingCenter;
import com.ericpol.lab.java.gsm.phone.charger.IncompatibleChargerException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public abstract class Phone {

    private int id;

    public static final int MAX_BATTERY = 100;

    private int battery = Phone.MAX_BATTERY;

    private Status status = Status.DISCONNECTED;


    public abstract Producer getProducer();

    public abstract String getModel();

    public abstract int getPowerConsumption();


    private Set<Contact> contacts = new TreeSet<>();

    private Map<Shortcut, Contact> shortcuts = new HashMap<>();

    public Phone(int id){
        this.id = id;
        battery-=getPowerConsumption();
    }

    public boolean addContact(String name, String surname, String number) {
        return addContact(name, surname, number, null);
    }

    public boolean addContact(String name, String surname, String number, Shortcut s){
        Contact c = this.new Contact(name, surname, number);
        if(s!=null){
            shortcuts.put(s, c);
        }
        return contacts.add(c);
    }

    public Contact getContactByShortcut(Shortcut s){
        return shortcuts.get(s);
    }

    public void printContactBook(){
        System.out.println("contacts: " + contacts);
    }

    public void charge(Charger charger, int hours) {
        ChargingController controller = new ChargingController(this, charger);
        try {
            controller.plugIn(hours);
        } catch (IncompatibleChargerException e) {
            e.printStackTrace();
        }
    };



    public void register(MobileSwitchingCenter msc){

        System.out.println(this + " registering ...");

        if(status==Status.DISCONNECTED) {
            BaseTransceiverStation bts = findClosestStation(msc.getBtsSet());
            battery-=getPowerConsumption();
            if(bts.attach(id)){
                status = Status.CONNECTED;
                System.out.println(this + " connected");
            }
        } else {
            System.out.println(this + " already connected");
        }

    }

    private BaseTransceiverStation findClosestStation(Set<BaseTransceiverStation> btsSet){
        BaseTransceiverStation candidate = null;

        for(BaseTransceiverStation bts : btsSet){
            if(candidate==null || Math.abs(bts.getId()-id) < Math.abs(candidate.getId()-id)){
                candidate = bts;
            }
        }

        return candidate;
    }

    public int getBattery() {
        return battery;
    }

    public int getId() {
        return id;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String toString(){
        return getProducer() + ":" + getModel() + ":" + id + ":b=" + battery + ":s=" + status;
    }

    static enum Status {
        CONNECTED,
        DISCONNECTED
    }

    /**
     * Created by xdzm on 2016-02-22.
     */
    public class Contact implements Comparable<Contact>{

        private String name;

        private String surname;

        private String number;

        public Contact(String name, String surname, String number) {
            this.name = name;
            this.surname = surname;
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return "Contact{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", number='" + number + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Contact o) {
            int result = this.surname.compareTo(o.getSurname());
            if(result==0){
                result = this.name.compareTo(o.getName());
                if(result==0){
                    result = this.number.compareTo(o.getNumber());
                }
            }
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Contact)) return false;

            Contact contact = (Contact) o;

            if (getName() != null ? !getName().equals(contact.getName()) : contact.getName() != null) return false;
            if (getSurname() != null ? !getSurname().equals(contact.getSurname()) : contact.getSurname() != null)
                return false;
            return getNumber() != null ? getNumber().equals(contact.getNumber()) : contact.getNumber() == null;

        }

        @Override
        public int hashCode() {
            int result = getName() != null ? getName().hashCode() : 0;
            result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
            result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
            return result;
        }
    }
}
