package model;

public class Booking {

    private Customer customer;

    private String flight;

    private double price;

    public Booking(Customer customer,
                   String flight,
                   double price) {

        this.customer = customer;
        this.flight = flight;
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getFlight() {
        return flight;
    }

    public double getPrice() {
        return price;
    }
}