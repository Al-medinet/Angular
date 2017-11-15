package org.musql.metier;

import java.util.Date;

import javax.transaction.Transactional;

import org.musql.dao.CompteRepository;
import org.musql.dao.EmployeRepository;
import org.musql.dao.OperationRepository;
import org.musql.entities.Comptes;
import org.musql.entities.Employe;
import org.musql.entities.Operations;
import org.musql.entities.Retrait;
import org.musql.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OperationMetierImpl implements OperationMetier{

	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private EmployeRepository employeRepository;
	
	@Override
	public boolean verser(String code, double montant, Long codeEmpl) {
		Comptes cp=compteRepository.findOne(code);
		Employe employe=employeRepository.findOne(codeEmpl);
		Operations op=new Versement();
		op.setCompte(cp);
		op.setDateOperation(new Date());
		op.setMontant(montant);
		op.setEmploye(employe);
		operationRepository.save(op);
		cp.setSolde(cp.getSolde()+montant);
		return true;
	}

	@Override
	public boolean retrait(String code, double montant, Long codeEmpl) {
		Comptes cp=compteRepository.findOne(code);
		if(cp.getSolde()<montant) throw new RuntimeException("Votre Solde est insuffisant !");
		Employe employe=employeRepository.findOne(codeEmpl);
		Operations op=new Retrait();
		op.setCompte(cp);
		op.setDateOperation(new Date());
		op.setMontant(montant);
		op.setEmploye(employe);
		operationRepository.save(op);
		cp.setSolde(cp.getSolde()-montant);
		return true;
	}

	@Override
	public boolean virement(String cpt1, String cpt2, double montant, Long codeEmpl) {
		retrait(cpt1, montant, codeEmpl);
		verser(cpt2, montant, codeEmpl);
		return true;
	}

	@Override
	public PageOperations getOperation(String code, int page, int size) {
		Page<Operations> list_Operations=operationRepository.getOperationsCompte(code, new PageRequest(page, size));
		PageOperations pageOperations=new PageOperations();
		pageOperations.setOperation(list_Operations.getContent());
		pageOperations.setNombreoperation(list_Operations.getNumberOfElements());
		pageOperations.setTotalpages(list_Operations.getTotalPages());
		pageOperations.setPage(list_Operations.getNumber());
		pageOperations.setTotaloperation((int)list_Operations.getTotalElements());
		return pageOperations;
	}

}
