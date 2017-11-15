package org.musql.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("CC")
@XmlType(name="CC")
public class CompteCourant extends Comptes{

	private double decouverte;

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(String codeCompte, Date dateCreation, double solde) {
		super(codeCompte, dateCreation, solde);
		// TODO Auto-generated constructor stub
	}

	public double getDecouverte() {
		return decouverte;
	}

	public void setDecouverte(double decouverte) {
		this.decouverte = decouverte;
	}
	
}
