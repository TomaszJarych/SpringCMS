package pl.coderslab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {}
