package com.springjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.model.BCE_Article;
import com.springjpa.repo.BCE_Article_Repository;

@Service
public class BCE_Article_Service {
	@Autowired
	BCE_Article_Repository BCEAR;
	public void INSERTBCE_ARTICLEs(int quantite,float prix,int id_article,String idbce) {
		System.out.print("WORKS!!!!!!!!!");
		BCEAR.INSERTBCE_ARTICLEs(quantite,prix,id_article, idbce);
	}
	public List listINVOICE(String CodeBCE) {
		List List=BCEAR.listINVOICE(CodeBCE);
		return List;
	}
}
