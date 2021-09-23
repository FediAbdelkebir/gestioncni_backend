package com.springjpa.model;

import java.io.Serializable;
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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="stock" ,schema="public")
public class Stock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity=Article.class,cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name="idArticle")
	@OnDelete(action = OnDeleteAction.CASCADE)
	public Article idArticle;

	public Article getArticle() {
		return idArticle;
	}
	
	@Column(name="quantite")
	private int quantite;
	
	@Column(name="quantite_initial")
	private int quantite_initial;
	
	@ManyToOne(targetEntity=Structure.class,cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="idStructure")
	public Structure idStructure;

	public Structure getStructure() {
		return idStructure;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getQuantite_initial() {
		return quantite_initial;
	}

	public void setQuantite_initial(int quantite_initial) {
		this.quantite_initial = quantite_initial;
	}
	
	public Stock(com.springjpa.model.Article article, int quantite, int quantite_initial,
			com.springjpa.model.Structure structure) {
		super();
		idArticle = article;
		this.quantite = quantite;
		this.quantite_initial = quantite_initial;
		idStructure = structure;
	}
	
	public Stock() {}
	
}
