package com.example.demo.entites;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "COMPTES")
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE_COMPTE")
    private long codeCompte;

    @Column(name = "DATE_CREATION")
    private Date dateCreation;

    @Column(name = "SOLDE")
    private double solde;

    @ManyToOne
    @JoinColumn(name = "CODE_CLIENT")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "CODE_EMP")
    private Employe employes;

    @OneToMany(mappedBy = "compte", fetch = FetchType.LAZY)
    private Collection<Operation> operations;

    // ----- Getters -----

    public long getCodeCompte() {
        return codeCompte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public double getSolde() {
        return solde;
    }

    public Client getClient() {
        return client;
    }

    public Employe getEmployes() {
        return employes;
    }

    public Collection<Operation> getOperations() {
        return operations;
    }

    // ----- Setters -----

    public void setCodeCompte(long codeCompte) {
        this.codeCompte = codeCompte;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setEmployes(Employe employes) {
        this.employes = employes;
    }

    public void setOperations(Collection<Operation> operations) {
        this.operations = operations;
    }
}
