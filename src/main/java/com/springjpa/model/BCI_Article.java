package com.springjpa.model;

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
@Table(name="BCI_Article" ,schema="public")
public class BCI_Article {
	private static final long serialVersionUID=-3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity=BCI.class,cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name="idBCI")
	private BCI id_BCI;
	
	@ManyToOne(targetEntity=Article.class,cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name="id_article")
	private Article id_Article;
	
	@Column(name="Quantite")
	private int Quantite;

	public BCI getId_BCI() {
		return id_BCI;
	}

	public void setId_BCI(BCI id_BCI) {
		this.id_BCI = id_BCI;
	}

	public Article getId_Article() {
		return id_Article;
	}

	public void setId_Article(Article id_Article) {
		this.id_Article = id_Article;
	}

	public int getQuantite() {
		return Quantite;
	}

	public void setQuantite(int quantite) {
		Quantite = quantite;
	}

	public int getId() {
		return id;
	}
	
}
