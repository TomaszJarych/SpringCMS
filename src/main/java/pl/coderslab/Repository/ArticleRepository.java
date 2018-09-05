package pl.coderslab.Repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.coderslab.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{
    
    @Query("SELECT a FROM Article a WHERE a.draft = true order by a.created desc")
    Collection<Article> findAllDrafts();
    
    Collection<Article> findFirst5ByOrderByCreatedDesc();
    
}
