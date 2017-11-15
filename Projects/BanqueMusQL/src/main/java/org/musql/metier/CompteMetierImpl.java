package org.musql.metier;

import java.util.Date;

import org.musql.dao.CompteRepository;
import org.musql.entities.Comptes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteMetierImpl implements CompteMetier{

	@Autowired
	private CompteRepository compteRepository;
	@Override
	public Comptes saveCompte(Comptes compte) {
		compte.setDateCreation(new Date());
		return compteRepository.save(compte);
	}

	@Override
	public Comptes getCompte(String code) {
		return compteRepository.findOne(code);
	}

	
}
