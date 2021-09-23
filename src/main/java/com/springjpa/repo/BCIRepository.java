package com.springjpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.springjpa.model.BCI;

@Service
public interface BCIRepository extends JpaRepository<BCI,Long>{
	@Query(value="SELECT * FROM bci a WHERE a.code_bci = :code_bci ",nativeQuery = true)
	List<BCI> findBCI(@Param("code_bci") String code_bci);
    
    
    @Query(value="SELECT id FROM bci a WHERE a.code_bci = :code_bci ",nativeQuery = true)
    int findByid(@Param("code_bci") String code_bci);
    
    @Query(value="SELECT * FROM bci WHERE id_structure= :CodeStruct",nativeQuery = true)
    List<BCI> findallBCIs(@Param("CodeStruct") String CodeStruct);
    
    @Transactional
    @Modifying
    @Query(value="UPDATE bci SET code_bci= :code_bci,etat= :etat,quantite= :quantite WHERE code_bci = :code_bci ",nativeQuery = true)
    void update(@Param("code_bci") String code_bci, @Param("etat") String etat,@Param("quantite") int quantite);
    
    @Transactional
    @Modifying
    @Query(value="UPDATE bci SET etat= :etat WHERE code_bci = :code_bci ",nativeQuery = true)
    void ApproveBCI(@Param("code_bci") String code_bci,@Param("etat") String etat);
    
    @Transactional
    @Modifying
    @Query(value="UPDATE bci SET etat= :etat WHERE code_bci = :code_bci ",nativeQuery = true)
    void DeclineBCI(@Param("code_bci") String code_bci,@Param("etat") String etat);
    
    @Transactional
    @Modifying
    @Query(value="DELETE FROM bci WHERE code_bci = :code_bci ",nativeQuery = true)
    void delete(@Param("code_bci") String code_bci);

}
