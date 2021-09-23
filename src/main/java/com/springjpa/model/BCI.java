package com.springjpa.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="BCI" ,schema="public")
public class BCI implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Id
	@Column(name="Code_BCI", nullable=false)
	private String Code_BCI;
	
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

	public Structure getStructure() {
		return Structure;
	}
	
	/*
	@ManyToOne(targetEntity=BCI_Article.class,cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name="BCI_Articles")
	private List<BCI_Article> BCI_Articles;
	
	
	public List<BCI_Article> getBCI_Articles() {
		return BCI_Articles;
	}


	public void setBCI_Articles(List<BCI_Article> bCI_Articles) {
		BCI_Articles = bCI_Articles;
	}
*/
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode_BCI() {
		return Code_BCI;
	}

	public void setCode_BCI(String code_BCI) {
		Code_BCI = code_BCI;
	}


	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}



public SousStructure getSousstructure() {
		return sousstructure;
	}


public BCI(String code_BCI, String date, String etat, com.springjpa.model.Structure structure,
		SousStructure sousstructure) {
	super();
	Code_BCI = code_BCI;
	this.date = date;
	this.etat = etat;
	Structure = structure;
	this.sousstructure = sousstructure;
}

public BCI() {}

	@Override
	public String toString() {
		return "BCI [id=" + id + ", Code_BCI=" + Code_BCI + ", date=" + date + ", etat=" + etat + ", BCI_Articles="
				+ /*BCI_Articles + */"]";
	}





	
}
