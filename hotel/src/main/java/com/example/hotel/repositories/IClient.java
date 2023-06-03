package com.example.hotel.repositories;

import com.example.hotel.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClient  extends JpaRepository<Client, Integer> {
}
