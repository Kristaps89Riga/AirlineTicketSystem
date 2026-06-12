package gui;

import model.Baggage;
import model.Customer;
import model.Flight;
import model.Seat;

import javax.swing.*;
import java.awt.*;

public class BookingFrame extends JFrame {

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;

    private JCheckBox baggageCheckBox;

    private JLabel totalPriceLabel;
    private JLabel seatLabel;

    private JButton calculateButton;
    private JButton saveButton;
    private JButton cancelButton;
    private JButton seatButton;

    private double basePrice;
    private double totalAmount;

    private String selectedSeat = "Not selected";

    private String flightRoute;
    private String departureTime;
    private String arrivalTime;

    private String flightNumber;

    public BookingFrame(
            String flightNumber,
            double basePrice,
            String flightRoute,
            String departureTime,
            String arrivalTime) {

        this.flightNumber = flightNumber;
        this.basePrice = basePrice;
        this.flightRoute = flightRoute;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;

        this.totalAmount = basePrice;

        setTitle("Flight Booking");
        setSize(550, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        initializeComponents();
    }

    private void initializeComponents() {

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(10, 2, 10, 10));

        firstNameField = new JTextField();
        lastNameField = new JTextField();
        emailField = new JTextField();

        baggageCheckBox =
                new JCheckBox("Add baggage (+20 EUR)");

        totalPriceLabel =
                new JLabel("Total: " + basePrice + " EUR");

        seatLabel =
                new JLabel("Not selected");

        calculateButton =
                new JButton("Calculate");

        saveButton =
                new JButton("Save Booking");

        cancelButton =
                new JButton("Cancel");

        seatButton =
                new JButton("Select Seat");

        panel.add(new JLabel("First Name"));
        panel.add(firstNameField);

        panel.add(new JLabel("Last Name"));
        panel.add(lastNameField);

        panel.add(new JLabel("Email"));
        panel.add(emailField);

        panel.add(new JLabel("Seat"));
        panel.add(seatLabel);

        panel.add(new JLabel(""));
        panel.add(seatButton);

        panel.add(new JLabel("Baggage"));
        panel.add(baggageCheckBox);

        panel.add(new JLabel("Price"));
        panel.add(totalPriceLabel);

        panel.add(calculateButton);
        panel.add(saveButton);

        panel.add(cancelButton);

        add(panel);

        // Seat selection

        seatButton.addActionListener(e -> {

            SeatSelectionFrame frame =
                    new SeatSelectionFrame(
                            this,
                            flightNumber
                    );

            frame.setVisible(true);

        });

        // Calculate price

        calculateButton.addActionListener(e -> {

            totalAmount = basePrice;

            if (baggageCheckBox.isSelected()) {
                totalAmount += 20;
            }

            totalPriceLabel.setText(
                    "Total: "
                            + totalAmount
                            + " EUR");
        });

        // Save booking

        saveButton.addActionListener(e -> {

            if (firstNameField.getText().isEmpty()
                    || lastNameField.getText().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter passenger name!");

                return;
            }

            if (selectedSeat.equals("Not selected")) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select a seat!");

                return;
            }

            totalAmount = basePrice;

            if (baggageCheckBox.isSelected()) {
                totalAmount += 20;
            }

            String passengerName =
                    firstNameField.getText()
                            + " "
                            + lastNameField.getText();

            new PaymentFrame(
                    passengerName,
                    flightRoute,
                    departureTime,
                    arrivalTime,
                    selectedSeat,
                    totalAmount
            ).setVisible(true);

            dispose();
        });

        cancelButton.addActionListener(
                e -> dispose());
    }

    public JButton getCalculateButton() {
        return calculateButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public Customer getCustomer() {

        return new Customer(
                firstNameField.getText(),
                lastNameField.getText(),
                emailField.getText()
        );
    }

    public Seat getSelectedSeat() {

        return new Seat(selectedSeat);
    }

    public Baggage getSelectedBaggage() {

        if (baggageCheckBox.isSelected()) {

            return new Baggage(
                    20,
                    20
            );
        }

        return null;
    }

    public void setTotalPrice(
            double totalPrice) {

        totalPriceLabel.setText(
                "Total: "
                        + totalPrice
                        + " EUR");
    }

    public String getSeatNumber() {
        return selectedSeat;
    }

    public void setSeat(String seat) {

        selectedSeat = seat;

        seatLabel.setText(seat);
    }
}