package com.example.ticketbooking.bus.service;


import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public interface BusService {

    Mono<BusDTO> createBus(CreateBusDTO createBusDTO);

    Optional<BusDTO> getBus(Long busId);

    List<BusDTO> getAllBuses();

    BusDTO updateBus(Long busId, UpdateBusDTO updateBusDTO);

    void deleteBus(Long busId);
}
