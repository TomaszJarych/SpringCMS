package pl.coderslab.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Article;
import pl.coderslab.entity.Category;

@Component
@Transactional
public class ArticleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Article addArticle(Article article) {
	entityManager.persist(article);
	return article;
    }

    public Article getArticleByID(Long id) {
	return entityManager.find(Article.class, id);
    }

    public void updateArticle(Article article) {
	entityManager.merge(article);
    }

    public void deleteArticle(Article article) {
	entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
    }

    public List<Article> getAticleListByCategory(Long id) {
	Query query = entityManager.createQuery(" SELECT a FROM Article a JOIN a.categories c WHERE c.id =:id");
	query.setParameter("id", id);
	List<Article> books = query.getResultList();
	return books;

    }

    public List<Article> getArticleList() {
	Query query = entityManager.createQuery(" SELECT a FROM Article a order by a.created desc").setMaxResults(5);
	List<Article> books = query.getResultList();
	return books;
    }
    
    public List<Article> getAllArticles() {
	Query query = entityManager.createQuery(" SELECT a FROM Article a order by a.created desc");
	List<Article> books = query.getResultList();
	return books;
    }
    
}
