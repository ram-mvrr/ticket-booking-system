package com.example.ticketbooking.booking.dto;

import com.example.ticketbooking.booking.enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookingDTO {

    private Long bookingId;

    private Long seatId;

    private BookingStatus bookingStatus;

    private LocalDateTime bookingDate;

    private Long busID;

    private Long userId;
}
