package com.example.hotel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String type_room;

    private Integer number;

    private Integer floor;

    private Float price;

    @JsonIgnore
    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Booking> booking;
}
