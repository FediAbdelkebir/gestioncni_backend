package com.springjpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springjpa.model.Article;
@Service
public interface ArticleRepository extends JpaRepository<Article,Long>{
	
	@Query(value="SELECT * FROM article a WHERE a.id_structure = :CodeStruct ",nativeQuery = true)
	List<Article> findallArticles(@Param("CodeStruct") String CodeStruct);
	
	@Query(value="SELECT * FROM article a WHERE a.title = :title ",nativeQuery = true)
    String findArticle(@Param("title") String title);
    
    
    @Query(value="SELECT id_article FROM article a WHERE a.title = :title ",nativeQuery = true)
    int findByid(@Param("title") String title);
    
    
    @Transactional
    @Modifying
    @Query(value="UPDATE article SET title= :title,label= :label,description= :description,prix= :prix WHERE id_article = :id ",nativeQuery = true)
    void update(@Param("id") int id,@Param("title") String title, @Param("label") String label,@Param("description") String description,@Param("prix") int prix);
    
    @Transactional
    @Modifying
    @Query(value="DELETE FROM article WHERE id_article = :id ",nativeQuery = true)
    void delete(@Param("id") int id);

    @Query(value="SELECT title FROM article a WHERE a.id_article = :id ",nativeQuery = true)
    String NameArticle(@Param("id") int id);
}
