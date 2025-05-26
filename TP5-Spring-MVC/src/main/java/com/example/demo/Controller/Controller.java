package com.example.demo.Controller;

import com.example.demo.Metier.IbanqueMetier;
import com.example.demo.entites.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Contrôleur pour servir la page HTML gestion.html
@Controller
public class PageController {

    @GetMapping("/gestion")
    public String gestion() {
        return "gestion"; // Cela retournera la vue gestion.html (dans src/main/resources/templates si tu utilises Thymeleaf)
    }
}

// Contrôleur REST pour gérer les APIs de la banque
@RestController
@RequestMapping("/api")
public class BanqueRestController {

    @Autowired
    private IbanqueMetier banqueMetier;

    // --- CLIENTS ---

    @PostMapping("/clients")
    public Client addClient(@RequestBody Client client) {
        return banqueMetier.addClient(client);
    }

    @GetMapping("/clients/{codeClient}")
    public Client consulterClient(@PathVariable Long codeClient) {
        return banqueMetier.consulterClient(codeClient);
    }

    @GetMapping("/clients")
    public List<Client> consulterClients(@RequestParam(required = false, defaultValue = "") String mc) {
        return banqueMetier.consulterClients(mc);
    }

    @GetMapping("/clients/{codeClient}/comptes")
    public List<Compte> consulterComptesByClient(@PathVariable Long codeClient) {
        return banqueMetier.consulterComptesByClient(codeClient);
    }

    // --- EMPLOYES ---

    @PostMapping("/employes")
    public Employe addEmploye(@RequestBody Employe emp, @RequestParam Long codeSup) {
        return banqueMetier.addEmploye(emp, codeSup);
    }

    @GetMapping("/employes")
    public List<Employe> getEmployes() {
        return banqueMetier.getEmployes();
    }

    @GetMapping("/employes/{codeEmploye}/comptes")
    public List<Compte> getCompteByEmploye(@PathVariable Long codeEmploye) {
        return banqueMetier.getCompteByEmploye(codeEmploye);
    }

    // --- GROUPES ---

    @PostMapping("/groupes")
    public Groupe addGroupe(@RequestBody Groupe groupe) {
        return banqueMetier.addGroupe(groupe);
    }

    @GetMapping("/groupes")
    public List<Groupe> getGroupes() {
        return banqueMetier.getGroupe();
    }

    @PostMapping("/groupes/{codeGroupe}/employes/{codeEmp}")
    public void addEmployeToGroupe(@PathVariable Long codeEmp, @PathVariable Long codeGroupe) {
        banqueMetier.addEmployeToGroupe(codeEmp, codeGroupe);
    }

    @GetMapping("/groupes/{codeGroupe}/employes")
    public List<Employe> getEmployeByGroupe(@PathVariable Long codeGroupe) {
        return banqueMetier.getEmployeByGroupe(codeGroupe);
    }

    // --- COMPTES ---

    @PostMapping("/comptes")
    public Compte addCompte(@RequestBody Compte compte,
                            @RequestParam Long codeClient,
                            @RequestParam Long codeEmploye) {
        return banqueMetier.addCompte(compte, codeClient, codeEmploye);
    }

    @GetMapping("/comptes/{codeCompte}")
    public Compte consulterCompte(@PathVariable String codeCompte) {
        return banqueMetier.consulterCompte(codeCompte);
    }

    @GetMapping("/comptes/{codeCompte}/operations")
    public List<Operation> consulterOperations(@PathVariable String codeCompte) {
        return banqueMetier.consulterOperations(codeCompte);
    }

    @PostMapping("/comptes/{codeCompte}/versement")
    public void versement(@PathVariable String codeCompte,
                          @RequestParam double montant,
                          @RequestParam Long codeEmploye) {
        banqueMetier.versement(codeCompte, montant, codeEmploye);
    }

    @PostMapping("/comptes/{codeCompte}/retrait")
    public void retrait(@PathVariable String codeCompte,
                        @RequestParam double montant,
                        @RequestParam Long codeEmploye) {
        banqueMetier.retrait(codeCompte, montant, codeEmploye);
    }

    @PostMapping("/comptes/virement")
    public void virement(@RequestParam String codeCompte1,
                         @RequestParam String codeCompte2,
                         @RequestParam double montant,
                         @RequestParam Long codeEmploye) {
        banqueMetier.virement(codeCompte1, codeCompte2, montant, codeEmploye);
    }
}
