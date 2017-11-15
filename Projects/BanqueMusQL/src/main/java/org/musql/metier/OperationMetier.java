package org.musql.metier;

import java.util.Collection;

import org.musql.entities.Comptes;
import org.musql.entities.Operations;

public interface OperationMetier {

	public boolean verser(String code,double montant,Long codeEmpl);
	public boolean retrait(String code,double montant,Long codeEmpl);
	public boolean virement(String cpt1,String cpt2,double montant,Long codeEmpl);
	public PageOperations getOperation(String code,int page,int size);
}
