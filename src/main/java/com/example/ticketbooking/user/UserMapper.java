package com.example.ticketbooking.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface UserMapper {
    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapRoles")
    @Mapping(target = "password", source = "password")  // Ensure password is mapped
    User toEntity(UserDTO userDTO);
    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapRoleToDTOsRoles")
    UserDTO toDTO(User user);

    @Named("mapRoles")
    default Set<Role> mapRoles(Set<RoleDTO> roleDTOs){
        if(roleDTOs == null){
            return null;
        }
        return roleDTOs.stream()
                .map(roleDTO -> new Role(roleDTO.getRoleId(), roleDTO.getName()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    @Named("mapRoleToDTOsRoles")
    default Set<RoleDTO> mapRoleToDTOsRoles(Set<Role> roles){
        if(roles.isEmpty()){
            return null;
        }
        return roles.stream()
                .map(role -> new RoleDTO(role.getRoleId(),role.getName()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
