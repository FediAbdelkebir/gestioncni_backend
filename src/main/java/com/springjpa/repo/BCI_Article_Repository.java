package com.springjpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springjpa.model.BCI_Article;

@Service
public interface BCI_Article_Repository extends JpaRepository<BCI_Article,Long>{

	@Query(value="SELECT * FROM bci_article a WHERE a.idbci = idbci ",nativeQuery = true)
	List<BCI_Article> findBCI_Article(@Param("code_bce") String code_bce);
    
    @Query(value="SELECT id FROM bci_article a WHERE a.idbci = :idbci ",nativeQuery = true)
    int findByid(@Param("idbci") String idbci);
    
    @Query(value="SELECT * FROM bci_article ",nativeQuery = true)
    List<BCI_Article> findallBCI_ARTICLEs();
    
    @Transactional
    @Modifying
    @Query(value="INSERT INTO bci_article(quantite,id_article,idbci) VALUES(:quantite,:id_article,:idbci) ",nativeQuery = true)
    public void INSERTBCI_ARTICLEs(@Param("quantite") int quantite,@Param("id_article") int id_article,@Param("idbci")String idbci);
    
    @Query(value="SELECT * FROM bci_article where idbci= :codeBCI",nativeQuery = true)
	List listINVOICEBCI(@Param("codeBCI") String codeBCI);
}
