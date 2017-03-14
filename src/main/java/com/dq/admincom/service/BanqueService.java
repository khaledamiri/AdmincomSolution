package com.dq.admincom.service;

import java.util.List;

import com.dq.admincom.exception.EntrepriseNotFound;
import com.dq.admincom.exception.TaxeNotFound;
import com.dq.admincom.model.Entreprise;
import com.dq.admincom.model.Taxe;

public interface BanqueService {

	public Entreprise createEntreprise(Entreprise entreprise);

	public Entreprise deleteEntreprise(Long id) throws EntrepriseNotFound;

	public List<Entreprise> findAllEntreprise();

	public Entreprise update(Entreprise entreprise) throws EntrepriseNotFound;

	public Entreprise findEntrepriseById(Long id);

	public Taxe createTaxe(Taxe taxe);

	public Taxe deleteTaxe(Long id) throws TaxeNotFound;

	public List<Taxe> findAllTaxe();

	public Taxe updateTaxe(Taxe taxe) throws TaxeNotFound;

	public Taxe findTaxeById(Long id);

}
