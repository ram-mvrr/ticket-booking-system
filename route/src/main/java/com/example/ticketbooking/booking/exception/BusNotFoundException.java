package com.example.ticketbooking.booking.exception;

public class BusNotFoundException extends RuntimeException {
    public BusNotFoundException(String message){
        super(message);
    }
}
