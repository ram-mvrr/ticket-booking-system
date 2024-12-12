package com.example.ticketbooking.booking.entity;

import com.example.ticketbooking.booking.enums.BusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "bus_table")
@AllArgsConstructor
@NoArgsConstructor
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busId;

    @Column(nullable = false, unique = true)
    private String busNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BusType busType;

    @Column(nullable = false)
    private Integer totalSeats;

    @Column(nullable = false)
    private Integer availableSeats;

    @Column(nullable = false)
    private BigDecimal farePerSeat;

    @Column(nullable = false)
    private Long routeId;
}
