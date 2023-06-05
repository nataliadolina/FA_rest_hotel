package com.example.hotel.services;
import com.example.hotel.models.Room;
import com.example.hotel.repositories.IRoom;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class BaseService<TModel> {
    @Autowired
    private JpaRepository<TModel, Integer> repo;

    public List<TModel> getAll(){
        return repo.findAll();
    }

    public TModel getById(Integer id){
        Optional<TModel> opt = repo.findById(id);
        List<TModel> res = new ArrayList<>();
        opt.ifPresent(res::add);
        return res.get(0);
    }

    public void saveEntity(TModel entity){
        repo.save(entity);
    }

    public void deleteEntity(Integer id){
        repo.deleteById(id);
    }
}
