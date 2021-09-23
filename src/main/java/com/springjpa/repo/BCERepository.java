package com.springjpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springjpa.model.BCE;
import com.springjpa.model.BCI;

@Service
public interface BCERepository extends JpaRepository<BCE,Long>{

	@Query(value="SELECT * FROM bce a WHERE a.code_bce = :code_bce ",nativeQuery = true)
	List<BCE> findBCE(@Param("code_bce") String code_bce);
    
    @Query(value="SELECT id FROM bce a WHERE a.code_bce = :code_bce ",nativeQuery = true)
    int findByid(@Param("code_bce") String code_bce);
    
    @Query(value="SELECT * FROM bce WHERE id_structure= :CodeStruct",nativeQuery = true)
    List<BCE> findallBCEs(@Param("CodeStruct") String CodeStruct);
    
    @Transactional
    @Modifying
    @Query(value="UPDATE bce SET code_bce= :code_bce,etat= :etat,quantite= :quantite,WHERE code_bce= :code_bce ",nativeQuery = true)
    void updateBCE(@Param("code_bce") String code_bci, @Param("etat") String etat,@Param("quantite") int quantite);
    
    @Transactional
    @Modifying
    @Query(value="UPDATE bce SET etat= :etat WHERE code_bce = :code_bce ",nativeQuery = true)
    void ApproveBCE(@Param("code_bce") String code_bce,@Param("etat") String etat);
    
    @Transactional
    @Modifying
    @Query(value="UPDATE bce SET etat= :etat WHERE code_bce = :code_bce ",nativeQuery = true)
    void DeclineBCE(@Param("code_bce") String code_bce,@Param("etat") String etat);
    
    @Transactional
    @Modifying
    @Query(value="DELETE FROM bce WHERE code_bce = :code_bce ",nativeQuery = true)
    void deleteBCE(@Param("code_bce") String code_bce);

}
