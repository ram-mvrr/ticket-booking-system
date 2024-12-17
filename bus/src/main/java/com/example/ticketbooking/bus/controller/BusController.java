package com.example.ticketbooking.bus.controller;

import com.example.ticketbooking.bus.exception.BusNotFoundException;
import com.example.ticketbooking.bus.service.BusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {


    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @PostMapping("/createBus")
    public ResponseEntity<BusDTO> createBus(@RequestBody CreateBusDTO createBusDTO) {
        BusDTO createdBus = busService.createBus(createBusDTO);
        return new ResponseEntity<>(createdBus, HttpStatus.CREATED);
    }

    @GetMapping("/getBus/{busId}")
    public ResponseEntity<BusDTO> getBus(@PathVariable Long busId) {
        BusDTO busDTO = busService.getBus(busId).orElseThrow(() ->
                new BusNotFoundException("Bus not found with ID "+busId));
        return new ResponseEntity<>(busDTO, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<BusDTO> updateBus(Long busId, @RequestBody UpdateBusDTO updateBusDTO) {
        BusDTO busDTO = busService.updateBus(busId, updateBusDTO);
        return new ResponseEntity<>(busDTO, HttpStatus.OK);
    }
    @DeleteMapping("/deleteBus/{busId}")
    public ResponseEntity<BusDTO> deleteBus(@PathVariable Long busId) {
        busService.deleteBus(busId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/getAllBuses")
    public ResponseEntity<List<BusDTO>> getAllBus() {
        List<BusDTO> busDTOS = busService.getAllBuses();
        return new ResponseEntity<>(busDTOS, HttpStatus.OK);
    }
}
