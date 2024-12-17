package com.example.ticketbooking.shared.bus;

import com.example.ticketbooking.shared.enums.BusType;
import com.example.ticketbooking.shared.route.RouteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusDTO {

    private Long busId;

    private String busNumber;

    private BusType busType;

    private Integer totalSeats;

    private Long routeId;

    private RouteDTO routeDetails;
}
