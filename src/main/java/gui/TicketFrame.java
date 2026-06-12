package gui;

import javax.swing.*;
import java.awt.*;

public class TicketFrame extends JFrame {

    public TicketFrame(
            String passenger,
            String flight,
            String departureTime,
            String arrivalTime,
            String seat,
            double price) {

        setTitle("Airline Ticket");

        setSize(500, 450);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JTextArea area = new JTextArea();

        area.setEditable(false);

        area.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        14));

        String ticketNumber =
                "TK" + (System.currentTimeMillis() % 100000);

        area.setText(

                "=================================\n" +
                        "         AIRLINE TICKET\n" +
                        "=================================\n\n" +

                        "Ticket Number:\n" +
                        ticketNumber + "\n\n" +

                        "Passenger:\n" +
                        passenger + "\n\n" +

                        "Route:\n" +
                        flight + "\n\n" +

                        "Departure Time:\n" +
                        departureTime + "\n\n" +

                        "Arrival Time:\n" +
                        arrivalTime + "\n\n" +

                        "Seat:\n" +
                        seat + "\n\n" +

                        "Price:\n" +
                        price + " EUR\n\n" +

                        "Status:\n" +
                        "PAID\n\n" +

                        "=================================\n" +
                        "Thank you for choosing us!\n" +
                        "================================="
        );

        JButton closeButton =
                new JButton("Close");

        closeButton.addActionListener(
                e -> dispose());

        setLayout(new BorderLayout());

        add(
                new JScrollPane(area),
                BorderLayout.CENTER);

        add(
                closeButton,
                BorderLayout.SOUTH);
    }
}