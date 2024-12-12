package com.example.ticketbooking.route.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateRouteDTO {

    private String source;

    private String destination;

    private Double distance;

    private Long busId;
}
