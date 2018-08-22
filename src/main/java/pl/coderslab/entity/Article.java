package pl.coderslab.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", length = 200)
    private String title;

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
	    CascadeType.REFRESH })
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
	    CascadeType.REFRESH })
    @JoinTable(name = "articles_category", joinColumns = {@JoinColumn(name = "article_id")}, inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private List<Category> categories = new ArrayList<>();
    @Column(name = "content")
    private String content;

    private final LocalDateTime created = LocalDateTime.now();

    private LocalDateTime updated;

    public Article(String title, String content) {
	this.title = title;
	this.content = content;
    }

    public Article() {
    }

    public Long getId() {
	return id;
    }

    public String getTitle() {
	return title;
    }

    public Author getAuthor() {
	return author;
    }

    public List<Category> getCategories() {
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

    public void setAuthor(Author author) {
	this.author = author;
    }

    public void setCategories(List<Category> categories) {
	this.categories = categories;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public void setUpdated(LocalDateTime updated) {
	this.updated = updated;
    }

    @Override
    public String toString() {
	return "Article [id=" + id + ", title=" + title + ", author=" + author + ", categories=" + categories
		+ ", content=" + content + ", created=" + created + ", updated=" + updated + "]";
    }

    public void addCategory(Category category) {
	categories.add(category);
    }

}
