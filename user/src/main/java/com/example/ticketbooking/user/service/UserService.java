package com.example.ticketbooking.user.service;



import com.example.ticketbooking.shared.user.CreateUserDTO;
import com.example.ticketbooking.shared.user.UpdateUserDTO;
import com.example.ticketbooking.shared.user.UserDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {


    UserDTO registerUser(CreateUserDTO createUserDTO);

    Optional<UserDTO> getUserById(Long userId);

    Optional<UserDTO> getUserByUsername(String username);

    void deleteUser(Long userId);

    UserDTO updateUser(Long userId, UpdateUserDTO updateUserDTO);
}
