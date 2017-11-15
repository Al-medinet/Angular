package org.musql.metier;

import java.util.Collection;

import org.musql.dao.EmployeRepository;
import org.musql.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeMetierImpl implements EmployeMetier {

	@Autowired
	private EmployeRepository employeRepository;
	@Override
	public Employe saveEmploye(Employe employe) {
		return employeRepository.save(employe);
	}

	@Override
	public Collection<Employe> findAll() {
		return employeRepository.findAll();
	}

}
