package org.musql.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Clients implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeClient;
	private String nomClient;
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private Collection<Comptes> listComptes;
	public Clients() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Clients(String nomClient) {
		super();
		this.nomClient = nomClient;
	}
	public Long getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	@JsonIgnore
	@XmlTransient
	public Collection<Comptes> getListComptes() {
		return listComptes;
	}
	public void setListComptes(Collection<Comptes> listComptes) {
		this.listComptes = listComptes;
	}
	
	
}
