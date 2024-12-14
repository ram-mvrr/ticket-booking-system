package com.example.ticketbooking.route.controller;

import com.example.ticketbooking.shared.route.*;
import com.example.ticketbooking.route.exception.RouteNotFoundException;
import com.example.ticketbooking.route.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/route")
public class RouteController {


    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/createRoute")
    public ResponseEntity<RouteDTO> createRoute(@RequestBody CreateRouteDTO createRouteDTO) {
        RouteDTO createdRoute = routeService.createRoute(createRouteDTO);
        return new ResponseEntity<>(createdRoute, HttpStatus.CREATED);
    }

    @GetMapping("/getRoute/{routeId}")
    public ResponseEntity<RouteDTO> getRoute(@PathVariable Long routeId) {
        RouteDTO routeDTO = routeService.getRoute(routeId).orElseThrow(() ->
                new RouteNotFoundException("Route not found with ID "+routeId));
        return new ResponseEntity<>(routeDTO, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<RouteDTO> updateRoute(Long routeId, @RequestBody UpdateRouteDTO updateRouteDTO) {
        RouteDTO routeDTO = routeService.updateRoute(routeId, updateRouteDTO);
        return new ResponseEntity<>(routeDTO, HttpStatus.OK);
    }
    @DeleteMapping("/deleteRoute/{routeId}")
    public ResponseEntity<RouteDTO> deleteRoute(@PathVariable Long routeId) {
        routeService.deleteRoute(routeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/getAllRoutees")
    public ResponseEntity<List<RouteDTO>> getAllRoute() {
        List<RouteDTO> routeDTOS = routeService.getAllRoutees();
        return new ResponseEntity<>(routeDTOS, HttpStatus.OK);
    }
}
