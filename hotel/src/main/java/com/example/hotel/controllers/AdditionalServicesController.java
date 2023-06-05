package com.example.hotel.controllers;

import com.example.hotel.models.AdditionalServices;
import com.example.hotel.services.AdditionalServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel/addons")
public class AdditionalServicesController {
    @Autowired
    private AdditionalServicesService service;

    @GetMapping("")
    public List<AdditionalServices> allAdditionalServices(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public AdditionalServices additionalService(@PathVariable(value = "id") Integer id){
        return service.getById(id);
    }

    @PostMapping("")
    public void add(@RequestBody AdditionalServices entity){
        service.saveEntity(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.deleteEntity(id);
    }
}
