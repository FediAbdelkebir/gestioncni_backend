package com.springjpa.model;
import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name="sousstructure" ,schema="public")
public class SousStructure implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int ids;

	@Id
	@Column(name="Nom", nullable=false)
	private String Nom;

	@ManyToOne(targetEntity=Structure.class,cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name="idstructure")
	private Structure structure;
	
	public int getIds() {
		return ids;
	}

	public void setIds(int ids) {
		this.ids = ids;
	}

	
	public void setStructure(Structure structure) {
		this.structure = structure;
	}

	public Structure getStructure() {
		return structure;
	}


	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	

	public SousStructure(String nom, Structure structure) {
		super();
		Nom = nom;
		this.structure = structure;
	}

	

	@Override
	public String toString() {
		return "SousStructure [ids=" + ids + ", Nom=" + Nom + ", structure=" + structure + "]";
	}

	public SousStructure() {}

	}


