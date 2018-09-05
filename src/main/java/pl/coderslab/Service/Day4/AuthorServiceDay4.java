package pl.coderslab.Service.Day4;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.DTO.AuthorDTO;
import pl.coderslab.Repository.AuthorRepository;
import pl.coderslab.entity.Author;

@Service
public class AuthorServiceDay4 {

  private final AuthorRepository authorRepository;

  @Autowired
  public AuthorServiceDay4(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public AuthorDTO addAuthor(AuthorDTO dto) {
    Author author = toEntity(dto);
    return authorRepository.save(author).toDto();
  }

  public AuthorDTO getAuthorByID(Long id) {
    return authorRepository.findOne(id).toDto();
  }

  public AuthorDTO updateAuthor(AuthorDTO dto) {
    Author author = toEntity(dto);
    return authorRepository.save(author).toDto();
  }

  public void deleteAuthor(Long id) {

    authorRepository.delete(id);
  }

  public Collection<AuthorDTO> getAuthors() {

    return authorRepository.findAll().stream().map(Author::toDto).collect(Collectors.toList());
  }

  private Author toEntity(AuthorDTO dto) {
    Author author;
    if (dto.getId() == null) {
      author = new Author(dto.getFirstName(), dto.getLastName());
    } else {
      author = authorRepository.findOne(dto.getId());
      author.setFirstName(dto.getFirstName());
      author.setLastName(dto.getLastName());
    }
    return author;
  }
}
