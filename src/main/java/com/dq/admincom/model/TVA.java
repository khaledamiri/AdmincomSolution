package com.dq.admincom.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TVA")
public class TVA extends Taxe {

	public TVA() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TVA(Date date, double montant, String titre, Entreprise entreprise) {
		super(date, montant, titre, entreprise);
		// TODO Auto-generated constructor stub
	}
	

}
