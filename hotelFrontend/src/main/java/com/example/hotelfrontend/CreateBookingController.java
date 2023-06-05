package com.example.hotelfrontend;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CreateBookingController implements Initializable {

    @FXML
    private ChoiceBox<AdditionalServices> additional_services;

    @FXML
    private DatePicker arrival_date;

    @FXML
    private ChoiceBox<Client> client;

    @FXML
    private DatePicker departure_date;

    @FXML
    private TextField full_price;

    @FXML
    private ChoiceBox<Room> room;

    @FXML
    private Button toPrimaryButton;

    private Room[] allRooms;

    @FXML
    private void addonsChanged(){
        SetFullPrice();
    }

    @FXML
    private void roomChanged(){
        SetFullPrice();
    }

    @FXML
    void toPrimaryButtonPushed(ActionEvent event) throws IOException {
        BookingApplication.setRoot("primary");
    }

    private void SetFullPrice(){
        float price = 0;
        Room roomSelected = room.getValue();
        AdditionalServices addonsSelected = additional_services.getValue();
        if (roomSelected != null){
            price += roomSelected.price;
        }

        if (addonsSelected != null){
            price += addonsSelected.price;
        }

        full_price.setText(Float.toString(price));
    }
    @FXML
    void onArrivalDateChanged(ActionEvent event) {
        SetAvailableRoomsList();
    }

    @FXML
    void onDepartureDateChanged(ActionEvent event) {
        SetAvailableRoomsList();
    }

    private void SetAvailableRoomsList(){
        room.getItems().clear();
        LocalDate localDateArrival = arrival_date.getValue();
        LocalDate localDepartureDate = departure_date.getValue();

        if (localDateArrival == null || localDepartureDate == null){
            return;
        }

        Date arrivalDate = new Date(localDateArrival.getYear(), localDateArrival.getMonthValue() - 1, localDateArrival.getDayOfMonth());
        Date departureDate = new Date(localDepartureDate.getYear(), localDateArrival.getMonthValue() - 1, localDepartureDate.getDayOfMonth());

        Booking[] booking = BookingApplication.requests.getBookings();

        try{
            List<Integer> busy_rooms_ides = (List<Integer>) Arrays.stream(booking)
                    .filter(x ->
                            (x.departure_date.before(departureDate) || x.departure_date.getDate() == departureDate.getDate())
                                    && (x.arrival_date.after(arrivalDate)) || x.arrival_date.getDate() == arrivalDate.getDate())
                    .map(x -> x.room.id).toList();

            List<Room> available_rooms = (List<Room>)Arrays.stream(allRooms)
                    .filter(x -> !busy_rooms_ides.contains(x.id))
                    .toList();
            room.getItems().addAll(available_rooms);
        } catch (Exception e) {
            room.getItems().addAll(allRooms);
        }
    }

    @FXML
    private void saveButtonPushed() throws UnirestException {
        Booking[] bookings = BookingApplication.requests.getBookings();

        Optional<Booking> optionalBooking = Arrays.stream(BookingApplication.requests.getBookings())
                .max(Comparator.comparing(Booking::id));
        Integer maxId = optionalBooking.map(Collections::singletonList).orElse(Collections.emptyList()).get(0).id;
        Booking booking = new Booking(
                maxId+1,
                room.getValue(),
                client.getValue(),
                localDateToDate(arrival_date.getValue()),
                localDateToDate(departure_date.getValue()),
                Float.valueOf(full_price.getText()),
                generateHashSet(additional_services.getValue()));
        BookingApplication.requests.SaveBooking(booking);
    }

    private Date localDateToDate(LocalDate localDate){
        return new Date(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
    }

    private Set<AdditionalServices> generateHashSet(AdditionalServices additionalServices){
        List<AdditionalServices> lst = new ArrayList<AdditionalServices>();
        lst.add(additionalServices);
        return new HashSet<AdditionalServices>(lst);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allRooms = BookingApplication.requests.getRooms();

        ObservableList<Client> allClients = FXCollections.observableArrayList(BookingApplication.requests.getClients());
        ObservableList<AdditionalServices> allAdditionalServices = FXCollections.observableArrayList(BookingApplication.requests.getAdditionalServices());

        client.setItems(allClients);
        additional_services.setItems(allAdditionalServices);
    }
}