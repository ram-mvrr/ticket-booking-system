package com.example.ticketbooking.booking.service;

import com.example.ticketbooking.shared.booking.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookingService {

    BookingDTO createBooking(CreateBookingDTO createBookingDTO);

    Optional<BookingDTO> getBooking(Long bookingId);

    List<BookingDTO> getAllBookinges();

    BookingDTO updateBooking(Long bookingId, UpdateBookingDTO updateBookingDTO);

    void deleteBooking(Long bookingId);
}
