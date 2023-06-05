package com.example.hotel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonSerialize
    private Integer id;

    @JsonSerialize
    private String type_room;

    @JsonSerialize
    private Integer number;

    @JsonSerialize
    private Integer floor;

    @JsonSerialize
    private Float price;

    @JsonIgnore
    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Booking> booking;
}
