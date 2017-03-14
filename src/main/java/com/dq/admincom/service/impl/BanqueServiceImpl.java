package com.dq.admincom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dq.admincom.dao.EntrepriseRepository;
import com.dq.admincom.dao.TaxeRepository;
import com.dq.admincom.exception.EntrepriseNotFound;
import com.dq.admincom.exception.TaxeNotFound;
import com.dq.admincom.model.Entreprise;
import com.dq.admincom.model.Taxe;
import com.dq.admincom.service.BanqueService;

@Service
@Transactional(readOnly=true)
public class BanqueServiceImpl implements BanqueService {

	@Autowired
	private TaxeRepository taxeRepository;

	@Autowired
	private EntrepriseRepository entrepriseRepository;

	
	@Transactional(readOnly = false)
	public Entreprise createEntreprise(Entreprise entreprise) {

		return entrepriseRepository.save(entreprise);
	}

	
	@Transactional(readOnly = false)
	public Entreprise deleteEntreprise(Long id) throws EntrepriseNotFound {

		Entreprise entreprise = entrepriseRepository.findOne(id);
		if (entreprise == null)
			throw new EntrepriseNotFound();
		entrepriseRepository.delete(entreprise);
		return entreprise;

	}

	
	public List<Entreprise> findAllEntreprise() {

		return entrepriseRepository.findAll();
	}

	
	@Transactional(readOnly = false)
	public Entreprise update(Entreprise entreprise) throws EntrepriseNotFound {
		Entreprise updatedEntr = entrepriseRepository.findOne(entreprise
				.getCode());

		if (updatedEntr == null) {
			throw new EntrepriseNotFound();
		}

		updatedEntr.setMail(entreprise.getMail());
		updatedEntr.setNom(entreprise.getNom());
		updatedEntr.setRaisonSociale(entreprise.getRaisonSociale());
		updatedEntr.setTaxes(entreprise.getTaxes());
		return updatedEntr;
	}

	
	public Entreprise findEntrepriseById(Long id) {

		return entrepriseRepository.findOne(id);
	}

	
	@Transactional(readOnly = false)
	public Taxe createTaxe(Taxe taxe) {

		return taxeRepository.save(taxe);
	}

	
	public Taxe deleteTaxe(Long id) throws TaxeNotFound {
		Taxe deletedTaxe = taxeRepository.findOne(id);
		if (deletedTaxe == null)
			throw new TaxeNotFound();
		taxeRepository.delete(id);
		return deletedTaxe;
	}

	
	public List<Taxe> findAllTaxe() {

		return taxeRepository.findAll();
	}

	
	@Transactional(readOnly = false)
	public Taxe updateTaxe(Taxe taxe) throws TaxeNotFound {
		Taxe updatedTaxe = taxeRepository.findOne(taxe.getNumero());
		if (updatedTaxe == null)
			throw new TaxeNotFound();
		updatedTaxe.setDate(taxe.getDate());
		updatedTaxe.setEntreprise(taxe.getEntreprise());
		updatedTaxe.setMontant(taxe.getMontant());
		updatedTaxe.setTitre(taxe.getTitre());
		return updatedTaxe;
	}

	
	public Taxe findTaxeById(Long id) {

		return taxeRepository.findOne(id);
	}
}
