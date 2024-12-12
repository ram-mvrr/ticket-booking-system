package com.example.ticketbooking.seat.service;

import com.example.ticketbooking.seat.dto.SeatDTO;
import com.example.ticketbooking.seat.dto.CreateSeatDTO;
import com.example.ticketbooking.seat.dto.UpdateSeatDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SeatService {

    SeatDTO createSeat(CreateSeatDTO createSeatDTO);

    Optional<SeatDTO> getSeat(Long seatId);

    List<SeatDTO> getAllSeates();

    SeatDTO updateSeat(Long seatId, UpdateSeatDTO updateSeatDTO);

    void deleteSeat(Long seatId);
}
