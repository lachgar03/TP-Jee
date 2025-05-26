package com.example.demo.entites;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {
	@Column(name="DECOUVERT")
	private double decouvert;

}
