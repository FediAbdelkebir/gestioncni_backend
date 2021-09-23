package com.springjpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import com.springjpa.model.Structure;



public interface StructureRepository extends JpaRepository<Structure,Long>{
	
    @Query(value="SELECT id FROM structure a WHERE a.code = :code ",nativeQuery = true)
    int findByid(@Param("code") String code);
    
    @Query(value="SELECT * FROM structure ",nativeQuery = true)
    List<Structure> findallStructures();
    
    @Transactional
    @Modifying
    @Query(value="UPDATE structure SET lib_ar= :lib_ar,lib_latin= :lib_latin WHERE code = :code ",nativeQuery = true)
    void update(@Param("code") String code,@Param("lib_ar") String lib_ar,@Param("lib_latin") String lib_latin);
    
    @Query(value="SELECT id_structure FROM customer",nativeQuery = true)
    List findAllcustomerstructure();
    
    @Query(value="SELECT lib_ar FROM structure a WHERE a.code = :codeSt",nativeQuery = true)
    String GetStructureAr(@Param("codeSt") String codeSt);
   
    @Query(value="SELECT lib_latin FROM structure a WHERE a.code = :codeSt",nativeQuery = true)
    String GetStructurelib(@Param("codeSt") String codeSt);
    
    @Query(value="SELECT id FROM structure a WHERE a.code = :codeSt",nativeQuery = true)
    String GetStructureid(@Param("codeSt") String codeSt);
    
    @Transactional
    @Modifying
    @Query(value="DELETE FROM structure WHERE code = :code ",nativeQuery = true)
    void delete(@Param("code") String code);
}
