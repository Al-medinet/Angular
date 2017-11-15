package org.musql.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Roles implements Serializable{

	@Id
	private String nom;
	private String description;
	public Roles() {
		
	}
	
	public Roles(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
