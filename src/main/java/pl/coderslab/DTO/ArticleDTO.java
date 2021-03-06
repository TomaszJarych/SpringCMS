package pl.coderslab.DTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import pl.coderslab.Validator.ArticleIsValid;
import pl.coderslab.Validator.Groups.IsDraft;

@ArticleIsValid(contentMinLength = 500, titleMaxLength = 200, groups=Default.class)
public class ArticleDTO {

  private Long id;

  @NotBlank(groups= {Default.class, IsDraft.class})
  @Size(max = 200,groups= {Default.class, IsDraft.class})
  private String title;
  
  private AuthorDTO author;

  @NotNull(groups=Default.class)
  @NotEmpty(groups=Default.class) 
  private List<CategoryDTO> categories = new ArrayList<>();

  @Size(min = 500, groups= {Default.class, IsDraft.class})
  private String content;

  private LocalDateTime created;

  private LocalDateTime updated;

  @AssertFalse(groups=Default.class)
  @AssertTrue(groups=IsDraft.class)
  private boolean draft;

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

  public ArticleDTO() {

    created = LocalDateTime.now();
  }

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

  public boolean isDraft() {
    return draft;
  }

  public void setDraft(boolean draft) {
    this.draft = draft;
  }

  public String getAllCategories() {
    return categories.stream().map(el -> el.getName()).collect(Collectors.joining(","));
  }

  public String getShortenContent() {
    return (this.content.length() > 200) ? this.content.substring(0, 200) + "..." : this.content;
  }

  @Override
  public String toString() {
    return "ArticleDTO [id="
        + id
        + ", title="
        + title
        + ", author="
        + author
        + ", categories="
        + categories
        + ", content="
        + content
        + ", created="
        + created
        + ", updated="
        + updated
        + "]";
  }
}
