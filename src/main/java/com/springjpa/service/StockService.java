package com.springjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cni.security.BCrypt;
import com.springjpa.model.Stock;
import com.springjpa.repo.StockRepository;

@Service
public class StockService {
	@Autowired
	StockRepository STKR;
	public Stock ajouterStock(Stock Stock) {
		Stock _Stock = STKR.save(new Stock(Stock.getArticle(),Stock.getQuantite_initial(),Stock.getQuantite(),Stock.getStructure()));
		System.out.print(_Stock);
		return _Stock;
	}
	public int QTE_COURANTE(int idarticle,String code) {
		return STKR.QTE_COURANTE(idarticle,code);
	}
	public int QTE_INITIAl(int idarticle, String code) {
		
		return STKR.QTE_INITIAl(idarticle,code);
	}
	public void update(int idarticle, int qTE,int qti) {
		// TODO Auto-generated method stub
		STKR.update(qTE,qti,idarticle);
	}
}
