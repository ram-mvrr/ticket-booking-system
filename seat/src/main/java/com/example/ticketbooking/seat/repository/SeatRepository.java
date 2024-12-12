package com.example.ticketbooking.seat.repository;

import com.example.ticketbooking.seat.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

}
