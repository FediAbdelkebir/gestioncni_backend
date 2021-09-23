package com.springjpa.controller;

import java.security.Principal;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.model.Article;
import com.springjpa.model.BCE;
import com.springjpa.model.BCE_Article;
import com.springjpa.model.BCI;
import com.springjpa.model.Customer;
import com.springjpa.model.Famille;/*
import com.springjpa.model.Fournisseur;
import com.springjpa.model.Magasin;*/
import com.springjpa.model.Role;
import com.springjpa.model.SousFamille;
import com.springjpa.model.Stock;
import com.springjpa.model.Structure;
import com.springjpa.repo.ArticleRepository;
import com.springjpa.repo.BCERepository;
import com.springjpa.repo.BCIRepository;
import com.springjpa.repo.BCI_Article_Repository;
import com.springjpa.repo.FamilleRepository;/*
import com.springjpa.repo.FournisseurRepository;
import com.springjpa.repo.MagasinRepository;*/
import com.springjpa.repo.RoleRepository;
import com.springjpa.repo.SousFamilleRepository;
import com.springjpa.repo.StructureRepository;
import com.springjpa.service.ArticleService;
import com.springjpa.service.BCEService;
import com.springjpa.service.BCE_Article_Service;
import com.springjpa.service.BCIService;
import com.springjpa.service.BCI_Article_Service;/*
import com.springjpa.service.FournisseurService;
import com.springjpa.service.MagasinService;*/
import com.springjpa.service.RoleService;
import com.springjpa.service.SousStructureService;
import com.springjpa.service.Statistique_Service;
import com.springjpa.service.StockService;
import com.springjpa.service.StructureService;
import com.springjpa.service.UserService;
import com.cni.security.BCrypt;;
@RestController
@CrossOrigin

