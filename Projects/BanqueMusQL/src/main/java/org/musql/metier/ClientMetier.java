package org.musql.metier;

import java.util.Collection;

import org.musql.entities.Clients;

public interface ClientMetier {

	public Clients saveClient(Clients client);
	public Collection<Clients> findAll();
}
