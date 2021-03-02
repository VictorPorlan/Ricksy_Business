package edu.pingpong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UfosPark implements GuestDispatcher {

    private double fee = 500d;
    private Map<String, String> flota = new HashMap<String, String>();

    public UfosPark() {
    }

    void add(String ufoId) {
        flota.putIfAbsent(ufoId, null);
    }

    @Override
    public void dispatch(CreditCard creditCard) {

        if (flota.containsValue(creditCard.number()) == false) {
            List<String> list = flota.entrySet().stream().filter(f -> f.getValue() == null).map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            if (!list.isEmpty() && creditCard.pay(fee)) {
                this.flota.put(list.get(0), creditCard.number());
            }
        }

    }

    String getUfoOf(String creditCardNumber) {
        List<String> list = new ArrayList<String>();
        if (this.flota.containsValue(creditCardNumber)) {
            list = flota.entrySet().stream().filter(f -> f.getValue() == creditCardNumber).map(Map.Entry::getKey)
                    .collect(Collectors.toList());
            return list.get(0);
        }

        else {
            return null;
        }

    }

    boolean containsCard(String cardNumber) {
        return this.flota.containsValue(cardNumber);
    }

    Collection<String> cardNumbers() {
        return this.flota.values();
    }

    @Override
    public String toString() {
        String[] ufosID = this.flota.keySet().toArray(new String[flota.size()]);
        Arrays.sort(ufosID);
        return List.of(ufosID).toString();
    }

}
