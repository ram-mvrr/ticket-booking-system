package com.example.ticketbooking.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    private Long roleId;
    private String name;

    public RoleDTO(Role role){
        this.roleId = roleId;
        this.name = name;
    }

    public Role toEntity(){
        Role role = new Role();
        role.setRoleId(this.roleId);
        role.setName(this.name);

        return role;
    }
}
