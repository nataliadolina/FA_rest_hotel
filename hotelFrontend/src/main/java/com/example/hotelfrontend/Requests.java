package com.example.hotelfrontend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Requests {

    private final ObjectMapper objectMapper;
    private final StringWriter stringWriter;

    private final String rootUrl = "http://localhost:8080/hotel/";

    public Requests() {
        objectMapper = new ObjectMapper();
        stringWriter = new StringWriter();
    }

    public Room[] getRooms() {
        String roomHttpResponse;
        try {
            roomHttpResponse = GetResponse("rooms");
        }  catch (UnirestException e) {
            System.out.println("Response error");
            return new Room[]{};
        }

        Room[] result;

        try {
            result = objectMapper.readValue(roomHttpResponse, Room[].class);
        } catch (JsonProcessingException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new Room[]{};
        }

        return result;
    }

    public Client[] getClients() {
        String clientHttpResponse;
        try {
            clientHttpResponse = GetResponse("clients");
        }  catch (UnirestException e) {
            System.out.println("Response error");
            return new Client[]{};
        }

        Client[] result;

        try {
            result = objectMapper.readValue(clientHttpResponse, Client[].class);
        } catch (JsonProcessingException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new Client[]{};
        }

        return result;
    }

    public Booking[] getBookings() {
        String bookingHttpResponse;
        try {
            bookingHttpResponse = GetResponse("bookings");
        }  catch (UnirestException e) {
            System.out.println("Response error");
            return new Booking[]{};
        }

        Booking[] result;

        try {
            result = objectMapper.readValue(bookingHttpResponse, Booking[].class);
        } catch (JsonProcessingException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new Booking[]{};
        }

        System.out.println(result.length);
        return result;
    }

    public AdditionalServices[] getAdditionalServices(){
        String httpResponse;
        try {
            httpResponse = GetResponse("addons");
        }  catch (UnirestException e) {
            System.out.println("Response error");
            return new AdditionalServices[]{};
        }

        AdditionalServices[] result;

        try {
            result = objectMapper.readValue(httpResponse, AdditionalServices[].class);
        } catch (JsonProcessingException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new AdditionalServices[]{};
        }

        return result;
    }

    public void SaveBooking(Booking booking) throws UnirestException {
        String json;
        try {
            objectMapper.writeValue(stringWriter, booking);
            json = stringWriter.toString();
            System.out.println(json);
        } catch (IOException e){
            e.printStackTrace();
            return;
        }

        HttpResponse<JsonNode> response = Unirest.post(rootUrl + "bookings")
                .header("content-type", "application/json; charset=UTF-8")
                .body(json)
                .asJson();
        System.out.println(response.getBody().toString());
    }

    private String GetResponse(String url) throws UnirestException{
        return Unirest.get(rootUrl + url).asJson().getBody().toString();
    }
}
