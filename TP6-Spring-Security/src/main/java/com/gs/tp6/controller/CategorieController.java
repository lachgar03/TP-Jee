package com.gs.tp6.controller;

import com.gs.tp6.entities.Categorie;
import com.gs.tp6.entities.Film;
import com.gs.tp6.repository.CategorieRepository;
import com.gs.tp6.services.IServiceCategorie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categorie")
public class CategorieController {

    private final IServiceCategorie iServiceCategorie;
    private final CategorieRepository categorieRepository;

    public CategorieController(IServiceCategorie iServiceCategorie, CategorieRepository categorieRepository) {
        this.iServiceCategorie = iServiceCategorie;
        this.categorieRepository = categorieRepository;
    }

    @GetMapping("/all")
    public String afficherCategories(Model model) {
        List<Categorie> categories = categorieRepository.findAll();
        model.addAttribute("categories", categories);

        return "afficheCategorie";  // fichier afficheCategorie.html
    }

    @GetMapping("/form")
    public String afficherFormulaireAjoutCategorie(Model model) {
        model.addAttribute("categorie", new Categorie());
        return "addCategorie";  // fichier addCategorie.html
    }


    @PostMapping("/add")
    public String ajouterCategorie(@ModelAttribute Categorie c) {
        iServiceCategorie.createCategorie(c);
        return "redirect:/categorie/all";  // redirection vers la liste
    }
    @PostMapping("/delete")
        public String deleteFilm(@ModelAttribute Categorie categorie){
        iServiceCategorie.deleteCategorie(categorie);
        return "redirect:/categorie/all"; // redirige vers la méthode qui remplit le modèle
    }
}
