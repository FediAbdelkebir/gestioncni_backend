package com.springjpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.springjpa.model.BCE_Article;
import com.springjpa.model.BCI_Article;

public interface BCE_Article_Repository extends JpaRepository<BCE_Article,Long>{
	@Query(value="SELECT * FROM bce_article a WHERE a.idbce = idbce ",nativeQuery = true)
	List<BCE_Article> findBCE_Article(@Param("code_bce") String code_bce);
    
    @Query(value="SELECT id FROM bce_article a WHERE a.idbce = :idbce ",nativeQuery = true)
    int findByid(@Param("idbce") String idbce);
    
    @Query(value="SELECT * FROM bce_article ",nativeQuery = true)
    List<BCE_Article> findallBCE_ARTICLEs();
    
    @Transactional
    @Modifying
    @Query(value="INSERT INTO bce_article(quantite,prix,id_article,idbce) VALUES(:quantite,:prix,:id_article,:idbce) ",nativeQuery = true)
    public void INSERTBCE_ARTICLEs(@Param("quantite") int quantite,@Param("prix") float prix,@Param("id_article") int id_article,@Param("idbce")String idbce);

    @Query(value="SELECT * FROM bce_article where idbce= :codeBCE",nativeQuery = true)
	List listINVOICE(@Param("codeBCE") String codeBCE);
}

