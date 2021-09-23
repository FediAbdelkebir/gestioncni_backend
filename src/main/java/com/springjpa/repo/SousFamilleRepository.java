package com.springjpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.springjpa.model.SousFamille;

public interface SousFamilleRepository extends JpaRepository<SousFamille,Long>{

	@Query(value="SELECT * FROM sousfamille a WHERE a.NomSousFamille = :NomSousFamille ",nativeQuery = true)
    String findSousFamille(@Param("NomSousFamille") String NomSousFamille);
    
    
    @Query(value="SELECT id FROM sousfamille a WHERE a.NomSousFamille = :NomSousFamille ",nativeQuery = true)
    int findByid(@Param("NomSousFamille") String NomSousFamille);
    
    @Query(value="SELECT * FROM sousfamille ",nativeQuery = true)
    List<SousFamille> findallSousFamilles();
    
    @Transactional
    @Modifying
    @Query(value="UPDATE sousfamille SET NomSousFamille= :NomSousFamille where id = :id ",nativeQuery = true)
    void update(@Param("id") int id,@Param("NomSousFamille") String NomSousFamille);
    
    @Transactional
    @Modifying
    @Query(value="DELETE FROM sousfamille WHERE id = :id ",nativeQuery = true)
    void delete(@Param("id") int id);
}
