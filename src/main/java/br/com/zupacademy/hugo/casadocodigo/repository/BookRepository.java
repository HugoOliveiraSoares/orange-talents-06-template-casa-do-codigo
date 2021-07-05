package br.com.zupacademy.hugo.casadocodigo.repository;

import br.com.zupacademy.hugo.casadocodigo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {



}
