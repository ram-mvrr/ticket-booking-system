package com.example.ticketbooking.user;

import com.example.ticketbooking.exception.ResourceNotFoundException;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public UserDTO registerUser(UserDTO userDTO){
        if (userDTO.getPassword() == null || userDTO.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        User user = userMapper.toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Map RoleDTOs to Roles using MapStruct
        Set<Role> roles = userMapper.mapRoles(userDTO.getRoles());

        // Validate and add roles if they exist in the repository
        Set<Role> validRoles = new LinkedHashSet<>();
        for(Role role : roles){
            Role foundRole = roleRepository.findByName(role.getName());
            if(foundRole!=null){
                validRoles.add(role);
            }else {
                System.out.println("role not found " + role.getName());
            }
        }
        // Set validated roles on the User entity
        user.setRoles(validRoles);

        // Save the User entity to the repository
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }
    public Optional<UserDTO> getUserById(Long userId){
        return userRepository.findById(userId).map(userMapper::toDTO);
    }
    public Optional<UserDTO> getUserByUsername(String username){
        return Optional.ofNullable(userRepository.findByUsername(username)).map(userMapper::toDTO);
    }
    @Transactional
    public void deleteUser(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Set<Role> roles = user.getRoles();
        for (Role role: roles) {
            role.getUsers().remove(user);// Assuming Role has Set<User> users mapping
            if(role.getUsers().isEmpty()){
                roleRepository.delete(role); // Delete role if no users are associated
            }else{
                roleRepository.save(role); // Update the role
            }
        }
        // Delete the user
        userRepository.deleteById(userId);
    }
    public UserDTO updateUser(Long userId, UserDTO userDTO) throws ResourceNotFoundException {
        User existingUser = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found with id"+userId));
        existingUser.setUsername(userDTO.getUsername());
        existingUser.setEmail(userDTO.getEmail());
        User updateUser = userRepository.save(existingUser);
        return userMapper.toDTO(updateUser);
    }
}
