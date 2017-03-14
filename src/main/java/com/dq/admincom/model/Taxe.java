package com.dq.admincom.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * The persistent class for the taxe database table.
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, length = 2, name = "TYPE")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({

@JsonSubTypes.Type(name = "TVA", value = TVA.class),
		@JsonSubTypes.Type(name = "IR", value = IR.class)

})
public class Taxe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;
	@Temporal(TemporalType.DATE)
	private Date date;

	private double montant;

	private String titre;

	// bi-directional many-to-one association to Entreprise

	@ManyToOne
	@JoinColumn(name = "code_entr")
	private Entreprise entreprise;

	@Column(name = "type", insertable = false, updatable = false)
	private String type;

	public Taxe() {
	}

	public Taxe(Date date, double montant, String titre, Entreprise entreprise) {
		super();
		this.date = date;
		this.montant = montant;
		this.titre = titre;
		this.entreprise = entreprise;
	}

	public Long getNumero() {
		return this.numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getMontant() {
		return this.montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Entreprise getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}