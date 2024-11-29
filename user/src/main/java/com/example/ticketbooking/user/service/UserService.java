package com.example.ticketbooking.user.service;

import com.example.ticketbooking.user.dto.CreateUserDTO;
import com.example.ticketbooking.user.dto.UpdateUserDTO;
import com.example.ticketbooking.user.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {


    public UserDTO registerUser(CreateUserDTO createUserDTO);

    public Optional<UserDTO> getUserById(Long userId);

    public Optional<UserDTO> getUserByUsername(String username);

    public void deleteUser(Long userId);

    public UserDTO updateUser(Long userId, UpdateUserDTO updateUserDTO);
}
