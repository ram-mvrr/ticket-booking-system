package com.example.ticketbooking.shared.booking;

import com.example.ticketbooking.shared.enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDTO {

    private Long bookingId;

    private Long seatId;

    private BookingStatus bookingStatus;

    private LocalDateTime bookingDate;

    private Long busId;

    private Long userId;
}
