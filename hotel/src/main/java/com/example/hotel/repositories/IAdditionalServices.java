package com.example.hotel.repositories;

import com.example.hotel.models.AdditionalServices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdditionalServices  extends JpaRepository<AdditionalServices, Integer> {
}
