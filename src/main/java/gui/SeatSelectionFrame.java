package gui;

import repository.SeatRepository;

import javax.swing.*;
import java.awt.*;

public class SeatSelectionFrame extends JFrame {

    private String flightNumber;

    private BookingFrame bookingFrame;

    public SeatSelectionFrame(
            BookingFrame bookingFrame,
            String flightNumber) {

        this.bookingFrame = bookingFrame;
        this.flightNumber = flightNumber;

        setTitle(
                "Economy Class Seats - "
                        + flightNumber);

        setSize(900, 700);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                DISPOSE_ON_CLOSE);

        createSeatLayout();
    }

    private void createSeatLayout() {

        JPanel panel =
                new JPanel(
                        new GridLayout(
                                24,
                                7,
                                5,
                                5));

        panel.add(new JLabel(""));

        panel.add(new JLabel("A"));
        panel.add(new JLabel("B"));
        panel.add(new JLabel("C"));
        panel.add(new JLabel("D"));
        panel.add(new JLabel("E"));
        panel.add(new JLabel("F"));

        for (int row = 1; row <= 23; row++) {

            panel.add(
                    new JLabel(
                            String.valueOf(row)));

            for (char col = 'A';
                 col <= 'F';
                 col++) {

                String seat =
                        row +
                                String.valueOf(col);

                JButton button =
                        new JButton();

                if (SeatRepository.isReserved(
                        flightNumber,
                        seat)) {

                    button.setText("X");

                    button.setEnabled(false);

                } else {

                    button.setText(seat);

                    button.addActionListener(e -> {

                        SeatRepository.reserveSeat(
                                flightNumber,
                                seat);

                        bookingFrame.setSeat(seat);

                        JOptionPane.showMessageDialog(
                                this,
                                "Selected seat: "
                                        + seat);

                        dispose();
                    });
                }

                panel.add(button);
            }
        }

        JScrollPane scrollPane =
                new JScrollPane(panel);

        add(scrollPane);
    }
}