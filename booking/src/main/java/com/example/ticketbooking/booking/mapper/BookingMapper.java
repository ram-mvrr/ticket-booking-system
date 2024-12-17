package com.example.ticketbooking.booking.mapper;


import com.example.ticketbooking.booking.entity.Booking;
import com.trucare.ticketbooking.shared.booking.BookingDTO;
import com.trucare.ticketbooking.shared.booking.CreateBookingDTO;
import com.trucare.ticketbooking.shared.booking.UpdateBookingDTO;
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
