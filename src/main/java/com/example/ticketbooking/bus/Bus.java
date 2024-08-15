package com.example.ticketbooking.bus;

import com.example.ticketbooking.route.Route;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long busId;
    @Column(nullable = false, unique = true)
    private String busNumber;
    @Column(name = "bus_type")
    private String busType;
    @Column
    private Integer capacity;
    @Column
    private String model;
    @Column
    private String manufacturer;

    @ManyToMany
    @JoinTable(
            name="bus_routes",
            joinColumns = @JoinColumn(name="bus_id"),
            inverseJoinColumns = @JoinColumn(name="route_id")
    )
    private Set<Route> routes;
}
