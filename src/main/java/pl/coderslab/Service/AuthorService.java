package pl.coderslab.Service;

import org.springframework.stereotype.Service;

import pl.coderslab.DAO.AuthorDAO;
import pl.coderslab.entity.Author;

@Service
public class AuthorService {

    AuthorDAO dao;

    public AuthorService(AuthorDAO dao) {
	this.dao = dao;
    }

    public Author addAuthor(Author author) {
	dao.addAuthor(author);
	return author;
    }

    public Author getAuthorByID(Long id) {
	return dao.getAuthorByID(id);
    }

    public void updateAuthor(Author author) {
	dao.updateAuthor(author);
    }

    public void deleteAuthor(Author author) {
	dao.deleteAuthor(author);
    }
}
