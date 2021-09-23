package com.springjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.model.Article;
import com.springjpa.repo.ArticleRepository;

@Service
public class ArticleService {
	@Autowired
	ArticleRepository AR;
	
public Article postarticle(Article article) {
	Article _article = AR.save(new Article(article.getTitle(),article.getLabel(),article.getDescription(),article.getPrix(),article.getStructure(),article.getFamille(),article.getSousFamille()));
	System.out.print(_article);
	return _article;
}

public void update(int ida,String titlea,String labela,String descriptiona,int prixa) {
	AR.update(ida,titlea,labela,descriptiona,prixa);
}
public void delete(int ida) {
	AR.delete(ida);
}
public List findall(String CodeStruct) {
	List<Article> List= AR.findallArticles(CodeStruct);
	System.out.print(List);
	return List;
}

public String NameArticle(int id) {
	return AR.NameArticle(id);
	
}
}
