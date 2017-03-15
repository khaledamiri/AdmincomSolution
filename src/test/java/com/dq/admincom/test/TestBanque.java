package com.dq.admincom.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import com.dq.admincom.model.Taxe;
import com.dq.admincom.service.BanqueService;
import com.dq.admincom.service.impl.BanqueServiceImpl;

public class TestBanque {

	@Test
	public void test() {
		assertTrue(true);
		BanqueService banqueService = new BanqueServiceImpl();
		Taxe t=new Taxe(new Date(), 200, "dd", null, "ss");
				banqueService.createTaxe(t);
		// Entreprise e = new Entreprise();
		// e.setNom("e10");
		// e.setMail("e10@gmail.com");
		// e.setRaisonSociale("r10");
		// banqueService.createEntreprise(e);
	}

}
