package com.springjpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springjpa.model.SousStructure;


public interface SousStructure_Repository extends JpaRepository<SousStructure,Long>{

	@Query(value="SELECT * FROM soustructure a WHERE a.Nom = :Nom ",nativeQuery = true)
    String findSousStructure(@Param("Nom") String Nom);
    
    @Query(value="SELECT id FROM sousstructure a WHERE a.Nom = :Nom ",nativeQuery = true)
    int findByid(@Param("Nom") String Nom);
    
    @Query(value="SELECT * FROM sousstructure WHERE idstructure = :CodeStruct ",nativeQuery = true)
    List<SousStructure> findallSousStructures(@Param("CodeStruct") String CodeStruct);
    
    @Transactional
    @Modifying
    @Query(value="UPDATE sousstructure SET Nom= :Nom where Nom = :nom and idstructure = :CodeStruct",nativeQuery = true)
    void update(@Param("nom") String nom,@Param("Nom") String Nom,@Param("CodeStruct") String CodeStruct);
    
    @Transactional
    @Modifying
    @Query(value="DELETE FROM sousstructure WHERE nom = :nom and idstructure =:CodeStruct",nativeQuery = true)
    void delete(@Param("nom") String nom,@Param("CodeStruct") String CodeStruct);
}