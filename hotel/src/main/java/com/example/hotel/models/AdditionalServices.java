package com.example.hotel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class AdditionalServices {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;
    private String price;

    @JsonIgnore
    @ManyToMany(mappedBy = "additional_services", cascade = CascadeType.REMOVE)
    private Set<Booking> booking;
}
