package com.example.ticketbooking.bus.mapper;

import com.example.ticketbooking.bus.dto.BusDTO;
import com.example.ticketbooking.bus.dto.CreateBusDTO;
import com.example.ticketbooking.bus.dto.UpdateBusDTO;
import com.example.ticketbooking.bus.entity.Bus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BusMapper {

    @Mapping(source = "busId", target = "busId")
    BusDTO toBusDTO(Bus bus);

    @Mapping(source = "busId", target = "busId")
    Bus toBusEntity(BusDTO busDTO);

    Bus toBusEntity(CreateBusDTO createBusDTO);

    @Mapping(source = "busId", target = "busId")
    Bus toBusEntity(UpdateBusDTO updateBusDTO);






}
