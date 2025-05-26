package com.gs.tp6.services;

import com.gs.tp6.entities.AppUser;

public interface IServicecurity {
    public AppUser loadUserByUsername(String username);
}
