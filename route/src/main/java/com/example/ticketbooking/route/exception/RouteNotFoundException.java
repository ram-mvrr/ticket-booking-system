package com.example.ticketbooking.route.exception;

public class RouteNotFoundException extends RuntimeException {
    public RouteNotFoundException(String message){
        super(message);
    }
}
