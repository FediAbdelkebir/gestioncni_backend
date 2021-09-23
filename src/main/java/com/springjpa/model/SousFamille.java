package com.springjpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sousfamille" ,schema="public")
public class SousFamille implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Id
	@Column(name="NomSousFamille",unique=true, nullable=false)
	private String NomSousFamille;

	public SousFamille() {}

	public SousFamille(int id, String nomSousFamille) {
		super();
		this.id = id;
		NomSousFamille = nomSousFamille;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomSousFamille() {
		return NomSousFamille;
	}

	public void setNomSousFamille(String nomSousFamille) {
		NomSousFamille = nomSousFamille;
	}

	@Override
	public String toString() {
		return "SousFamille [id=" + id + ", NomSousFamille=" + NomSousFamille + "]";
	}
}
