package com.example.demo.entites;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="EMPLOYES")
public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CODE_EMPLOYE")
    private long codeEmploye;

    @Column(name="NOM_EMPLOYE")
    private String nomEmploye;

    @ManyToOne
    @JoinColumn(name = "CODE_EMP_SUP")
    private Employe employeSup;

    @ManyToMany
    @JoinTable(
        name = "EMPLOYE_GROUPE",
        joinColumns = @JoinColumn(name="CODE_EMPLOYE"),
        inverseJoinColumns = @JoinColumn(name="CODE_GROUPE")
    )
    private Collection<Groupe> groupes;

    // Getters et Setters

    public long getCodeEmploye() {
        return codeEmploye;
    }

    public void setCodeEmploye(long codeEmploye) {
        this.codeEmploye = codeEmploye;
    }

    public String getNomEmploye() {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    public Employe getEmployeSup() {
        return employeSup;
    }

    public void setEmployeSup(Employe employeSup) {
        this.employeSup = employeSup;
    }

    public Collection<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(Collection<Groupe> groupes) {
        this.groupes = groupes;
    }
}
