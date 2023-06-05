package com.example.hotel.controllers;

import com.example.hotel.models.Room;
import com.example.hotel.services.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel/rooms")
public class RoomsController {
    @Autowired
    private RoomsService service;

    @GetMapping("")
    public List<Room> allRooms(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Room room(@PathVariable(value = "id") Integer id){
        return service.getById(id);
    }

    @PostMapping("")
    public void add(@RequestBody Room entity){
        service.saveEntity(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.deleteEntity(id);
    }
}
