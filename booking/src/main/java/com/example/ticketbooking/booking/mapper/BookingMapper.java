package com.example.ticketbooking.booking.mapper;

import com.example.ticketbooking.booking.dto.BookingDTO;
import com.example.ticketbooking.booking.dto.CreateBookingDTO;
import com.example.ticketbooking.booking.dto.UpdateBookingDTO;
import com.example.ticketbooking.booking.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    @Mapping(source = "bookingId", target = "bookingId")
    BookingDTO toBookingDTO(Booking booking);

    @Mapping(source = "bookingId", target = "bookingId")
    Booking toBookingEntity(BookingDTO bookingDTO);

    Booking toBookingEntity(CreateBookingDTO createBookingDTO);

    @Mapping(source = "bookingId", target = "bookingId")
    Booking toBookingEntity(UpdateBookingDTO updateBookingDTO);

}
