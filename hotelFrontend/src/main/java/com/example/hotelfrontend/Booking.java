package com.example.hotelfrontend;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

public class Booking {
    public Integer id;
    public Room room;
    public Client client;
    public Date arrival_date;
    public Date departure_date;
    public Float full_price;
    public Set<AdditionalServices> additional_services;

    public Booking(){}

    public Booking(Integer id, Room room, Client client, Date arrival_date, Date departure_date, Float full_price, Set<AdditionalServices> additional_services) {
        this.id = id;
        this.room = room;
        this.client = client;
        this.arrival_date = arrival_date;
        this.departure_date = departure_date;
        this.full_price = full_price;
        this.additional_services = additional_services;
    }

    public Integer id() {
        return this.id;
    }

    public Room room() {
        return this.room;
    }

    public Client client() {
        return this.client;
    }

    public Date arrival_date() {
        return this.arrival_date;
    }

    public Date departure_date() {
        return this.departure_date;
    }

    public Float full_price() {
        return this.full_price;
    }

    @Override
    public String toString(){
        String addonsStr = additional_services.stream().map(AdditionalServices::toString).collect(Collectors.joining("\\n"));
        String result;
        try{
            result = String.format("Room - %s, client - %s \\n Arrival date - %s, departure date - %s \\n Additional services: \\n %s \\n Full price - %f",
                    room.toString(), client.toString(), arrival_date.toString(), departure_date.toString(), addonsStr, full_price);
        } catch (Exception e) {
            result = "Object with id " + id + " cannot be converted to String because of null values.";
        }

        return result;
    }
}
