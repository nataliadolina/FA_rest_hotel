package com.example.hotel.repositories;

import com.example.hotel.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBooking extends JpaRepository<Booking, Integer> {
}
