package edu.pingpong;

public class CreditCard {
    private final String owner;
    private final String number;
    private double credit = 3000d;
    private final String symbol = "EZI";

    CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
    }

    boolean pay(double precio) {
        if (this.credit >= precio) {
            this.credit -= precio;
            return true;
        } else {
            return false;
        }
    }

    String number() {
        return this.number;
    }

    String cardOwner() {
        return this.owner;
    }

    double credit() {
        return this.credit;
    }

    @Override
    public String toString() {
        return "owner: " + cardOwner() + "\n" + "number: " + number() + "\n" + "credit: " + credit() + this.symbol;
    }
}
