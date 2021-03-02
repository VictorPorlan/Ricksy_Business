package edu.pingpong;

import java.util.LinkedHashSet;
import java.util.Set;

public class Receptivo {

    Receptivo() {

    }

    private Set<GuestDispatcher> observers = new LinkedHashSet<>();

    void registra(GuestDispatcher guestDispatcher) {
        observers.add(guestDispatcher);
    }

    void dispatch(CreditCard card) {
        for (GuestDispatcher guestDispatcher : observers) {
            guestDispatcher.dispatch(card);
        }
    }
}
