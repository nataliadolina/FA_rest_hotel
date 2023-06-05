package com.example.hotel.models;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonSerialize
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    @JsonSerialize
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @JsonSerialize
    private Client client;

    @JsonSerialize
    private Date arrival_date;
    @JsonSerialize
    private Date departure_date;
    @JsonSerialize
    private Float full_price;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "additional_services_id", referencedColumnName = "id")
    @JsonSerialize
    private Set<AdditionalServices> additional_services;
}
