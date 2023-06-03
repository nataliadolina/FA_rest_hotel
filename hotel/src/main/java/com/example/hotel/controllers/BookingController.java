package com.example.hotel.controllers;

import com.example.hotel.models.Booking;
import com.example.hotel.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel/bookings")
public class BookingController {
    @Autowired
    private BookingService service;

    @GetMapping("")
    public List<Booking> allBookings(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public List<Booking> booking(@PathVariable(value = "id") Integer id){
        return service.getById(id);
    }

    @PostMapping("")
    public void add(@RequestBody Booking entity){
        service.saveEntity(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.deleteEntity(id);
    }
}
