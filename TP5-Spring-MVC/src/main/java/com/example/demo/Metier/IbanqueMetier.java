package com.example.demo.Metier;

import com.example.demo.entites.Client;

import java.util.List;

import com.example.demo.entites.*;

public interface IbanqueMetier {
    
    public Client addClient(Client client);
    public Employe addEmploye(Employe emp, Long codeSup);
    public Groupe addGroupe (Groupe groupe);
    public void addEmployeToGroupe (Long codeEmp, Long codeGroupe);
    public Compte addCompte (Compte compte, Long codeClient, Long codeEmploye);
    
    public void versement(String codeCompte, double montant, Long codeEmploye);
    public void retrait(String codeCompte, double montant, Long codeEmploye);
    public void virement(String codeCompte1, String codeCompte2, double montant, Long codeEmploye);
    
    public Compte consulterCompte (String codeCompte);
    public List<Operation> consulterOperations (String codeCompte);
    public Client consulterClient (Long codeClient);
    public List<Client> consulterClients (String mc);
    public List<Compte> consulterComptesByClient (Long codeClient);
    public List<Compte> getCompteByEmploye (Long codeEmploye);
    public List<Employe> getEmployes ();
    public List<Groupe> getGroupe ();
    public List<Employe> getEmployeByGroupe (Long codeGroupe);
}