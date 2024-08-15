package com.example.ticketbooking.user;

import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long userId;
    private String username;
    private String email;

    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Set<RoleDTO> roles = new LinkedHashSet<>();
}
