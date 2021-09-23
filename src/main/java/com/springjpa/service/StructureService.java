package com.springjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cni.security.BCrypt;
import com.springjpa.model.Structure;
import com.springjpa.repo.StructureRepository;

@Service
public class StructureService {

	private static String secretKey = "isverysecret";
	private static String salt = "saltysalt";
	@Autowired
	StructureRepository SR;
	
public Structure ajouterstructure(Structure structure) {
	Structure _structure = SR.save(new Structure(structure.getCode(),structure.getLib_ar(),structure.getLib_latin()));
	System.out.print(_structure);
	return _structure;
}

public void update(String code,String lib_ar,String lib_latin) {
	
	SR.update(code,lib_ar,lib_latin);
}

public void delete(String code) {
	SR.delete(code);
}
public List findAllcustomerstructure() {
	List List=SR.findAllcustomerstructure();
	System.out.println(List);
	return List;
}
public List findall() { 
	List<Structure> List= SR.findallStructures();
	System.out.print(List);
	return List;
}
public String findSAR(String codeSt) {
	System.out.println(codeSt);
	System.out.println("Structure");
	System.out.println(codeSt);
	System.out.println(SR.GetStructureAr(codeSt));
	return SR.GetStructureAr(codeSt);
}
public String findSLIB(String codeSt) {
	System.out.println(codeSt);
	System.out.println("Structure");
	System.out.println(codeSt);
	System.out.println(SR.GetStructurelib(codeSt));
	return SR.GetStructurelib(codeSt);
}
public String findID(String codeSt) {
	System.out.println(codeSt);
	System.out.println("Structure");
	System.out.println(codeSt);
	System.out.println(SR.GetStructureid(codeSt));
	return SR.GetStructureid(codeSt);
}
}
