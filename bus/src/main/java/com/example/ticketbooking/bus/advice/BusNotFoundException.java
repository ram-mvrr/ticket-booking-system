package com.example.ticketbooking.bus.advice;

public class BusNotFoundException extends RuntimeException {
    public BusNotFoundException(String message){
        super(message);
    }
}
