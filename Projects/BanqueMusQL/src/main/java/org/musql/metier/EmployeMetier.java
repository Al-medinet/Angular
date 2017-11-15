package org.musql.metier;

import java.util.Collection;

import org.musql.dao.EmployeRepository;
import org.musql.entities.Employe;

public interface EmployeMetier {

	public Employe saveEmploye(Employe employe);
	public Collection<Employe> findAll();
}
