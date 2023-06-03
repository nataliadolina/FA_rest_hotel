package com.example.hotel.services;

import com.example.hotel.models.Client;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClientService extends BaseService<Client>{
}
