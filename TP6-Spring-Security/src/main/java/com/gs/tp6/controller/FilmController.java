package com.gs.tp6.controller;

import com.gs.tp6.entities.Film;
import com.gs.tp6.repository.FilmRepository;
import com.gs.tp6.services.IServiceCategorie;
import com.gs.tp6.services.IServiceFilm;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/film")
public class FilmController {

    private final IServiceFilm iServiceFilm;
    private final IServiceCategorie iServiceCategorie;

    public FilmController(IServiceFilm iServiceFilm, IServiceCategorie iServiceCategorie) {
        this.iServiceFilm = iServiceFilm;
        this.iServiceCategorie = iServiceCategorie;
    }

    @GetMapping("/all")
    public String afficherFilms(Model model) {
        List<Film> films = iServiceFilm.findAllFilms();
        System.out.println("Films récupérés : " + films);  // pour debug
        model.addAttribute("films", films);
        return "affiche";
    }


    @GetMapping("/show")
    public String showAddForm(Model model) {
        model.addAttribute("film", new Film());
        model.addAttribute("categories", iServiceCategorie.findAll());
        return "addFilm"; // assure-toi que addFilm.html existe
    }

    @PostMapping("/add")
    public String addFilm(@ModelAttribute Film film) {
        iServiceFilm.createFilm(film);
        return "redirect:/film/all";
    }
    @PostMapping("/delete")
    public String deleteFilm(@ModelAttribute Film film){
        iServiceFilm.deleteFilm(film);
        return "redirect:/film/all"; // redirige vers la méthode qui remplit le modèle
    }

}

