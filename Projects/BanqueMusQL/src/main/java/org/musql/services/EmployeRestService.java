package org.musql.services;

import java.util.Collection;

import org.musql.entities.Employe;
import org.musql.metier.EmployeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeRestService {

	@Autowired
	private EmployeMetier employeMetier;
	@RequestMapping(value="/employes",method=RequestMethod.POST)
	public Employe saveEmploye(@RequestBody Employe employe)
	{
		return employeMetier.saveEmploye(employe);
	}
	
	@RequestMapping(value="/employes")
	public Collection<Employe> getEmployes(){
		return employeMetier.findAll();
	}
}
