package pl.coderslab.DAO;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Author;

@Component
@Transactional
public class AuthorDAO {

  @PersistenceContext private EntityManager entityManager;

  public Author addAuthor(Author author) {
    entityManager.persist(author);
    return author;
  }

  public Author getAuthorByID(Long id) {
    return entityManager.find(Author.class, id);
  }

  public void updateAuthor(Author author) {
    entityManager.merge(author);
  }

  public void deleteAuthor(Author author) {
    entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
  }

  public Collection<Author> getAuthors() {
    return entityManager.createQuery("SELECT a FROM Author a").getResultList();
  }
}
