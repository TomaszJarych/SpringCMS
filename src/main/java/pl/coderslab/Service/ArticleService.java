package pl.coderslab.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.coderslab.DAO.ArticleDAO;
import pl.coderslab.entity.Article;

@Service
public class ArticleService {

    ArticleDAO dao;

    public ArticleService(ArticleDAO dao) {
	this.dao = dao;
    }

    public Article addArticle(Article article) {
	dao.addArticle(article);
	return article;
    }

    public Article getArticleByID(Long id) {
	return dao.getArticleByID(id);
    }

    public void updateArticle(Article article) {
	article.setUpdated(LocalDateTime.now());
	dao.updateArticle(article);
    }

    public void deleteArticle(Article article) {
	dao.deleteArticle(article);
    }
    
    public List<Article> getListByCategory(Long id){
	return dao.getAticleListByCategory(id);
    }
    public List<Article> getList(){
	return dao.getArticleList();
    }
}
