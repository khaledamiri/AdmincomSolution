package com.dq.admincom.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the entreprise database table.
 * 
 */
@Entity
@NamedQuery(name="Entreprise.findAll", query="SELECT e FROM Entreprise e")
public class Entreprise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long code;

	private String mail;

	private String nom;

	@Column(name="raison_sociale")
	private String raisonSociale;

	//bi-directional many-to-one association to Taxe
	@OneToMany(mappedBy="entreprise")
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

	public Set<Taxe> getTaxes() {
		return this.taxes;
	}

	public void setTaxes(Set<Taxe> taxes) {
		this.taxes = taxes;
	}

	public Taxe addTaxe(Taxe taxe) {
		getTaxes().add(taxe);
		taxe.setEntreprise(this);

		return taxe;
	}

	public Taxe removeTaxe(Taxe taxe) {
		getTaxes().remove(taxe);
		taxe.setEntreprise(null);

		return taxe;
	}

}