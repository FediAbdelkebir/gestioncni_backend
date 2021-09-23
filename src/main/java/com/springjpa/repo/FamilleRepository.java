package com.springjpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.springjpa.model.Famille;

public interface FamilleRepository extends JpaRepository<Famille,Long>{

	@Query(value="SELECT * FROM famille a WHERE a.NomFamille = :NomFamille ",nativeQuery = true)
    String findFamille(@Param("NomFamille") String NomFamille);
    
    
    @Query(value="SELECT id FROM famille a WHERE a.NomFamille = :NomFamille ",nativeQuery = true)
    int findByid(@Param("NomFamille") String NomFamille);
    
    @Query(value="SELECT * FROM famille ",nativeQuery = true)
    List<Famille> findallFamilles();
    
    @Transactional
    @Modifying
    @Query(value="UPDATE famille SET NomFamille= :NomFamille where id = :id ",nativeQuery = true)
    void update(@Param("id") int id,@Param("NomFamille") String NomFamille);
    
    @Transactional
    @Modifying
    @Query(value="DELETE FROM famille WHERE id = :id ",nativeQuery = true)
    void delete(@Param("id") int id);
}
