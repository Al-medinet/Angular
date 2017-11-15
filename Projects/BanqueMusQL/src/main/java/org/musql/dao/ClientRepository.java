package org.musql.dao;

import org.musql.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Clients, Long>{

}
