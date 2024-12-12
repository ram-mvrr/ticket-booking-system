package com.example.ticketbooking.booking.mapper;

import com.example.ticketbooking.booking.dto.BusDTO;
import com.example.ticketbooking.booking.dto.CreateBusDTO;
import com.example.ticketbooking.booking.dto.UpdateBusDTO;
import com.example.ticketbooking.booking.entity.Bus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BusMapper {

    @Mapping(source = "busId", target = "busId")
    BusDTO toBusDTO(Bus bus);

    @Mapping(source = "busId", target = "busId")
    Bus toBusEntity(BusDTO busDTO);

    Bus toBusEntity(CreateBusDTO createBusDTO);

    @Mapping(source = "busId", target = "busId")
    Bus toBusEntity(UpdateBusDTO updateBusDTO);






}
