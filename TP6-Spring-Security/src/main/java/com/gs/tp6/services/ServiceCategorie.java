package com.gs.tp6.services;

import com.gs.tp6.entities.Categorie;
import com.gs.tp6.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategorie implements IServiceCategorie{
    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie findAllById(int id) {
        return categorieRepository.findById(id).get();
    }

    @Override
    public Categorie createCategorie(Categorie c) {
        return categorieRepository.save(c);
    }

    @Override
    public Categorie updateCategorie(Categorie c) {
        return categorieRepository.save(c);
    }

    @Override
    public void deleteCategorie(Categorie c) {
        categorieRepository.delete(c);
    }
}
