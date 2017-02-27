package com.dq.admincom.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("IR")
public class IR extends Taxe {

	private static final long serialVersionUID = -7429669529127371116L;

	public IR() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IR(Date date, double montant, String titre, Entreprise entreprise) {
		super(date, montant, titre, entreprise);
		// TODO Auto-generated constructor stub
	}

}