public class WebController {
	private static String secretKey = "isverysecret";
	private static String salt = "saltysalt";/*
@Autowired
FournisseurService FS;/*
@Autowired
MagasinService MS;*/
@Autowired
ArticleService AS;
@Autowired
StructureService SS;
@Autowired
RoleService RR;
@Autowired
BCIService BCIS;
@Autowired
BCEService BCES;
@Autowired
FamilleRepository FR;
@Autowired
SousFamilleRepository SFR;
BCrypt BCrypt;
@Autowired
UserService US;
@Autowired
BCI_Article_Service BCIAS;
@Autowired
BCE_Article_Service BCEAS;
@Autowired
Statistique_Service StatS;
@Autowired
StockService STKS;
@Autowired
SousStructureService SSS;

@PostMapping(value = "/register")
public Customer postCustomer(@RequestBody Customer customer) {
	US.Register(customer);
	return customer;
}

@PostMapping(value = "/dashboard/ajouterBCI")
public BCI postBCI(@RequestBody BCI bci) {
return BCIS.ajouterBCI(bci);
}
@PostMapping(value = "/dashboard/ajouterarticle")
public Article postarticle(@RequestBody Article article) {
	return AS.postarticle(article);
}
@PostMapping(value = "/dashboard/ajouterstructure")
public Structure postStructure(@RequestBody Structure structure) {
	return SS.ajouterstructure(structure);
}
@PostMapping(value = "/dashboard/ajouterBCE")
public BCE postBCE(@RequestBody BCE bce) {
	return BCES.ajouterBCE(bce);
}
@PostMapping(value = "/AjouterStock")
public Stock postBCE(@RequestBody Stock Stock) {
	return STKS.ajouterStock(Stock);
}
@RequestMapping("/dashboard/QTE_COURANTE/{idarticle}/{code}")
public int QTE_COURANTE(@PathVariable("idarticle") int idarticle,@PathVariable("code") String code) {
return STKS.QTE_COURANTE(idarticle,code);
}
@RequestMapping("/dashboard/QTE_INITIAl/{idarticle}/{code}")
public int QTE_INITIAl(@PathVariable("idarticle") int idarticle,@PathVariable("code") String code) {
return STKS.QTE_INITIAl(idarticle,code);
}
@RequestMapping("/login/{email}/{password}")
public boolean login(@PathVariable("email") String email,@PathVariable("password") String password) {
return US.login(email, password);
}
@RequestMapping("/account/{email}")
public int account(@PathVariable("email") String email) {
	int result;
   result=US.account(email);
	System.out.print("True"+result);
	return result;
}
@RequestMapping("/account/id/{email}")
public int findid(@PathVariable("email")String email) {
	return US.findid(email);
}
@RequestMapping("/account/{id}/{email}/{lastname}/{name}/{password}/{tel}")
public void update(@PathVariable("id") int id,@PathVariable("email") String email,@PathVariable("lastname") String lastname,@PathVariable("name") String name,@PathVariable("password") String password,@PathVariable("tel") int tel) {
  US.update(id,email,lastname,name,password,tel);
}
@RequestMapping("/dashboard/structure/{code}/{lib_ar}/{lib_latin}")
public void updates(@PathVariable("code") String code,@PathVariable("lib_ar") String lib_ar,@PathVariable("lib_latin") String lib_latin) {
	
  SS.update(code,lib_ar,lib_latin);
}/*
@RequestMapping("/dashboard/fournisseur/{idf}/{nomf}/{addressf}/{numerof}")
public void updatef(@PathVariable("idf") int idf,@PathVariable("nomf") String nomf,@PathVariable("addressf") String addressf,@PathVariable("numerof") int numerof) {
  FS.update(idf,addressf,nomf,numerof);
}/*
@RequestMapping("/dashboard/magasin/{idm}/{magasin}/{addressm}/{numm}")
public void updatem(@PathVariable("idm") int idm,@PathVariable("magasin") String magasin,@PathVariable("addressm") String addressm,@PathVariable("numm") int numm) {
  MS.update(idm,addressm,magasin,numm);
}*/
@RequestMapping("/dashboard/article/{ida}/{titlea}/{labela}/{descriptiona}/{prixa}")
public void updatea(@PathVariable("ida") int ida,@PathVariable("titlea") String titlea,@PathVariable("labela") String labela,@PathVariable("descriptiona") String descriptiona,@PathVariable("prixa") int prixa) {
  AS.update(ida,titlea,labela,descriptiona,prixa);
}
@RequestMapping("/dashboard/BCI/Approve/{idc}/{etat}")
public void ApproveBCI(@PathVariable("idc") String idc,@PathVariable("etat") String etat) {
  BCIS.ApproveBCI(idc,etat);
}
@RequestMapping("/dashboard/BCE/Approve/{idc}/{etat}")
public void ApproveBCE(@PathVariable("idc") String idc,@PathVariable("etat") String etat) {
  BCES.ApproveBCE(idc,etat);
}
@RequestMapping("/dashboard/BCE/Decline/{idc}/{etat}")
public void DeclineBCE(@PathVariable("idc") String idc,@PathVariable("etat") String etat) {
  BCES.DeclineBCE(idc,etat);
}
@RequestMapping("/dashboard/BCI/Decline/{idc}/{etat}")
public void DeclineBCI(@PathVariable("idc") String idc,@PathVariable("etat") String etat) {
  BCIS.DeclineBCI(idc,etat);
}

@RequestMapping("/account/delete/{id}")
public void delete(@PathVariable("id") int id) {
  US.delete(id);
}
/*
@RequestMapping("/fournisseur/delete/{id}")
public void deletefournisseur(@PathVariable("id") int idf) {
  FS.delete(idf);
}*/
@RequestMapping("/structure/delete/{code}")
public void deletestructure(@PathVariable("code") String code) {
  SS.delete(code);
}

@RequestMapping("/article/delete/{id}")
public void deletearticle(@PathVariable("id") int ida) {
  AS.delete(ida);
}


@RequestMapping("/findall/{CodeStruct}")
public List<Customer> findallCustomers(@PathVariable("CodeStruct") String CodeStruct) {
return US.findall(CodeStruct);
}
@RequestMapping("/dashboard/findallfamilles")
public List<Famille> findallFamilles() {
	List<Famille> List= FR.findAll();
	System.out.print(List);
	return List;
}
@RequestMapping("/dashboard/findallsousfamilles")
public List<SousFamille> findallSousFamilles() {
	List<SousFamille> List= SFR.findAll();
	System.out.print(List);
	return List;
}/*
@RequestMapping("/dashboard/findallproviders/{CodeStruct}")
public List<Fournisseur> findallfournisseurs(@PathVariable("CodeStruct") String CodeStruct) {
	return FS.findall(CodeStruct);
}*/
@RequestMapping("/dashboard/findallstructures")
public List<Structure> findallstructures() {
	return SS.findall();
}
/*
@RequestMapping("/dashboard/findallmagasins")
public List<Magasin> findallmagasins() {
	return MS.findall();
}*/
@RequestMapping("/dashboard/findallBCI/{CodeStruct}")
public List<BCI> findallBCI(@PathVariable("CodeStruct") String CodeStruct) {
	return BCIS.findall(CodeStruct);
}
@RequestMapping("/dashboard/findallBCE/{CodeStruct}")
public List<BCE> findallBCE(@PathVariable("CodeStruct") String CodeStruct) {
	return BCES.findall(CodeStruct);
}

@RequestMapping("/dashboard/findallarticles/{CodeStruct}")
public List<Article> findallArticles(@PathVariable("CodeStruct") String CodeStruct) {
	return AS.findall(CodeStruct);
}
@RequestMapping("/dashboard/roles")
public List<Role> findallroles() {
	return RR.findallroles();
}

@RequestMapping("/user")
public Principal user(HttpServletRequest request) {
    String authToken = request.getHeader("Authorization")
      .substring("Basic".length()).trim();
    return () ->  new String(Base64.getDecoder()
      .decode(authToken)).split(":")[0];
}

@RequestMapping("/findR/{email}")
public String findR(@PathVariable("email") String email) {
return US.findR(email);
}
@RequestMapping("/findS/{email}")
public String findS(@PathVariable("email") String email) {
return US.findS(email);
}
@RequestMapping("/findID/{codeSt}")
public String findID(@PathVariable("codeSt") String codeSt) {
return SS.findID(codeSt);
}
@RequestMapping("/findSAR/{codeSt}")
public String findSAR(@PathVariable("codeSt") String codeSt) {
return SS.findSAR(codeSt);
}
@RequestMapping("/findSLIB/{codeSt}")
public String findSLIB(@PathVariable("codeSt") String codeSt) {
return SS.findSLIB(codeSt);
}
@RequestMapping("/findAllCustomerRoles")
public List findCustomerRoles() {
return US.findcustomerroles();
}

@RequestMapping("/findAllcustomerstructure")
public List findcustomerstructure() {
return SS.findAllcustomerstructure();
}
@RequestMapping("/dashboard/NameArticle/{id}")
public String NameArticle(@PathVariable("id") int id) {
	return AS.NameArticle(id);
}
/*Bande Commande*/
/*Insert BCE_Article/BCI_Article*/
@RequestMapping("/dashboard/BCIA/{quantite}/{id_article}/{idbci}/")
public void INSERT_BCIA(@PathVariable("quantite") int quantite,@PathVariable("id_article") int id_article,@PathVariable("idbci") String idbci) {
	
  BCIAS.INSERTBCI_ARTICLEs(quantite,id_article,idbci);
}

@RequestMapping("/BCEA/{quantite}/{prix}/{id_article}/{idbce}")
public void INSERT_BCEA(@PathVariable("quantite") int quantite,@PathVariable("prix") float prix,@PathVariable("id_article") int id_article,@PathVariable("idbce") String idbce) {
	System.out.print("WORKS HERE");
  BCEAS.INSERTBCE_ARTICLEs(quantite,prix,id_article,idbce);
}
@RequestMapping("/dashboard/INVOICE/{CodeBCE}")
public List INVOICE(@PathVariable("CodeBCE") String CodeBCE) {
  return BCEAS.listINVOICE(CodeBCE);
}

@RequestMapping("/dashboard/INVOICEBCI/{CodeBCI}")
public List INVOICEBCI(@PathVariable("CodeBCI") String CodeBCI) {
  return BCIAS.listINVOICEBCI(CodeBCI);
}
/*Insert BCE_Article/BCI_Article*/
/*SousStructure*/
@PostMapping(value = "/dashboard/AjouterSousStructure")
public com.springjpa.model.SousStructure postCustomer(@RequestBody com.springjpa.model.SousStructure SousStructure) {
	SSS.ajouterstructure(SousStructure);
	return SousStructure;
}
@RequestMapping("/dashboard/SousStructure/{CodeStruct}")
public List SousStructure(@PathVariable("CodeStruct") String CodeStruct) {
  return SSS.findAllsousstructure(CodeStruct);
  }
@RequestMapping("/SousStructure/delete/{nom}/{CodeStruct}")
public void deleteSousStructure(@PathVariable("nom") String nom,@PathVariable("CodeStruct") String CodeStruct) {
   SSS.delete(nom,CodeStruct);
  }
@RequestMapping("/dashboard/Sousstructure/{nom}/{newname}/{CodeStruct}")
public void updateSousStructure(@PathVariable("nom") String nom,@PathVariable("newname") String newname,@PathVariable("CodeStruct") String CodeStruct) {
   SSS.update(nom,newname,CodeStruct);
  }
@RequestMapping("/dashboard/UpdateINVOICE_BCI/{idarticle}/{quantite}/{code}")
public boolean UpdateINVOICE_BCI(@PathVariable("idarticle") int idarticle,@PathVariable("quantite") int quantite,@PathVariable("code") String code){
	
	int QTE=STKS.QTE_COURANTE(idarticle, code);
	if(QTE<quantite) {
		return false;
	}
	else {
		int QTI=STKS.QTE_INITIAl(idarticle, code);
		QTE=QTE-quantite;
		
		STKS.update(idarticle,QTE,QTI);
		
		return true;
	}
	
	
	
}
@RequestMapping("/dashboard/UpdateINVOICE_BCE/{idarticle}/{quantite}/{code}")
public boolean UpdateINVOICE_BCE(@PathVariable("idarticle") int idarticle,@PathVariable("quantite") int quantite,@PathVariable("code") String code){
	
	int QTE=STKS.QTE_COURANTE(idarticle, code);
	if(QTE<quantite) {
		return false;
	}
	else {
		int QTI=STKS.QTE_INITIAl(idarticle, code);
		QTE=QTE+quantite;
		STKS.update(idarticle,QTE,QTI);
		return true;
	}
	
	
	
}
 /*SousStructure */
/*Statistiques*/
@RequestMapping("/Stat/nbrBCE/{CodeStruct}")
public int StatnbrBCE(@PathVariable("CodeStruct") String CodeStruct) {
	return StatS.StatnbrBCE(CodeStruct);
}
@RequestMapping("/Stat/nbrBCI/{CodeStruct}")
public int StatnbrBCI(@PathVariable("CodeStruct") String CodeStruct) {
	return StatS.StatnbrBCI(CodeStruct);
}
@RequestMapping("/Stat/StatnbrArticle/{CodeStruct}")
public int StatnbrArticle(@PathVariable("CodeStruct") String CodeStruct) {
	return StatS.StatnbrArticle(CodeStruct);
}
@RequestMapping("/Stat/Statnbrcustomer/{CodeStruct}")
public int Statnbrcustomer(@PathVariable("CodeStruct") String CodeStruct) {
	return StatS.Statnbrcustomer(CodeStruct);
}
@RequestMapping("/Stat/StatnbrRole")
public int StatnbrRole() {
	return StatS.StatnbrRole();
}
@RequestMapping("/Stat/StatnbrStructure")
public int StatnbrStructure() {
	return StatS.StatnbrStructure();
}
@RequestMapping("/Stat/Statnbrcustomer_SuperAdmin/{CodeStruct}")
public int Statnbrcustomer_SuperAdmin(@PathVariable("CodeStruct") String CodeStruct) {
	return StatS.Statnbrcustomer_SuperAdmin(CodeStruct);
}
@RequestMapping("/Stat/Statnbrcustomer_Admin/{CodeStruct}")
public int Statnbrcustomer_Admin(@PathVariable("CodeStruct") String CodeStruct) {
	return StatS.Statnbrcustomer_Admin(CodeStruct);
}
@RequestMapping("/Stat/Statnbrcustomer_RFournisseurn/{CodeStruct}")
public int Statnbrcustomer_RFournisseurn(@PathVariable("CodeStruct") String CodeStruct) {
	return StatS.Statnbrcustomer_RFournisseurn(CodeStruct);
}
@RequestMapping("/Stat/Statnbrcustomer_AFournisseur/{CodeStruct}")
public int Statnbrcustomer_AFournisseur(@PathVariable("CodeStruct") String CodeStruct) {
	return StatS.Statnbrcustomer_AFournisseur(CodeStruct);
}
@RequestMapping("/Stat/Statnbrcustomer_RMagasin/{CodeStruct}")
public int Statnbrcustomer_RMagasin(@PathVariable("CodeStruct") String CodeStruct) {
	return StatS.Statnbrcustomer_RMagasin(CodeStruct);
}
@RequestMapping("/Stat/Statnbrcustomer_AMagasinAdmin/{CodeStruct}")
public int Statnbrcustomer_AMagasinAdmin(@PathVariable("CodeStruct") String CodeStruct) {
	return StatS.Statnbrcustomer_AMagasinAdmin(CodeStruct);
}
/*Statistiques*/
}
