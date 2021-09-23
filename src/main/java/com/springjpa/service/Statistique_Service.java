package com.springjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.repo.Statistiques_Repository;

@Service
public class Statistique_Service {
	@Autowired
	Statistiques_Repository SRP;
	public int StatnbrBCE(String CodeStruct) {
		return SRP.StatnbrBCE(CodeStruct);
	}
	
	public int StatnbrBCI(String CodeStruct) {
		return SRP.StatnbrBCI(CodeStruct);
	}
	public int StatnbrArticle(String CodeStruct) {
		return SRP.StatnbrArticle(CodeStruct);
	}
	public int Statnbrcustomer(String CodeStruct) {
		return SRP.Statnbrcustomer(CodeStruct);
	}
	public int StatnbrRole() {
		return SRP.StatnbrRole();
	}
	public int StatnbrStructure() {
		return SRP.StatnbrStructure();
	}
	public int Statnbrcustomer_SuperAdmin(String CodeStruct) {
		return SRP.Statnbrcustomer_SuperAdmin(CodeStruct);
	}
	public int Statnbrcustomer_Admin(String CodeStruct) {
		return SRP.Statnbrcustomer_Admin(CodeStruct);
	}
	public int Statnbrcustomer_RFournisseurn(String CodeStruct) {
		return SRP.Statnbrcustomer_RFournisseurn(CodeStruct);
	}
	public int Statnbrcustomer_AFournisseur(String CodeStruct) {
		return SRP.Statnbrcustomer_AFournisseur(CodeStruct);
	}
	public int Statnbrcustomer_RMagasin(String CodeStruct) {
		return SRP.Statnbrcustomer_RMagasin(CodeStruct);
	}
	public int Statnbrcustomer_AMagasinAdmin(String CodeStruct) {
		return SRP.Statnbrcustomer_AMagasinAdmin(CodeStruct);
	}
	
}
