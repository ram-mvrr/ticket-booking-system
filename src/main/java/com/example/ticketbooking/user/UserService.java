package com.example.ticketbooking.user;

import com.example.ticketbooking.exception.ResourceNotFoundException;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
        User user = userMapper.toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        userDTO.getRoles().forEach(roleName -> {
                    Role role = roleRepository.findByName(roleName);
                    if(role!=null){
                        roles.add(role);
                    }
                });
        user.setRoles(roles);

        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }
    public Optional<UserDTO> getUserById(Long id){
        return userRepository.findById(id).map(userMapper::toDTO);
    }
    public Optional<UserDTO> getUserByUsername(String username){
        return Optional.ofNullable(userRepository.findByUsername(username)).map(userMapper::toDTO);
    }
    public void deleteUse(Long id){
        userRepository.deleteById(id);
    }
    public UserDTO updateUser(Long id, UserDTO userDTO) throws ResourceNotFoundException {
        User existingUser = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("user not found with id"+id));
        existingUser.setUsername(userDTO.getUsername());
        existingUser.setEmail(userDTO.getEmail());
        User updateUser = userRepository.save(existingUser);
        return userMapper.toDTO(updateUser);
    }





}
