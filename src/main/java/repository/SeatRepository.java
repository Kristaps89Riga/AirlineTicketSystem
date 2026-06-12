package repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SeatRepository {

    private static final Map<String, Set<String>>
            reservedSeats = new HashMap<>();

    public static boolean isReserved(
            String flightNumber,
            String seat) {

        return reservedSeats
                .getOrDefault(
                        flightNumber,
                        new HashSet<>())
                .contains(seat);
    }

    public static void reserveSeat(
            String flightNumber,
            String seat) {

        reservedSeats
                .computeIfAbsent(
                        flightNumber,
                        k -> new HashSet<>())
                .add(seat);
    }
}