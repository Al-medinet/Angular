package org.musql.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Etudiants implements Serializable {

	@Id @GeneratedValue
	private Long id;
	@NotNull @Size(min=3,max=20)
	private String nom;
	@NotNull @Size(min=2,max=12)
	private String prenom;
	@NotNull @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date_naissance;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	public Etudiants(String nom, String prenom, Date date_naissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
	}
	public Etudiants() {
		super();
		// TODO Auto-generated constructor stub
	}
}
