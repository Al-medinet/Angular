package org.musql.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class Users implements Serializable{

	@Id
	private String username;
	private String password;
	private boolean actived;
	@ManyToMany
	@JoinTable(name="USERS_ROLES")
	private Collection<Roles> list_roles;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Users(String username, String password,boolean actived) {
		super();
		this.username = username;
		this.password = password;
		this.actived = actived;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Roles> getList_roles() {
		return list_roles;
	}
	public void setList_roles(Collection<Roles> list_roles) {
		this.list_roles = list_roles;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}
	
	
}
