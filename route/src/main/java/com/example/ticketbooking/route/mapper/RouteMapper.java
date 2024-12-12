package com.example.ticketbooking.route.mapper;

import com.example.ticketbooking.route.dto.RouteDTO;
import com.example.ticketbooking.route.dto.CreateRouteDTO;
import com.example.ticketbooking.route.dto.UpdateRouteDTO;
import com.example.ticketbooking.route.entity.Route;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RouteMapper {

    @Mapping(source = "routeId", target = "routeId")
    RouteDTO toRouteDTO(Route route);

    @Mapping(source = "routeId", target = "routeId")
    Route toRouteEntity(RouteDTO routeDTO);

    Route toRouteEntity(CreateRouteDTO createRouteDTO);

    @Mapping(source = "routeId", target = "routeId")
    Route toRouteEntity(UpdateRouteDTO updateRouteDTO);






}
