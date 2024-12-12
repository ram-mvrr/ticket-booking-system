package com.example.ticketbooking.booking.service;

import com.example.ticketbooking.booking.exception.BusNotFoundException;
import com.example.ticketbooking.booking.dto.BusDTO;
import com.example.ticketbooking.booking.dto.CreateBusDTO;
import com.example.ticketbooking.booking.dto.UpdateBusDTO;
import com.example.ticketbooking.booking.entity.Bus;
import com.example.ticketbooking.booking.mapper.BusMapper;
import com.example.ticketbooking.booking.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {

    private final BusRepository busRepository;
    private final BusMapper busMapper;

    @Autowired
    public BusServiceImpl(BusRepository busRepository, BusMapper busMapper) {
        this.busRepository = busRepository;
        this.busMapper = busMapper;
    }


    @Override
    public BusDTO createBus(CreateBusDTO createBusDTO) {
        Bus bus = busMapper.toBusEntity(createBusDTO);

        Bus savedBus = busRepository.save(bus);

        return busMapper.toBusDTO(savedBus);
    }

    @Override
    public Optional<BusDTO> getBus(Long busId) {
        return busRepository.findById(busId).map(busMapper::toBusDTO);
    }

    @Override
    public List<BusDTO> getAllBuses() {
        return busRepository.findAll().stream().map(busMapper::toBusDTO).toList();
    }

    @Override
    public BusDTO updateBus(Long busId, UpdateBusDTO updateBusDTO) {
        Bus existingUser = busRepository.findById(busId)
                        .orElseThrow(() -> new BusNotFoundException("bus not found with id "+busId));
        Optional.ofNullable(updateBusDTO.getBusType()).ifPresent(existingUser::setBusType);
        Optional.ofNullable(updateBusDTO.getBusNumber()).ifPresent(existingUser::setBusNumber);
        Optional.ofNullable(updateBusDTO.getAvailableSeats()).ifPresent(existingUser::setAvailableSeats);
        Optional.ofNullable(updateBusDTO.getTotalSeats()).ifPresent(existingUser::setTotalSeats);
        Optional.ofNullable(updateBusDTO.getFarePerSeat()).ifPresent(existingUser::setFarePerSeat);
        Optional.ofNullable(updateBusDTO.getRouteId()).ifPresent(existingUser::setRouteId);

        return busMapper.toBusDTO(existingUser);
    }

    @Override
    public void deleteBus(Long busId) {
        busRepository.deleteById(busId);
    }
}
