package com.dq.admincom.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dq.admincom.exception.EntrepriseNotFound;
import com.dq.admincom.exception.TaxeNotFound;
import com.dq.admincom.model.Entreprise;
import com.dq.admincom.model.Taxe;

public interface BanqueService {

	public Entreprise createEntreprise(Entreprise entreprise);

	public Entreprise deleteEntreprise(String id) throws EntrepriseNotFound;

	public List<Entreprise> findAllEntreprise();

	public Entreprise updateEntreprise(Entreprise entreprise) throws EntrepriseNotFound;

	public Entreprise findEntrepriseById(String id);

	public Taxe createTaxe(Taxe taxe);

	public Taxe deleteTaxe(String id) throws TaxeNotFound;

	public List<Taxe> findAllTaxe();
	
	public Page<Taxe> findAllTaxePage(int page,int size);

	public Taxe updateTaxe(Taxe taxe) throws TaxeNotFound;

	public Taxe findTaxeById(String id);

	public Page<Entreprise> findAllEntreprisePage(int page, int size);

}
