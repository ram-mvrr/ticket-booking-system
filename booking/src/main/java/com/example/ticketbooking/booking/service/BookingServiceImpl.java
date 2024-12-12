package com.example.ticketbooking.booking.service;

import com.example.ticketbooking.booking.entity.Booking;
import com.example.ticketbooking.booking.exception.BookingNotFoundException;
import com.example.ticketbooking.booking.dto.BookingDTO;
import com.example.ticketbooking.booking.dto.CreateBookingDTO;
import com.example.ticketbooking.booking.dto.UpdateBookingDTO;
import com.example.ticketbooking.booking.mapper.BookingMapper;
import com.example.ticketbooking.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final WebClient webClient;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper, WebClient webClient) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.webClient = webClient;
    }


    @Override
    public Mono<BookingDTO> createBooking(CreateBookingDTO createBookingDTO) {

        // Fetch User and Bus details.
        Mono<UserDTO>


        Booking booking = bookingMapper.toBookingEntity(createBookingDTO);

        Booking savedBooking = bookingRepository.save(booking);

        return bookingMapper.toBookingDTO(savedBooking);
    }

    @Override
    public Optional<BookingDTO> getBooking(Long bookingId) {
        return bookingRepository.findById(bookingId).map(bookingMapper::toBookingDTO);
    }

    @Override
    public List<BookingDTO> getAllBookinges() {
        return bookingRepository.findAll().stream().map(bookingMapper::toBookingDTO).toList();
    }

    @Override
    public BookingDTO updateBooking(Long bookingId, UpdateBookingDTO updateBookingDTO) {
        Booking existingBooking = bookingRepository.findById(bookingId)
                        .orElseThrow(() -> new BookingNotFoundException("booking not found with id "+bookingId));
        Optional.ofNullable(updateBookingDTO.getBookingStatus()).ifPresent(existingBooking::setBookingStatus);
        Optional.ofNullable(updateBookingDTO.getBookingDate()).ifPresent(existingBooking::setBookingDate);
        Optional.ofNullable(updateBookingDTO.getBusID()).ifPresent(existingBooking::setBusId);
        Optional.ofNullable(updateBookingDTO.getSeatId()).ifPresent(existingBooking::setSeatId);
        Optional.ofNullable(updateBookingDTO.getUserId()).ifPresent(existingBooking::setUserId);

        return bookingMapper.toBookingDTO(existingBooking);
    }

    @Override
    public void deleteBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
