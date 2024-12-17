package com.example.ticketbooking.seat.controller;


import com.example.ticketbooking.seat.exception.SeatNotFoundException;
import com.example.ticketbooking.seat.service.SeatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {


    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping("/createSeat")
    public ResponseEntity<SeatDTO> createSeat(@RequestBody CreateSeatDTO createSeatDTO) {
        SeatDTO createdSeat = seatService.createSeat(createSeatDTO);
        return new ResponseEntity<>(createdSeat, HttpStatus.CREATED);
    }

    @GetMapping("/getSeat/{seatId}")
    public ResponseEntity<SeatDTO> getSeat(@PathVariable Long seatId) {
        SeatDTO seatDTO = seatService.getSeat(seatId).orElseThrow(() ->
                new SeatNotFoundException("Seat not found with ID "+seatId));
        return new ResponseEntity<>(seatDTO, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<SeatDTO> updateSeat(Long seatId, @RequestBody UpdateSeatDTO updateSeatDTO) {
        SeatDTO seatDTO = seatService.updateSeat(seatId, updateSeatDTO);
        return new ResponseEntity<>(seatDTO, HttpStatus.OK);
    }
    @DeleteMapping("/deleteSeat/{seatId}")
    public ResponseEntity<SeatDTO> deleteSeat(@PathVariable Long seatId) {
        seatService.deleteSeat(seatId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/getAllSeates")
    public ResponseEntity<List<SeatDTO>> getAllSeat() {
        List<SeatDTO> seatDTOS = seatService.getAllSeates();
        return new ResponseEntity<>(seatDTOS, HttpStatus.OK);
    }
}
