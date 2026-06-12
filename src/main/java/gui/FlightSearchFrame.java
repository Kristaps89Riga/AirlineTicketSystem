package gui;

import model.Flight;
import service.FlightService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FlightSearchFrame extends JFrame {

    public FlightSearchFrame() {

        setTitle("Search Flights");

        setSize(700, 450);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        FlightService flightService =
                new FlightService();

        List<Flight> flights =
                flightService.getFlights();

        DefaultListModel<String> model =
                new DefaultListModel<>();

        for (Flight flight : flights) {

            model.addElement(

                    flight.getFlightNumber()
                            + " | "
                            + flight.getDepartureCity()
                            + " → "
                            + flight.getArrivalCity()
                            + " | "
                            + flight.getDepartureTime()
                            + " - "
                            + flight.getArrivalTime()
                            + " | "
                            + flight.getPrice()
                            + " EUR"
            );
        }

        JList<String> flightList =
                new JList<>(model);

        flightList.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane =
                new JScrollPane(flightList);

        JButton bookButton =
                new JButton("Book Flight");

        add(
                scrollPane,
                BorderLayout.CENTER
        );

        add(
                bookButton,
                BorderLayout.SOUTH
        );

        bookButton.addActionListener(e -> {

            int selectedIndex =
                    flightList.getSelectedIndex();

            if (selectedIndex == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select a flight!"
                );

                return;
            }

            Flight selectedFlight =
                    flights.get(selectedIndex);

            BookingFrame bookingFrame =
                    new BookingFrame(
                            selectedFlight.getFlightNumber(),
                            selectedFlight.getPrice(),
                            selectedFlight.getDepartureCity()
                                    + " → "
                                    + selectedFlight.getArrivalCity(),
                            selectedFlight.getDepartureTime(),
                            selectedFlight.getArrivalTime()
                    );

            bookingFrame.setVisible(true);
        });

        setVisible(true);
    }
}