package com.example.demo.Metier;

import com.example.demo.DAO.IBanqueDAO;
import com.example.demo.entites.*;

import jakarta.transaction.Transactional;

import java.util.*;
import java.sql.*;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BanqueMetierImpl  implements IbanqueMetier{
	@Autowired
    private IBanqueDAO dao;
    
    public void setDao(IBanqueDAO dao) {
        this.dao = dao;
    }
    
    public Client addClient(Client client) {
        return dao.addClient(client);
    }
    
    public Employe addEmploye(Employe emp, Long codeSup) {
        return dao.addEmploye(emp, codeSup);
    }
    
    public Groupe addGroupe(Groupe groupe) {
        return dao.addGroupe(groupe);
    }
    
    public void addEmployeToGroupe(Long codeEmp, Long codeGroupe) {
        dao.addEmployeToGroupe(codeEmp, codeGroupe);
    }
    
    public Compte addCompte(Compte compte, Long codeClient, Long CodeEmploye) {
        return dao.addCompte(compte, codeClient, CodeEmploye);
    }
    
    public void versement(String codeCompte, double montant, Long codeEmploye) {
        dao.addOperation(new Versement(new Date(), montant), codeCompte, codeEmploye);
        Compte cp = dao.consulterCompte(codeCompte);
        cp.setSolde(cp.getSolde()+montant);
    }
    
    public void retrait(String codeCompte, double montant, Long codeEmploye) {
        dao.addOperation(new Retrait(new Date(), montant), codeCompte, codeEmploye);
        Compte cp = dao.consulterCompte(codeCompte);
        cp.setSolde(cp.getSolde()-montant);
    }
    
    public void virement(String codeCompte1, String codeCompte2, double montant, Long codeEmploye) {
        retrait(codeCompte1, montant, codeEmploye);
        versement(codeCompte2, montant, codeEmploye);
    }
    
    public Compte consulterCompte(String codeCompte) {
        return dao.consulterCompte(codeCompte);
    }
    
    public List<Operation> consulterOperations(String codeCompte) {
        return dao.consulterOperations(codeCompte);
    }
    
    public Client consulterClient(Long codeClient) {
        return dao.consulterClient(codeClient);
    }
    
    public List<Client> consulterClients(String mc) {
        return dao.consulterClients(mc);
    }
    
    public List<Compte> consulterComptesByClient(Long codeClient) {
        return dao.getComptesByClient(codeClient);
    }
    
    public List<Compte> getCompteByEmploye(Long codeEmploye) {
        return dao.getCompteByEmploye(codeEmploye);
    }
    
    public List<Employe> getEmployes() {
        return dao.getEmployes();
    }
    
    public List<Groupe> getGroupe() {
        return dao.getGroupe();
    }
    
    @Override
    public List<Employe> getEmployeByGroupe(Long codeGroupe) {
        return dao.getEmployeByGroupe(codeGroupe);
    }

}
