package com.springjpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="famille" ,schema="public")
public class Famille implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Id
	@Column(name="NomFamille",unique=true, nullable=false)
	private String NomFamille;

	public String getNomFamille() {
		return NomFamille;
	}

	public void setNomFamille(String nomFamille) {
		NomFamille = nomFamille;
	}
public Famille() {}
	public Famille(int id, String nomFamille) {
		super();
		this.id = id;
		NomFamille = nomFamille;
	}

	@Override
	public String toString() {
		return "Famille [id=" + id + ", NomFamille=" + NomFamille + "]";
	}
}
