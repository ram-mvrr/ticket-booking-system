package com.example.ticketbooking.shared.bus;

import com.example.ticketbooking.shared.enums.BusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBusDTO {

    private String busNumber;

    private BusType busType;

    private Integer totalSeats;

    private Long routeId;
}
