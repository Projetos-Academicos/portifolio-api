package com.ricardolima.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardolima.site.models.Email;
import com.ricardolima.site.models.Retorno;
import com.ricardolima.site.services.EmailService;

@RestController
@RequestMapping("/emails")
public class EmailController {

	@Autowired
	private EmailService service;

	@PostMapping("/enviar")
	public Retorno enviarEmail(Email email) {
		return this.service.sendEmail(email);
	}

}
