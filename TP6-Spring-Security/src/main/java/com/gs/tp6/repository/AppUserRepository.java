package com.gs.tp6.repository;

import com.gs.tp6.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByUsername(String username );
}
