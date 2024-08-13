package com.example.ticketbooking.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper instance = Mappers.getMapper(UserMapper.class);

    User toEntity(UserDTO userDTO);
    UserDTO toDTO(User user);

}
