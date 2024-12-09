package com.example.ticketbooking.bus.exception;

public class BusNotFoundException extends RuntimeException {
    public BusNotFoundException(String message){
        super(message);
    }
}
