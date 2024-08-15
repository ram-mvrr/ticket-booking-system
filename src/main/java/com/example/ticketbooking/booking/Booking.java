package com.example.ticketbooking.booking;

import com.example.ticketbooking.payment.Payment;
import com.example.ticketbooking.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private LocalDateTime bookingDate;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private User user;

    @OneToOne(mappedBy = "booking")
    private Payment payment;
}
