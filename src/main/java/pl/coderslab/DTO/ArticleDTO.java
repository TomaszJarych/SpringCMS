package pl.coderslab.DTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArticleDTO {

  private Long id;

  private String title;

  private AuthorDTO author;

  private List<CategoryDTO> categories = new ArrayList<>();

  private String content;

  private LocalDateTime created;

  private LocalDateTime updated;

  public ArticleDTO(
      Long id,
      String title,
      AuthorDTO author,
      List<CategoryDTO> categories,
      String content,
      LocalDateTime updated) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.categories = categories;
    this.content = content;
    this.updated = updated;
  }

  public ArticleDTO(
      String title,
      AuthorDTO author,
      List<CategoryDTO> categories,
      String content,
      LocalDateTime updated) {
    this.title = title;
    this.author = author;
    this.categories = categories;
    this.content = content;
    this.updated = updated;
  }

  public ArticleDTO() {}

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public AuthorDTO getAuthor() {
    return author;
  }

  public List<CategoryDTO> getCategories() {
    return categories;
  }

  public String getContent() {
    return content;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public LocalDateTime getUpdated() {
    return updated;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(AuthorDTO author) {
    this.author = author;
  }

  public void setCategories(List<CategoryDTO> categories) {
    this.categories = categories;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public void setUpdated(LocalDateTime updated) {
    this.updated = updated;
  }

  public String getAllCategories() {
    return categories.stream().map(el -> el.getName()).collect(Collectors.joining(","));
  }

  public String getShortenContent() {
    return (this.content.length() > 200) ? this.content.substring(0, 200) + "..." : this.content;
  }
}
