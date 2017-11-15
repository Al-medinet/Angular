package org.musql.dao;

import org.musql.entities.Comptes;
import org.musql.entities.Operations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends JpaRepository<Operations, Long>{

	@Query("Select o from Operations o where o.compte.codeCompte=:codeCompte")
	public Page<Operations> getOperationsCompte(@Param("codeCompte") String codeCompte,Pageable pageable);
}
