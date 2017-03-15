package com.dq.admincom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dq.admincom.exception.EntrepriseNotFound;
import com.dq.admincom.exception.TaxeNotFound;
import com.dq.admincom.model.Entreprise;
import com.dq.admincom.model.Taxe;
import com.dq.admincom.repository.EntrepriseRepository;
import com.dq.admincom.repository.TaxeRepository;
import com.dq.admincom.service.BanqueService;

@Service
@Transactional(readOnly = true)
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
	public Entreprise deleteEntreprise(String id) throws EntrepriseNotFound {

		Entreprise entreprise = entrepriseRepository.findOne(id);
		if (entreprise == null)
			throw new EntrepriseNotFound();
		entrepriseRepository.delete(entreprise);
		return entreprise;

	}

	@Transactional
	public List<Entreprise> findAllEntreprise() {

		return entrepriseRepository.findAll();
	}

	@Transactional(readOnly = false)
	public Entreprise updateEntreprise(Entreprise entreprise)
			throws EntrepriseNotFound {
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

	@Transactional
	public Entreprise findEntrepriseById(String id) {

		return entrepriseRepository.findOne(id);
	}

	@Transactional(readOnly = false)
	public Taxe createTaxe(Taxe taxe) {

		return taxeRepository.save(taxe);
	}

	@Transactional(readOnly = false)
	public Taxe deleteTaxe(String id) throws TaxeNotFound {
		Taxe deletedTaxe = taxeRepository.findOne(id);
		if (deletedTaxe == null)
			throw new TaxeNotFound();
		taxeRepository.delete(id);
		return deletedTaxe;
	}

	@Transactional
	public List<Taxe> findAllTaxe() {

		return taxeRepository.findAll();
	}

	@Transactional
	public Page<Taxe> findAllTaxePage(int page, int size) {

		return taxeRepository.findAll(new PageRequest(page, size));
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

	@Transactional
	public Taxe findTaxeById(String id) {

		return taxeRepository.findOne(id);
	}

	@Transactional
	public Page<Entreprise> findAllEntreprisePage(int page, int size) {
		return entrepriseRepository.findAll(new PageRequest(page, size));
	}
}
