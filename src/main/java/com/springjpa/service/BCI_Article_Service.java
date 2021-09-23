package com.springjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.repo.BCI_Article_Repository;

@Service
public class BCI_Article_Service {
	@Autowired
	BCI_Article_Repository BCIA;
	
	public void INSERTBCI_ARTICLEs(int quantite,int id_article,String idbci) {
		System.out.print("WORKS!!!!!!!!!");
		BCIA.INSERTBCI_ARTICLEs(quantite, id_article, idbci);
	}
	public List listINVOICEBCI(String CodeBCI) {
		List List=BCIA.listINVOICEBCI(CodeBCI);
		return List;
	}
}
