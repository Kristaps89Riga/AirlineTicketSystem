package model;

public class Seat {

    private String seatNumber;
    private boolean reserved;

    public Seat(String seatNumber) {

        this.seatNumber = seatNumber;
        this.reserved = false;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void reserve() {
        reserved = true;
    }
}