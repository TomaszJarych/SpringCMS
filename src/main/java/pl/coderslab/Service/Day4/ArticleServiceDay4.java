package pl.coderslab.Service.Day4;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.DTO.ArticleDTO;
import pl.coderslab.Repository.ArticleRepository;
import pl.coderslab.Repository.AuthorRepository;
import pl.coderslab.Repository.CategoryRepository;
import pl.coderslab.entity.Article;

@Service
public class ArticleServiceDay4 {

  private final ArticleRepository articleRepository;
  private final AuthorRepository authorRepository;
  private final CategoryRepository categoryRepository;

  @Autowired
  public ArticleServiceDay4(
      ArticleRepository articleRepository,
      AuthorRepository authorRepository,
      CategoryRepository categoryRepository) {
    this.articleRepository = articleRepository;
    this.authorRepository = authorRepository;
    this.categoryRepository = categoryRepository;
  }

  public ArticleDTO addArticle(ArticleDTO dto) {
    return articleRepository.save(toEntity(dto)).toDto();
  }

  public ArticleDTO getArticleByID(Long id) {
    return articleRepository.findOne(id).toDto();
  }

  public ArticleDTO updateArticle(ArticleDTO dto) {
    Article article = toEntity(dto);
    article.setUpdated(LocalDateTime.now());
    articleRepository.save(article).toDto();

    return articleRepository.save(article).toDto();
  }

  public void deleteArticle(Long id) {
    articleRepository.delete(id);
  }

  //  public List<Article> getListByCategory(Long id) {
  //    return dao.getAticleListByCategory(id);
  //  }

  //  public List<Article> getList() {
  //    List<Article> list = dao.getArticleList();
  //    list.stream().forEachOrdered(article ->
  // article.setContent(cutContnent(article.getContent())));
  //
  //    return list;
  //  }

  public Collection<ArticleDTO> getAllArticles() {

    return articleRepository.findFirst5ByOrderByCreatedDesc().stream().limit(5).map(Article::toDto).collect(Collectors.toList());
  }

  public Collection<ArticleDTO> getAllDrafts() {

    return articleRepository.findAllDrafts().stream().map(Article::toDto).collect(Collectors.toList());
  }

  public String cutContnent(String string) {
    return (string.length() > 200) ? string.substring(0, 200) + "..." : string;
  }

  private Article toEntity(ArticleDTO dto) {
    Article article;
    if (dto.getId() == null) {
      article = new Article();

    } else {
      article = articleRepository.findOne(dto.getId());
    }

    article.setTitle(dto.getTitle());
    article.setAuthor(authorRepository.findOne(dto.getAuthor().getId()));
    article.setContent(dto.getContent());
    if (dto.getUpdated() != null) {
      article.setUpdated(dto.getUpdated());
    }
    article.setDraft(dto.isDraft());
    if (Objects.nonNull(dto.getCategories()) && !dto.getCategories().isEmpty()) {
      article.getCategories().clear();
      dto.getCategories()
          .stream()
          .map(el -> categoryRepository.findOne(el.getId()))
          .forEach(el -> article.getCategories().add(el));
    }
    return article;
  }
}
