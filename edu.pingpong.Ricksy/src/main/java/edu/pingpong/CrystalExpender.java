package edu.pingpong;

public class CrystalExpender implements GuestDispatcher {

    private int stock = 0;
    private double itemCost = 0d;

    public CrystalExpender(int stock, double itemCost) {
        this.stock = stock;
        this.itemCost = itemCost;
    }

    @Override
    public void dispatch(CreditCard creditCard) {
        if (this.stock > 0 && creditCard.pay(this.itemCost)) {
            this.stock -= 1;
        }
    }

    @Override
    public String toString() {
        return "stock: " + stock() + "\n" + "cost: " + this.itemCost;
    }

    int stock() {
        return this.stock;
    }
}
