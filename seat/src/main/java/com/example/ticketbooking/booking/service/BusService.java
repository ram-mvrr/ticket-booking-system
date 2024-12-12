package com.example.ticketbooking.booking.service;

import com.example.ticketbooking.booking.dto.BusDTO;
import com.example.ticketbooking.booking.dto.CreateBusDTO;
import com.example.ticketbooking.booking.dto.UpdateBusDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BusService {

    BusDTO createBus(CreateBusDTO createBusDTO);

    Optional<BusDTO> getBus(Long busId);

    List<BusDTO> getAllBuses();

    BusDTO updateBus(Long busId, UpdateBusDTO updateBusDTO);

    void deleteBus(Long busId);
}
