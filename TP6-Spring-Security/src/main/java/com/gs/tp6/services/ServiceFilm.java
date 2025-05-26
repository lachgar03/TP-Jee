package com.gs.tp6.services;

import com.gs.tp6.entities.Film;
import com.gs.tp6.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceFilm implements IServiceFilm {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<Film> findAllFilms() {
        return filmRepository.findAll();
    }
    @Override
    public Film createFilm(Film f) {
        return filmRepository.save(f);
    }
    @Override
    public Film findFilmById(int id) {
        return filmRepository.findById(id).orElse(null);
    }
    @Override
    public Film updateFilm(Film f) {
        return filmRepository.save(f);
    }
    @Override
    public void deleteFilm(Film f) {
        filmRepository.delete(f);
    }
}
