package repository;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class SeatFileRepository {

    private static final String FILE_NAME =
            "reservedSeats.txt";

    public void saveSeat(
            String flightNumber,
            String seat) {

        if (isSeatReserved(
                flightNumber,
                seat)) {

            return;
        }

        try (FileWriter writer =
                     new FileWriter(
                             FILE_NAME,
                             true)) {

            writer.write(
                    flightNumber
                            + ";"
                            + seat
                            + "\n");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public Set<String> loadSeats(
            String flightNumber) {

        Set<String> seats =
                new HashSet<>();

        File file =
                new File(FILE_NAME);

        if (!file.exists()) {
            return seats;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(file))) {

            String line;

            while ((line =
                    reader.readLine()) != null) {

                String[] parts =
                        line.split(";");

                if (parts.length == 2
                        && parts[0].equals(
                        flightNumber)) {

                    seats.add(parts[1]);
                }
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        return seats;
    }

    public boolean isSeatReserved(
            String flightNumber,
            String seat) {

        return loadSeats(
                flightNumber)
                .contains(seat);
    }
}