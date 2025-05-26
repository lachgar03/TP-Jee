package com.example.demo.entites;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.*;
import java.sql.Date;

@Entity
@DiscriminatorValue("V")
public class Versement extends Operation{
	 public Versement() {}
	    public Versement(Date dateOperation, double montant) {
	        super(dateOperation,montant);
	    }

}
