package org.musql.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import ch.qos.logback.core.joran.spi.DefaultClass;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_COMPTE",discriminatorType=DiscriminatorType.STRING,length=2)

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type_cpt")
@JsonSubTypes(value={
		@Type(name="CC",value=CompteCourant.class),
		@Type(name="CE",value=CompteEpargne.class)
})

@XmlSeeAlso({CompteCourant.class,CompteEpargne.class})
public abstract class Comptes implements Serializable{

	@Id
	private String codeCompte;
	private Date dateCreation;
	private double solde;
	@ManyToOne
	@JoinColumn(name="CODE_CLIENT")
	private Clients client;
	@ManyToOne
	@JoinColumn(name="CODE_EMPLOYE")
	private Employe employe;
	@OneToMany(mappedBy="compte",fetch=FetchType.LAZY)
	private Collection<Operations> listOperation;
	
	
	public Comptes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comptes(String codeCompte, Date dateCreation, double solde) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
	}
	public String getCodeCompte() {
		return codeCompte;
	}
	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Clients getClient() {
		return client;
	}
	public void setClient(Clients client) {
		this.client = client;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	@JsonIgnore
	@XmlTransient
	public Collection<Operations> getListOperation() {
		return listOperation;
	}
	public void setListOperation(Collection<Operations> listOperation) {
		this.listOperation = listOperation;
	}
	
	
	
	
}
