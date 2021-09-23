package com.springjpa.model;

import java.io.Serializable;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="article" ,schema="public")
public class Article implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_article")
	private int id;

	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="label", nullable=false)
	private String label;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="prix", nullable=false)
	private int prix;

	@ManyToOne(targetEntity=Structure.class,cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="idStructure")
	public Structure Structure;
	
	@ManyToOne(targetEntity=Famille.class,cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="Famille")
	public Famille Famille;

	public Famille getFamille() {
		return Famille;
	}
	@ManyToOne(targetEntity=SousFamille.class,cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="SousFamille")
	public SousFamille SousFamille;

	public SousFamille getSousFamille() {
		return SousFamille;
	}

	
	public Structure getStructure() {
		return Structure;
	}

	public void setStructure(Structure structure) {
		Structure = structure;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}


	public Article(String title, String label, String description, int prix, com.springjpa.model.Structure structure,
			com.springjpa.model.Famille famille, com.springjpa.model.SousFamille sousFamille) {
		super();
		this.title = title;
		this.label = label;
		this.description = description;
		this.prix = prix;
		Structure = structure;
		Famille = famille;
		SousFamille = sousFamille;
		
	}
	

	public Article() {}
}
