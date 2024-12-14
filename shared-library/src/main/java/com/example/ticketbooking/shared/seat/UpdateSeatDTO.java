package com.example.ticketbooking.shared.seat;

import com.example.ticketbooking.shared.enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSeatDTO {

    private Long seatId;

    private Integer seatNumber;

    private SeatType seatType;

    private Integer availableSeats;

    private BigDecimal farePerSeat;

    private boolean isAvailable;

    private Long busId;

    private Long bookingId;
}
