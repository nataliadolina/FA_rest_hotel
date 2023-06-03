package com.example.hotel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    private String surname;

    private String patronymic;

    @JsonIgnore
    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Booking> booking;
}
