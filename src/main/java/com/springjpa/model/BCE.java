package com.springjpa.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="BCE" ,schema="public")
public class BCE implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Id
	@Column(name="Code_BCE", nullable=false)
	private String Code_BCE;
	
	@Column(name="Date", nullable=false)
	private String date;
	
	@Column(name="etat", nullable=false)
	private String etat;

	@ManyToOne(targetEntity=Structure.class,cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="idStructure")
	public Structure Structure;
	
	@ManyToOne(targetEntity=SousStructure.class,cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="idSousStructure")
	public SousStructure sousstructure;
	
	
	public SousStructure getSousstructure() {
		return sousstructure;
	}
	public Structure getStructure() {
		return Structure;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode_BCE() {
		return Code_BCE;
	}

	public void setCode_BCE(String code_BCE) {
		Code_BCE = code_BCE;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	
	public BCE(String code_BCE, String date, String etat, com.springjpa.model.Structure structure,
			SousStructure sousstructure) {
		super();
		Code_BCE = code_BCE;
		this.date = date;
		this.etat = etat;
		Structure = structure;
		this.sousstructure = sousstructure;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public BCE() {}

	@Override
	public String toString() {
		return "BCE [id=" + id + ", Code_BCE=" + Code_BCE + ", date=" + date + ", etat=" + etat + "]";
	}

	
	
	
}
