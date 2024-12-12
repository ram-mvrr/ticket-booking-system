package com.example.ticketbooking.seat.entity;

import com.example.ticketbooking.seat.enums.SeatType;
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
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busId;

    @Column(nullable = false, unique = true)
    private Integer seatNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @Column(nullable = false)
    private Integer availableSeats;

    @Column(nullable = false)
    private BigDecimal farePerSeat;

    @Column(nullable = false)
    private Long routeId;

    @Column(nullable = false)
    private Long bookingId;
}
