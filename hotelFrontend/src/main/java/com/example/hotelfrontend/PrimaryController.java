package com.example.hotelfrontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {
    @FXML
    private ListView<Booking> bookings;

    @FXML
    private Button newBooking;

    @FXML
    void onNewBookingButtonPushed(ActionEvent event) throws IOException {
        BookingApplication.setRoot("create_booking-view");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Booking[] bookingsData = BookingApplication.requests.getBookings();
        bookings.getItems().clear();
        bookings.getItems().addAll(bookingsData);
    }
}
