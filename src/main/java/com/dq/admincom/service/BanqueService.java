package com.dq.admincom.service;

import java.util.List;

import com.dq.admincom.exception.EntrepriseNotFound;
import com.dq.admincom.exception.TaxeNotFound;
import com.dq.admincom.model.Entreprise;
import com.dq.admincom.model.Taxe;

public interface BanqueService {

	Entreprise createEntreprise(Entreprise entreprise);

	Entreprise deleteEntreprise(Long id) throws EntrepriseNotFound;

	List<Entreprise> findAllEntreprise();

	Entreprise update(Entreprise entreprise) throws EntrepriseNotFound;

	Entreprise findEntrepriseById(Long id);

	Taxe createTaxe(Taxe taxe);

	Taxe deleteTaxe(Long id) throws TaxeNotFound;

	List<Taxe> findAllTaxe();

	Taxe updateTaxe(Taxe taxe) throws TaxeNotFound;

	Taxe findTaxeById(Long id);

}
