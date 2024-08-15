package com.example.ticketbooking.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;

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
            roleRepository.save(new Role(null,"ROLE_USER",new HashSet<>()));
            roleRepository.save(new Role(null,"ROLE_ADMIN",new HashSet<>()));
        }
    }
}
