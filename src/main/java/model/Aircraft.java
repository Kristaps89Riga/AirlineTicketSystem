package model;

public class Aircraft {

    private String id;
    private String model;
    private int seats;

    public Aircraft(String id,
                    String model,
                    int seats) {

        this.id = id;
        this.model = model;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getSeats() {
        return seats;
    }
}