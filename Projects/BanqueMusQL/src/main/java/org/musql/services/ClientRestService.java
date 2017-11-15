package org.musql.services;

import java.util.Collection;

import org.musql.entities.Clients;
import org.musql.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientRestService {
	@Autowired
	public ClientMetier clientMetier;

	@RequestMapping(value="/clients",method=RequestMethod.POST)
	public Clients saveClient(@RequestBody Clients client) {
		return clientMetier.saveClient(client);
	}

	@RequestMapping(value="/clients",method=RequestMethod.GET)
	public Collection<Clients> findAll() {
		return clientMetier.findAll();
	}
	
}
