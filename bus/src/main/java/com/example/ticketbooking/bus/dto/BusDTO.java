package com.example.ticketbooking.bus.dto;

import com.example.ticketbooking.bus.enums.BusType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;

public class BusDTO {

    private Long busId;

    private String busNumber;

    private BusType busType;

    private Integer totalSeats;

    private Integer availableSeats;

    private BigDecimal farePerSeat;

    private Long routeId;
}
