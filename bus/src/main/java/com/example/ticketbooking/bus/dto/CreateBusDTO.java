package com.example.ticketbooking.bus.dto;

import com.example.ticketbooking.bus.enums.BusType;
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

    private Long routeId;
}
