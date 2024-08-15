package com.example.ticketbooking.payment;

import com.example.ticketbooking.booking.Booking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private Double amount;

    private LocalDateTime paymentDate;

    private String paymentMethod;

    @OneToOne(mappedBy = "booking")
    private Booking booking;
}
