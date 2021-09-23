package com.springjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.model.BCI;
import com.springjpa.repo.BCIRepository;

@Service
public class BCIService {

	@Autowired
	BCIRepository BCIR;
	
public BCI ajouterBCI(BCI bci) {
	BCI _bci = BCIR.save(new BCI(bci.getCode_BCI(),bci.getDate(),bci.getEtat(),bci.getStructure(),bci.getSousstructure()));
	System.out.print(_bci);
	return _bci;
}
public void ApproveBCI(String idc,String etat) {
	BCIR.ApproveBCI(idc,etat);
}
public void DeclineBCI(String idc,String etat) {
	 BCIR.DeclineBCI(idc,etat);
}
public List findall(String CodeStruct) {
	List<BCI> List= BCIR.findallBCIs(CodeStruct);
	System.out.print(List);
	return List;
}
}
