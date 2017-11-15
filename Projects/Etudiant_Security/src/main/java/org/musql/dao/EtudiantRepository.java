package org.musql.dao;

import org.musql.entities.Etudiants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiants, Long>{
	
}
