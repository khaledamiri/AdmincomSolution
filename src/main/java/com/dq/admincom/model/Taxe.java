package com.dq.admincom.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
/**
 * The persistent class for the taxe database table.
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, length = 3, name = "TYPE")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({

@JsonSubTypes.Type(name = "TVA", value = TVA.class),
		@JsonSubTypes.Type(name = "IR", value = IR.class)

})
public class Taxe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "TaxeGenerator") 
    @GenericGenerator(name = "TaxeGenerator", strategy = "com.dq.admincom.identifiergenerator.TableKeyGenerator", parameters =  {
        @Parameter(name = "key", value = "TAXE"),
        @Parameter(name = "prefixe", value = "TX-")
    }
    )
	private String numero;
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

	public Taxe(Date date, double montant, String titre, Entreprise entreprise,
			String type) {
		super();
		this.date = date;
		this.montant = montant;
		this.titre = titre;
		this.entreprise = entreprise;
		this.type = type;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((entreprise == null) ? 0 : entreprise.hashCode());
		long temp;
		temp = Double.doubleToLongBits(montant);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result +  ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Taxe other = (Taxe) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (entreprise == null) {
			if (other.entreprise != null)
				return false;
		} else if (!entreprise.equals(other.entreprise))
			return false;
		if (Double.doubleToLongBits(montant) != Double
				.doubleToLongBits(other.montant))
			return false;
		if (numero != other.numero)
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Taxe [numero=" + numero + ", date=" + date + ", montant="
				+ montant + ", titre=" + titre + ", entreprise=" + entreprise
				+ ", type=" + type + "]";
	}

}