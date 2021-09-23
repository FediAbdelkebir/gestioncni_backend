package com.springjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.model.SousStructure;
import com.springjpa.repo.SousStructure_Repository;

@Service
public class SousStructureService {

	@Autowired
	SousStructure_Repository SSR;
	
public SousStructure ajouterstructure(SousStructure sousstructure) {
	SousStructure _sousstructure = SSR.save(new SousStructure(sousstructure.getNom(),sousstructure.getStructure()));
	System.out.print(_sousstructure);
	return _sousstructure;
}

public void update(String nom,String Nom,String CodeStruct) {
	SSR.update(nom,Nom,CodeStruct);
}

public void delete(String nom,String CodeStruct) {
	SSR.delete(nom,CodeStruct);
}
public List findAllsousstructure(String CodeStruct) {
	List List=SSR.findallSousStructures(CodeStruct);
	System.out.println(List);
	return List;
}



}
