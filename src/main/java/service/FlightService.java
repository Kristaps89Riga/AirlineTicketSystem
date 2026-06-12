package service;

import model.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightService {

    private List<Flight> flights =
            new ArrayList<>();

    public FlightService() {

        flights.add(new Flight(
                "BT101",
                "Riga",
                "London",
                "08:30",
                "11:00",
                130));

        flights.add(new Flight(
                "BT102",
                "London",
                "Riga",
                "13:00",
                "15:30",
                130));

        flights.add(new Flight(
                "BT201",
                "Riga",
                "Paris",
                "08:00",
                "10:00",
                120));

        flights.add(new Flight(
                "BT202",
                "Paris",
                "Riga",
                "12:00",
                "14:00",
                120));

        flights.add(new Flight(
                "BT301",
                "Riga",
                "Barcelona",
                "07:45",
                "10:45",
                150));

        flights.add(new Flight(
                "BT302",
                "Barcelona",
                "Riga",
                "12:45",
                "15:45",
                150));

        flights.add(new Flight(
                "BT401",
                "Riga",
                "Rome",
                "09:30",
                "12:30",
                150));

        flights.add(new Flight(
                "BT402",
                "Rome",
                "Riga",
                "14:30",
                "17:30",
                150));

        flights.add(new Flight(
                "BT501",
                "Riga",
                "Athens",
                "13:00",
                "16:30",
                180));

        flights.add(new Flight(
                "BT502",
                "Athens",
                "Riga",
                "17:30",
                "21:00",
                180));

        flights.add(new Flight(
                "BT601",
                "Riga",
                "Istanbul",
                "11:00",
                "14:00",
                200));

        flights.add(new Flight(
                "BT602",
                "Istanbul",
                "Riga",
                "15:00",
                "18:00",
                200));

        flights.add(new Flight(
                "BT701",
                "Riga",
                "Dubai",
                "11:00",
                "18:30",
                350));

        flights.add(new Flight(
                "BT702",
                "Dubai",
                "Riga",
                "20:00",
                "03:30",
                350));
    }

    public List<Flight> getFlights() {
        return flights;
    }
}