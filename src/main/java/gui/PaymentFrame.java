package gui;

import javax.swing.*;
import java.awt.*;
import repository.BookingFileRepository;

public class PaymentFrame extends JFrame {

    private JLabel amountLabel;

    private JRadioButton cardButton;
    private JRadioButton paypalButton;
    private JRadioButton cashButton;

    private JButton payButton;
    private JButton cancelButton;

    private String passengerName;
    private String seatNumber;

    private double amount;

    private String flightRoute;
    private String departureTime;
    private String arrivalTime;

    public PaymentFrame(
            String passengerName,
            String flightRoute,
            String departureTime,
            String arrivalTime,
            String seatNumber,
            double amount) {

        this.passengerName = passengerName;
        this.seatNumber = seatNumber;
        this.amount = amount;
        this.flightRoute = flightRoute;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;

        setTitle("Payment");

        setSize(450, 350);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        initializeComponents();
    }

    private void initializeComponents() {

        setLayout(new GridLayout(8, 1, 10, 10));

        amountLabel =
                new JLabel(
                        "Amount: "
                                + amount
                                + " EUR",
                        SwingConstants.CENTER);

        cardButton =
                new JRadioButton("Credit Card");

        paypalButton =
                new JRadioButton("PayPal");

        cashButton =
                new JRadioButton("Cash");

        ButtonGroup group =
                new ButtonGroup();

        group.add(cardButton);
        group.add(paypalButton);
        group.add(cashButton);

        payButton =
                new JButton("PAY");

        cancelButton =
                new JButton("Cancel");

        add(amountLabel);
        add(cardButton);
        add(paypalButton);
        add(cashButton);

        add(new JLabel(
                "Choose payment method",
                SwingConstants.CENTER));

        add(payButton);
        add(cancelButton);

        payButton.addActionListener(e -> {

            if (!cardButton.isSelected()
                    && !paypalButton.isSelected()
                    && !cashButton.isSelected()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select payment method!");

                return;
            }

            String paymentMethod;

            if (cardButton.isSelected()) {

                paymentMethod =
                        "Credit Card";

            } else if (paypalButton.isSelected()) {

                paymentMethod =
                        "PayPal";

            } else {

                paymentMethod =
                        "Cash";
            }

            JOptionPane.showMessageDialog(
                    this,
                    "Payment Successful!\n\n"
                            + "Method: "
                            + paymentMethod);
            BookingFileRepository repository =
                    new BookingFileRepository();

            repository.saveBooking(
                    passengerName,
                    flightRoute,
                    seatNumber,
                    amount
            );

            new TicketFrame(
                    passengerName,
                    flightRoute,
                    departureTime,
                    arrivalTime,
                    seatNumber,
                    amount
            ).setVisible(true);

            dispose();
        });

        cancelButton.addActionListener(
                e -> dispose());
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public double getAmount() {
        return amount;
    }
}