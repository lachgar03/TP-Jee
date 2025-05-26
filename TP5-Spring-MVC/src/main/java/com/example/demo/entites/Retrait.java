package com.example.demo.entites;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.*;
import java.sql.Date;


@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation{
	 public Retrait() {}
	    public Retrait(Date dateOperation, double montant) {
	        super(dateOperation, montant);
	    }
}
