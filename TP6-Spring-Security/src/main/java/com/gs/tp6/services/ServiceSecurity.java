package com.gs.tp6.services;

import com.gs.tp6.entities.AppUser;
import com.gs.tp6.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSecurity implements IServicecurity{
    @Autowired
    AppUserRepository appUserRepository;
    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}
