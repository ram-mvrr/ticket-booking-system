package com.example.ticketbooking.seat.dto;

import com.example.ticketbooking.seat.enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSeatDTO {

    private Long busId;

    private Integer seatNumber;

    private SeatType seatType;

    private Integer availableSeats;

    private BigDecimal farePerSeat;

    private Long routeId;

    private Long bookingId;
}
