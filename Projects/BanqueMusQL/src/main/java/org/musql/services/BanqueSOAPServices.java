package org.musql.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.musql.entities.Comptes;
import org.musql.metier.CompteMetier;
import org.musql.metier.OperationMetier;
import org.musql.metier.PageOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebService
public class BanqueSOAPServices {

	@Autowired
	private CompteMetier compteMetier;
	@Autowired
	private OperationMetier operationMetier;
	
	@WebMethod
	public Comptes getCompte(@WebParam(name="code") String code) {
		return compteMetier.getCompte(code);
	}
	
	@WebMethod
	public boolean verser(@WebParam(name="code")String code,@WebParam(name="montant") double montant,@WebParam(name="codeEmpl") Long codeEmpl) {
		return operationMetier.verser(code, montant, codeEmpl);
	}
	
	@WebMethod
	public boolean retrait(@WebParam(name="code") String code,@WebParam(name="montant") double montant,@WebParam(name="codeEmpl") Long codeEmpl) {
		return operationMetier.retrait(code, montant, codeEmpl);
	}
	
	@WebMethod
	public boolean virement(@WebParam(name="cpt1") String cpt1,@WebParam(name="cpt2") String cpt2,@WebParam(name="montant") double montant,@WebParam(name="codeEmpl") Long codeEmpl) {
		return operationMetier.virement(cpt1, cpt2, montant, codeEmpl);
	}
	
	@WebMethod
	public PageOperations getOperation(@WebParam(name="code") String code,@WebParam(name="page") int page,@WebParam(name="size") int size) {
		return operationMetier.getOperation(code, page, size);
	}
	
	
}
