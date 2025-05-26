package com.example.demo.entites;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "GROUPES")
public class Groupe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE_GROUPE")
    private long codeGroupe;

    @Column(name = "NOM_GROUPE")
    private String nomGroupe;

    @ManyToMany(mappedBy = "groupes")
    private Collection<Employe> employes;

    // Getters
    public long getCodeGroupe() {
        return codeGroupe;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public Collection<Employe> getEmployes() {
        return employes;
    }

    // Setters
    public void setCodeGroupe(long codeGroupe) {
        this.codeGroupe = codeGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public void setEmployes(Collection<Employe> employes) {
        this.employes = employes;
    }
}
