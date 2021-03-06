package sk.itsovy.projectMarket.items;

public class Fruit extends Food {

    private double weight;

    public Fruit(String name, double price, int calories, double weight) {
        super(name, price, calories);
        this.weight = weight;
    }

    public Fruit(String name, double price, double weight) {

        this(name,price,-1,weight);
    }


    @Override
    public double getTotalPrice() {

        return weight*getPrice();
    }

    @Override
    public String getName() {

        return getName();
    }

    public double getWeight() {

        return weight;
    }
}
