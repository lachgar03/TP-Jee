package com.example.demo.DAO;

import com.example.demo.entites.Client;

import java.util.List;

import com.example.demo.entites.*;

import com.example.demo.entites.Employe;

public interface IBanqueDAO {
    public Client addClient(Client client);
    public Employe addEmploye(Employe emp, Long codeSup);
    public Groupe addGroupe (Groupe groupe);
    public void addEmployeToGroupe (Long codeEmp, Long codeGroupe);
    public Compte addCompte (Compte compte, Long codeClient, Long codeEmploye);
    public Operation addOperation (Operation operation, String codeCompte, Long codeEmploye);
    public Compte consulterCompte (String codeCompte);
    public List<Operation> consulterOperations (String codeCompte);
    public Client consulterClient (Long codeClient);
    public List<Client> consulterClients (String mc);
    public List<Compte> getComptesByClient (Long codeClient);
    public List<Compte> getCompteByEmploye (Long codeEmploye);
    public List<Employe> getEmployes ();
    public List<Groupe> getGroupe ();
    public List<Employe> getEmployeByGroupe (Long codeGroupe);
    
}

