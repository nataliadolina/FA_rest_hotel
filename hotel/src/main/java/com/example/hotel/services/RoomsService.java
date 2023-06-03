package com.example.hotel.services;

import com.example.hotel.models.Room;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoomsService extends BaseService<Room> {

}
