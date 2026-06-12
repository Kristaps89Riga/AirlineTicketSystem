package model;

public class Baggage {

    private double weight;
    private double price;

    public Baggage(double weight,
                   double price) {

        this.weight = weight;
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }
}