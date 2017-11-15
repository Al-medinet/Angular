package org.musql.services;

import org.musql.entities.Comptes;
import org.musql.metier.CompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CompteRestService {

	@Autowired
	private CompteMetier compteMetier;

	@RequestMapping(value="/comptes",method=RequestMethod.POST)
	public Comptes saveCompte(@RequestBody Comptes compte) {
		return compteMetier.saveCompte(compte);
	}

	@RequestMapping(value="/comptes/{code}",method=RequestMethod.GET)
	public Comptes getCompte(@PathVariable String code) {
		return compteMetier.getCompte(code);
	}
	
}
