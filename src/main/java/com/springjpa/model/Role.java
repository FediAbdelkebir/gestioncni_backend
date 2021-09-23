package com.springjpa.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;




@Entity
@Table(name="role" ,schema="public")
public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idrole")
	public int idrole;
	@Column(name="Role",unique=true, nullable=false)
	public String Role;
	
	
	
	
//	/*Tab3th wala trj3 l object Role */
//	/*@JsonManagedReference
//	/*Tab3th wala trj3 l object Role */
//	@OneToMany(fetch=FetchType.EAGER,mappedBy="role")
//	private List<Customer> Customers=new ArrayList<Customer>();


	












	@Override
	public String toString() {
		return "Role [idrole=" + idrole + ", Role=" + Role + "]";
	}

	
   




	public Role(int idrole, String role) {
	super();
	this.idrole = idrole;
	Role = role;
}

public Role() {}





	public int getIdrole() {
		return idrole;
	}


	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}


	public String getRole() {
		return Role;
	}


	public void setRole(String role) {
		Role = role;
	}

	
	
}
