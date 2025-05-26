package com.example.demo.entites;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
	@Column(name="TAUX_INTERET")
	private double tauxInteret;
}
