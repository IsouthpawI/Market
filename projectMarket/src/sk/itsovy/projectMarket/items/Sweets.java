package sk.itsovy.projectMarket.items;

import sk.itsovy.projectMarket.interfaces.Pc;

public class Sweets extends Food implements Pc {

    private int amount;

    public Sweets(String name, double price, int calories, int amount) {
        super(name, price, calories);
        this.amount = amount;
    }

    public Sweets(String name, double price, int amount) {

        this(name,price,-1,amount);
    }

    @Override
    public int getAmount() {

        return amount;
    }

    @Override
    public String getName() {

        return getName();
    }

    @Override
    public double getTotalPrice() {

        return amount*getPrice();
    }
}
