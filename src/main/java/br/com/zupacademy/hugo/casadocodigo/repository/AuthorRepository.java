package br.com.zupacademy.hugo.casadocodigo.repository;

import br.com.zupacademy.hugo.casadocodigo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByEmail(String email);
    Author findByName(String name);
}
