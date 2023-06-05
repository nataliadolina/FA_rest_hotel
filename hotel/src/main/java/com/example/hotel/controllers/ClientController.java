package com.example.hotel.controllers;

import com.example.hotel.models.Client;
import com.example.hotel.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel/clients")
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping("")
    public ResponseEntity<List<Client>> allClients(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> client(@PathVariable(value = "id") Integer id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
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
