package com.example.hotel.models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    private Date arrival_date;
    private Date departure_date;
    private Float full_price;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "additional_services_id", referencedColumnName = "id")
    private Set<AdditionalServices> additional_services;
}
