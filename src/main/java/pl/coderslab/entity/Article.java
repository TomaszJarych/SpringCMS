package pl.coderslab.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

    @OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
	    CascadeType.REFRESH })
    @JoinColumn(name="author_id")
    private Author author;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
	    CascadeType.REFRESH })
    @JoinColumn(name="category_id")
    private List<Category> categories;
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

}
// #### Zadanie 3
//
// 1. Utwórz model `Article`, który będzie przechowywał dane nt. artykułów w
// CMS-ie. Model powinien mieć następujące pola:
// - title (max. 200 znaków),
// - author - (powiązanie relacją do klasy `Author`) - artykuł może mieć tylko
// jednego autora
// - category - (powiązanie relacją do klasy `Author`) - artykuł może należeć do
// wielu kategorii
// - content
// - created (wartość ma być automatycznie dodawana podczas zapisu)
// - updated (wartość ma być automatycznie zmieniana podczas edycji).