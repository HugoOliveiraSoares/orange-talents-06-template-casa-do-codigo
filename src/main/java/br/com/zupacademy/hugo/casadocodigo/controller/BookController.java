package br.com.zupacademy.hugo.casadocodigo.controller;

import br.com.zupacademy.hugo.casadocodigo.controller.dto.BookDTO;
import br.com.zupacademy.hugo.casadocodigo.controller.dto.BookDetailDTO;
import br.com.zupacademy.hugo.casadocodigo.controller.form.BookFORM;
import br.com.zupacademy.hugo.casadocodigo.model.Book;
import br.com.zupacademy.hugo.casadocodigo.repository.AuthorRepository;
import br.com.zupacademy.hugo.casadocodigo.repository.BookRepository;
import br.com.zupacademy.hugo.casadocodigo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public Page<BookDTO> listAll(Pageable pages){

        Page<Book> books = bookRepository.findAll(pages);

        return BookDTO.convert(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDetailDTO> detail(@PathVariable Long id){

        Optional<Book> book = bookRepository.findById(id);

        if (book.isPresent())
            return ResponseEntity.ok( new BookDetailDTO(book.get()) );

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid BookFORM bookFORM){

        Book book = bookFORM.convert(categoryRepository, authorRepository);
        bookRepository.save(book);

        return ResponseEntity.ok().build();
    }

}
