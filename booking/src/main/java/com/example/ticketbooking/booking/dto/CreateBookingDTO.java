package com.example.ticketbooking.booking.dto;

import com.example.ticketbooking.booking.enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBookingDTO {

    private Long seatId;

    private BookingStatus bookingStatus;

    private LocalDateTime bookingDate;

    private Long busId;

    private Long userId;
}
