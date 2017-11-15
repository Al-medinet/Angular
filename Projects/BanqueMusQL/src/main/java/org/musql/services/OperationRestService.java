package org.musql.services;

import org.musql.metier.OperationMetier;
import org.musql.metier.PageOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationRestService {

	@Autowired
	private OperationMetier operationMetier;

	@RequestMapping(value="/versement",method=RequestMethod.PUT)
	public boolean verser(@RequestParam String code,
						  @RequestParam double montant,
						  @RequestParam Long codeEmpl) {
		return operationMetier.verser(code, montant, codeEmpl);
	}
	
	@RequestMapping(value="/retrait",method=RequestMethod.PUT)
	public boolean retrait(@RequestParam String code,
						   @RequestParam double montant,
						   @RequestParam Long codeEmpl) {
		return operationMetier.retrait(code, montant, codeEmpl);
	}

	@RequestMapping(value="/virement",method=RequestMethod.PUT)
	public boolean virement(@RequestParam String cpt1,
							@RequestParam String cpt2,
							@RequestParam double montant,
							@RequestParam Long codeEmpl) {
		return operationMetier.virement(cpt1, cpt2, montant, codeEmpl);
	}

	@RequestMapping(value="/operations",method=RequestMethod.GET)
	public PageOperations getOperation(@RequestParam String code,
								 	   @RequestParam int page,
								 	   @RequestParam int size) {
		return operationMetier.getOperation(code, page, size);
	}
}
