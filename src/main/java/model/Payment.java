package model;

public class Payment {

    private double amount;
    private String method;
    private String status;

    public Payment(double amount,
                   String method,
                   String status) {

        this.amount = amount;
        this.method = method;
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    public String getStatus() {
        return status;
    }
}