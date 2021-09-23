package com.springjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.model.BCE;
import com.springjpa.model.BCI;
import com.springjpa.repo.BCERepository;

@Service
public class BCEService {

	@Autowired
	BCERepository BCER;
	
	public BCE ajouterBCE(BCE bce) {
		BCE _bce = BCER.save(new BCE(bce.getCode_BCE(),bce.getDate(),bce.getEtat(),bce.getStructure(),bce.getSousstructure()));
		System.out.print(_bce);
		return _bce;
	}
	public void ApproveBCE(String idc,String etat) {
		 BCER.ApproveBCE(idc,etat);
	}
	public void DeclineBCE(String idc,String etat) {
		BCER.DeclineBCE(idc,etat);
	}
	public List findall(String CodeStruct) {
		List<BCE> List= BCER.findallBCEs(CodeStruct);
		System.out.print(List);
		return List;
	}
}
