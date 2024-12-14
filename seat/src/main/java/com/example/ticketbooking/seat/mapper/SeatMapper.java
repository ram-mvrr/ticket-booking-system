package com.example.ticketbooking.seat.mapper;

import com.example.ticketbooking.shared.seat.*;
import com.example.ticketbooking.seat.entity.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SeatMapper {

    @Mapping(source = "seatId", target = "seatId")
    SeatDTO toSeatDTO(Seat seat);

    @Mapping(source = "seatId", target = "seatId")
    Seat toSeatEntity(SeatDTO seatDTO);

    Seat toSeatEntity(CreateSeatDTO createSeatDTO);

    @Mapping(source = "seatId", target = "seatId")
    Seat toSeatEntity(UpdateSeatDTO updateSeatDTO);
}
