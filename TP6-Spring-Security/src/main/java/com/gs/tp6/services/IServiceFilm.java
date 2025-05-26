package com.gs.tp6.services;

import com.gs.tp6.entities.Film;

import java.util.List;

public interface IServiceFilm {

    public List<Film> findAllFilms();
    public Film createFilm(Film f);
    public Film findFilmById(int id );
    public Film updateFilm(Film f);
    public void deleteFilm(Film f);
}
