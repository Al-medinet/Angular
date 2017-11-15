package org.musql.metier;

import java.io.Serializable;
import java.util.Collection;

import org.musql.entities.Operations;

public class PageOperations implements Serializable{

	private Collection<Operations> operation;
	private int page;
	private int nombreoperation;
	private int totalpages;
	private int totaloperation;
	public int getTotaloperation() {
		return totaloperation;
	}
	public void setTotaloperation(int totaloperation) {
		this.totaloperation = totaloperation;
	}
	public Collection<Operations> getOperation() {
		return operation;
	}
	public void setOperation(Collection<Operations> operation) {
		this.operation = operation;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreoperation() {
		return nombreoperation;
	}
	public void setNombreoperation(int nombreoperation) {
		this.nombreoperation = nombreoperation;
	}
	public int getTotalpages() {
		return totalpages;
	}
	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}
	
	
}
