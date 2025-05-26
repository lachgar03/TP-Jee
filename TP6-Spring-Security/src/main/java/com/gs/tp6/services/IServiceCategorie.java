package com.gs.tp6.services;

import com.gs.tp6.entities.Categorie;

import java.util.List;

public interface IServiceCategorie {
    List<Categorie> findAll();
    public Categorie findAllById(int id);
    public Categorie createCategorie(Categorie c);
    public Categorie updateCategorie(Categorie c);
    public void deleteCategorie(Categorie c);
}
