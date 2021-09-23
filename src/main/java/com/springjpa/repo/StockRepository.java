package com.springjpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.springjpa.model.Stock;
import com.springjpa.model.Structure;

public interface StockRepository extends JpaRepository<Stock,Long>{
    
    @Query(value="SELECT * FROM stock where id_structure= :code",nativeQuery = true)
    List<Stock> findallStock(@Param("code") String code);
    
    @Transactional
    @Modifying
    @Query(value="UPDATE stock SET quantite= :quantite,quantite_initial= :quantite_initial WHERE id_article= :article ",nativeQuery = true)
    void update(@Param("quantite") int quantite,@Param("quantite_initial") int quantite_initial,@Param("article") int article);

    @Query(value="SELECT quantite FROM stock where id_structure= :code and id_article= :idarticle ",nativeQuery = true)
	int QTE_COURANTE(@Param("idarticle") int idarticle , @Param("code") String code );

	 @Query(value="SELECT quantite_initial FROM stock where id_structure= :code and id_article= :idarticle ",nativeQuery = true)
		int QTE_INITIAl(@Param("idarticle") int idarticle , @Param("code") String code );


}
