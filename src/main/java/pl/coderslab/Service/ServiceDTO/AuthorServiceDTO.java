package pl.coderslab.Service.ServiceDTO;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pl.coderslab.DAO.AuthorDAO;
import pl.coderslab.DTO.AuthorDTO;
import pl.coderslab.entity.Author;

@Service
public class AuthorServiceDTO {

  AuthorDAO dao;

  public AuthorServiceDTO(AuthorDAO dao) {
    this.dao = dao;
  }

  public AuthorDTO addAuthor(AuthorDTO dto) {
    Author author = toEntity(dto);
    return dao.addAuthor(author).toDto();
  }

  public AuthorDTO getAuthorByID(Long id) {
    return dao.getAuthorByID(id).toDto();
  }

  public AuthorDTO updateAuthor(AuthorDTO dto) {
    Author author = toEntity(dto);
    dao.updateAuthor(author);
    return author.toDto();
  }

  public void deleteAuthor(Long id) {
      
    dao.deleteAuthor(dao.getAuthorByID(id));
  }

  public Collection<AuthorDTO> getAuthors() {

    return dao.getAuthors().stream().map(Author::toDto).collect(Collectors.toList());
  }

  private Author toEntity(AuthorDTO dto) {
    Author author;
    if (dto.getId() == null) {
      author = new Author(dto.getFirstName(), dto.getLastName());
    } else {
      author = dao.getAuthorByID(dto.getId());
      author.setFirstName(dto.getFirstName());
      author.setLastName(dto.getLastName());
    }
    return author;
  }
}
