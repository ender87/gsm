package com.ericpol.lab.java.gsm.phone;

/**
 * Created by xdzm on 2016-02-22.
 */
public class Shortcut {

    private int button;

    public Shortcut(int button) {
        this.button = button;
    }

    public int getButton() {
        return button;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shortcut)) return false;

        Shortcut shortcut = (Shortcut) o;

        return getButton() == shortcut.getButton();

    }

    @Override
    public int hashCode() {
        return getButton();
    }
}
