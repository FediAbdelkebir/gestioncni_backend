package com.springjpa.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="customer" ,schema="public")

public class Customer implements Serializable{
	
private static final long serialVersionUID=-3009157732242241606L;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id")
private int id;

@Column(name="Name", nullable=false)
private String name;

@Column(name="LastName", nullable=false)
private String lastname;

@Column(name="email", nullable=false) 
private String email;

@Column(name="password", nullable=false)
private String password;

@Column(name="phone", nullable=false)
private int tel;

/*Tab3th wala trj3 l object Role */
/* @JsonBackReference*/
@ManyToOne(targetEntity=Role.class,cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
@JoinColumn(name="idrole")
public Role role;

/* @JsonBackReference*/
@ManyToOne(targetEntity=Structure.class,cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
@JoinColumn(name="idStructure")
public Structure Structure;

public Structure getStructure() {
	return Structure;
}

@Override
public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", lastname=" + lastname + ", email=" + email + ", password="
			+ password + ", tel=" + tel + ", role=" + role + ", Structure=" + Structure + "]";
}


public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public String getLastname() {
	return lastname;
}



public void setLastname(String lastname) {
	this.lastname = lastname;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}



public int getTel() {
	return tel;
}



public void setTel(int tel) {
	this.tel = tel;
}



@JsonBackReference("Role-Customer")
public Role getRole() {
	return role;
}



public void setRole(Role role) {
	this.role = role;
}

public Customer(int id, String name, String lastname, String email, String password, int tel, Role role,
		com.springjpa.model.Structure structure) {
	super();
	this.id = id;
	this.name = name;
	this.lastname = lastname;
	this.email = email;
	this.password = password;
	this.tel = tel;
	this.role = role;
	Structure = structure;
}

public Customer() {}






}