package com.example.hotel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class AdditionalServices {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonSerialize
    private Integer id;

    @JsonSerialize
    private String name;

    @JsonSerialize
    private Float price;

    @JsonIgnore
    @ManyToMany(mappedBy = "additional_services", cascade = CascadeType.REMOVE)
    private Set<Booking> booking;
}
