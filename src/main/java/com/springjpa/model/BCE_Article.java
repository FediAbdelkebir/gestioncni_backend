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
import javax.persistence.Table;

@Entity
@Table(name="BCE_Article" ,schema="public")

public class BCE_Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity=BCE.class,cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name="idBCE")
	private BCE id_BCE;
	
	@ManyToOne(targetEntity=Article.class,cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name="id_article")
	private Article id_Article;
	
	@Column(name="Quantite")
	private int Quantite;
	
	@Column(name="Prix")
	private float prix;

	public BCE_Article(BCE id_BCE, Article id_Article, int quantite, float prix) {
		super();
		this.id_BCE = id_BCE;
		this.id_Article = id_Article;
		Quantite = quantite;
		this.prix = prix;
	}
public BCE_Article() {}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BCE getId_BCE() {
		return id_BCE;
	}

	public void setId_BCE(BCE id_BCE) {
		this.id_BCE = id_BCE;
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

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "BCE_Article [id=" + id + ", id_BCE=" + id_BCE + ", id_Article=" + id_Article + ", Quantite=" + Quantite
				+ ", prix=" + prix + "]";
	}
	
	
}
