package com.springjpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.springjpa.model.BCE;
import com.springjpa.model.BCI_Article;

@Service
public interface Statistiques_Repository extends JpaRepository<BCE,Long>{
	
	/*Statistique Nombres Des BCE*/	
    @Query(value="SELECT COUNT(*) FROM bce where id_structure = :CodeStruct",nativeQuery = true)
    int StatnbrBCE(@Param("CodeStruct") String CodeStruct);
    /*Statistique Nombres Des BCI*/
    @Query(value="SELECT COUNT(*) FROM bci where id_structure = :CodeStruct",nativeQuery = true)
    int StatnbrBCI(@Param("CodeStruct") String CodeStruct);
    /*Statistiques Nombres Des Article*/
    @Query(value="SELECT COUNT(*) FROM article where id_structure = :CodeStruct",nativeQuery = true)
    int StatnbrArticle(@Param("CodeStruct") String CodeStruct);
    /*Statistiques Nombres Des Utilisateurs*/
    @Query(value="SELECT COUNT(*) FROM customer where id_structure = :CodeStruct",nativeQuery = true)
    int Statnbrcustomer(@Param("CodeStruct") String CodeStruct);
    /*Statistiques Nombres Des Roles*/
    @Query(value="SELECT COUNT(*) FROM role ",nativeQuery = true)
    int StatnbrRole();
    /*Statistiques Nombres Des Structures*/
    @Query(value="SELECT COUNT(*) FROM structure ",nativeQuery = true)
    int StatnbrStructure();
    
    /*Nomre Des SuperAdmins*/
    @Query(value="SELECT COUNT(*) FROM customer where idrole =1 and id_structure = :CodeStruct",nativeQuery = true)
    int Statnbrcustomer_SuperAdmin(@Param("CodeStruct") String CodeStruct);
    /*Nomre Des Admins*/
    @Query(value="SELECT COUNT(*) FROM customer where idrole =2 and id_structure = :CodeStruct",nativeQuery = true)
    int Statnbrcustomer_Admin(@Param("CodeStruct") String CodeStruct);
    /*Nomre Des RespensableFournisseurs*/
    @Query(value="SELECT COUNT(*) FROM customer where idrole =3 and id_structure = :CodeStruct",nativeQuery = true)
    int Statnbrcustomer_RFournisseurn(@Param("CodeStruct") String CodeStruct);
    /*Nomre Des AgentFournisseur*/
    @Query(value="SELECT COUNT(*) FROM customer where idrole =4 and id_structure = :CodeStruct",nativeQuery = true)
    int Statnbrcustomer_AFournisseur(@Param("CodeStruct") String CodeStruct);
    /*Nomre Des RespensableMagasins*/
    @Query(value="SELECT COUNT(*) FROM customer where idrole =5 and id_structure = :CodeStruct",nativeQuery = true)
    int Statnbrcustomer_RMagasin(@Param("CodeStruct") String CodeStruct);
    /*Nomre Des SuperAdmins*/
    @Query(value="SELECT COUNT(*) FROM customer where idrole =6 and id_structure = :CodeStruct",nativeQuery = true)
    int Statnbrcustomer_AMagasinAdmin(@Param("CodeStruct") String CodeStruct);

}
