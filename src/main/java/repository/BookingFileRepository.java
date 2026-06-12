package repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookingFileRepository {

    private static final String FILE_NAME =
            "bookings.txt";

    public void saveBooking(
            String passenger,
            String flight,
            String seat,
            double price) {

        try (FileWriter writer =
                     new FileWriter(
                             FILE_NAME,
                             true)) {

            writer.write(
                    "Passenger: " + passenger + "\n");

            writer.write(
                    "Flight: " + flight + "\n");

            writer.write(
                    "Seat: " + seat + "\n");

            writer.write(
                    "Price: " + price + " EUR\n");

            writer.write(
                    "----------------------------------\n");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public List<String> loadBookings() {

        List<String> bookings =
                new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                bookings.add(line);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        return bookings;
    }
}