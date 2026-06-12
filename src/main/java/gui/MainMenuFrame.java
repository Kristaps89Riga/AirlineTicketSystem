package gui;

import javax.swing.*;

public class MainMenuFrame extends JFrame {

    public MainMenuFrame() {

        setTitle("Airline Ticket System");

        setSize(800,600);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        JButton button =
                new JButton("Search Flights");

        button.addActionListener(e -> {

            FlightSearchFrame frame =
                    new FlightSearchFrame();

            frame.setVisible(true);

        });

        add(button);

        setVisible(true);
    }
}