package com.example.ticketbooking.user;

import com.example.ticketbooking.user.entity.Role;
import com.example.ticketbooking.user.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {
    private final RoleRepository roleRepository;

    @Autowired
    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(roleRepository.count()==0){
            roleRepository.save(new Role("USER_ROLE"));
            roleRepository.save(new Role("ADMIN_ROLE"));
        }
    }
}
