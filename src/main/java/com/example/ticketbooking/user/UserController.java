package com.example.ticketbooking.user;

import com.example.ticketbooking.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO createdUser = userService.registerUser(userDTO);
        return ResponseEntity.ok(createdUser);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserDTO>> getUserById(@PathVariable Long id){
        Optional<UserDTO> userDTO = userService.getUserById(id);
        if(userDTO == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userDTO);

    }

    @GetMapping("/{name}")
    public ResponseEntity<Optional<UserDTO>> getUserByName(@PathVariable String username){
        Optional<UserDTO> userDTO = userService.getUserByUsername(username);
        if(userDTO == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) throws ResourceNotFoundException {
        UserDTO updatedUser = userService.updateUser(id, userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        userService.getUserById(id);
        return ResponseEntity.noContent().build();
    }

}
