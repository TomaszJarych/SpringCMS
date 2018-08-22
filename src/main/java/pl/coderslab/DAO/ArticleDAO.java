package pl.coderslab.DAO;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Article;

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
}
