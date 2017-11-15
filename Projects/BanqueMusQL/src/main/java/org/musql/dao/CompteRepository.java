package org.musql.dao;

import org.musql.entities.Comptes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Comptes, String>{

}
