package org.musql.metier;

import org.musql.entities.Comptes;

public interface CompteMetier {

	public Comptes saveCompte(Comptes compte);
	public Comptes getCompte(String code);
}
