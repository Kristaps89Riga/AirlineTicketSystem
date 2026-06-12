package org.example;

import gui.MainMenuFrame;
import repository.BookingFileRepository;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        BookingFileRepository repository =
                new BookingFileRepository();

        System.out.println(
                "Saved bookings:"
        );

        for (String line :
                repository.loadBookings()) {

            System.out.println(line);
        }

        SwingUtilities.invokeLater(() -> {

            MainMenuFrame menu =
                    new MainMenuFrame();

            menu.setVisible(true);
        });
    }
}