package com.dq.admincom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dq.admincom.model.Taxe;
import com.dq.admincom.service.BanqueService;

@RestController
public class HomeController {

	@Autowired
	BanqueService banqueService;
	
	@RequestMapping(value = "/")
	public String displayHome(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/index")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping(value="/taxes",method = RequestMethod.GET,headers="Accept=application/json")
	public List<Taxe> getAllTaxes() {
		
		List<Taxe> taxes=banqueService.findAllTaxe();
		return taxes;
	}
}