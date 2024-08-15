package com.example.ticketbooking.route;

import com.example.ticketbooking.bus.Bus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;
    private String origin;
    private String destination;

    private Double distance;

    private Integer duration;

    @ManyToMany(mappedBy = "routes")
    private Set<Bus> buses;

}
