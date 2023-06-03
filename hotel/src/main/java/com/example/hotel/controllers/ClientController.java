package com.example.hotel.controllers;

import com.example.hotel.models.Client;
import com.example.hotel.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel/clients")
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping("")
    public List<Client> allBookings(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public List<Client> booking(@PathVariable(value = "id") Integer id){
        return service.getById(id);
    }

    @PostMapping("")
    public void add(@RequestBody Client entity){
        service.saveEntity(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.deleteEntity(id);
    }
}
