package com.dq.admincom.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaxeController {
	Logger logger = Logger.getLogger(TaxeController.class);

	@RequestMapping(value = { "/taxe" })
	public String index(Model model) {
		return "taxes";
	}

}