package br.com.zupacademy.hugo.casadocodigo.repository;

import br.com.zupacademy.hugo.casadocodigo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
