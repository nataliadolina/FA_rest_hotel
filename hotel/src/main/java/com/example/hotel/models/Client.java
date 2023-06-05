package com.example.hotel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonSerialize
    private Integer id;

    @JsonSerialize
    private String name;

    @JsonSerialize
    private String surname;

    @JsonSerialize
    private String patronymic;

    @JsonIgnore
    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Booking> booking;
}
