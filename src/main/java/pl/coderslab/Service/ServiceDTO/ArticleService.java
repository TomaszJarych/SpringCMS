package pl.coderslab.Service.ServiceDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import pl.coderslab.DAO.ArticleDAO;
import pl.coderslab.DAO.AuthorDAO;
import pl.coderslab.DAO.CategoryDAO;
import pl.coderslab.DTO.ArticleDTO;
import pl.coderslab.entity.Article;

@Service
public class ArticleService {

  ArticleDAO dao;
  AuthorDAO authorDAO;
  CategoryDAO categoryDAO;

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

  public List<Article> getListByCategory(Long id) {
    return dao.getAticleListByCategory(id);
  }

  public List<Article> getList() {
    List<Article> list = dao.getArticleList();
    list.stream().forEachOrdered(article -> article.setContent(cutContnent(article.getContent())));

    return list;
  }

  public String cutContnent(String string) {
    return (string.length() > 200) ? string.substring(0, 200) + "..." : string;
  }

  private Article toEntity(ArticleDTO dto) {
    Article article;
    if (dto.getId() == null) {
      article = new Article();

    } else {
      article = dao.getArticleByID(dto.getId());
    }

    article.setTitle(dto.getTitle());
    article.setAuthor(authorDAO.getAuthorByID(dto.getAuthor().getId()));
    article.setContent(dto.getContent());
    if (dto.getUpdated() != null) {
      article.setUpdated(dto.getUpdated());
    }
    if (Objects.nonNull(dto.getCategories()) && !dto.getCategories().isEmpty()) {
      article.getCategories().clear();
      dto.getCategories()
          .stream()
          .map(el -> categoryDAO.getCategoryByID(el.getId()))
          .forEach(el -> article.getCategories().add(el));
    }

    return article;
  }
}
