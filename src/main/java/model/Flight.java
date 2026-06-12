package model;

public class Flight {

    private String flightNumber;

    private String departureCity;

    private String arrivalCity;

    private String departureTime;

    private String arrivalTime;

    private double price;

    public Flight(
            String flightNumber,
            String departureCity,
            String arrivalCity,
            String departureTime,
            String arrivalTime,
            double price) {

        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public double getPrice() {
        return price;
    }
}