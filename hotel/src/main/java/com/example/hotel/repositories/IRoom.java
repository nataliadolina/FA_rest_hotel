package com.example.hotel.repositories;

import com.example.hotel.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoom  extends JpaRepository<Room, Integer> {

}
