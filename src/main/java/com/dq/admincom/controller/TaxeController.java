package com.dq.admincom.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaxeController {
	Logger logger = Logger.getLogger(TaxeController.class);

	@RequestMapping(value = "/")
	public String displayHome(Model model) {
		return "index";
	}

	@RequestMapping(value = "/index")
	public String index(Model model) {
		return "index";
	}

}