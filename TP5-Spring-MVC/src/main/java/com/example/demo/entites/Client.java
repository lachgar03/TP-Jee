package com.example.demo.entites;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="CLIENTS")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CODE_CLIENT")
    private long codeClient;

    @Column(name="NOM_CLIENT")
    private String nomClient;

    @Column(name="PRENOM_CLIENT")
    private String prenomClient;

    @Column(name="ADR_CLIENT")
    private long adresseClient;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Collection<Compte> comptes;

    // Getters et Setters

    public long getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(long codeClient) {
        this.codeClient = codeClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public long getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(long adresseClient) {
        this.adresseClient = adresseClient;
    }

    public Collection<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Collection<Compte> comptes) {
        this.comptes = comptes;
    }
}
