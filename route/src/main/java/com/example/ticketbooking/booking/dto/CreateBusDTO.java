package com.example.ticketbooking.booking.dto;

import com.example.ticketbooking.booking.enums.BusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBusDTO {

    private String busNumber;

    private BusType busType;

    private Integer totalSeats;

    private Integer availableSeats;

    private BigDecimal farePerSeat;

    private Long routeId;
}
