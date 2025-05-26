package com.gs.tp6.repository;

import com.gs.tp6.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Integer> {
    AppRole findByRolename(String rolename);
}
