package com.example.hotel.services;

import com.example.hotel.models.Booking;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookingService extends BaseService<Booking>{
}
