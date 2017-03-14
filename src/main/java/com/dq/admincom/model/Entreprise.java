package com.dq.admincom.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * The persistent class for the entreprise database table.
 * 
 */
@Entity
public class Entreprise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;

	private String mail;

	private String nom;

	@Column(name = "raison_sociale")
	private String raisonSociale;

	// bi-directional many-to-one association to Taxe
	@OneToMany(mappedBy = "entreprise", fetch = FetchType.LAZY)
	private Set<Taxe> taxes;

	public Entreprise() {
	}

	public Long getCode() {
		return this.code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRaisonSociale() {
		return this.raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	@JsonIgnore
	public Set<Taxe> getTaxes() {
		return this.taxes;
	}

	public void setTaxes(Set<Taxe> taxes) {
		this.taxes = taxes;
	}

}