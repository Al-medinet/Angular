package org.musql.metier;

import java.util.Collection;

import org.musql.dao.ClientRepository;
import org.musql.entities.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientMetierImpl implements ClientMetier {

	@Autowired
	public ClientRepository clientRepository;
	@Override
	public Clients saveClient(Clients client) {
		return clientRepository.save(client);
	}

	@Override
	public Collection<Clients> findAll() {
		return clientRepository.findAll();
	}

}
