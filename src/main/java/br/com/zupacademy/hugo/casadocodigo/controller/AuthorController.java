package br.com.zupacademy.hugo.casadocodigo.controller;

import br.com.zupacademy.hugo.casadocodigo.controller.dto.AuthorDTO;
import br.com.zupacademy.hugo.casadocodigo.controller.form.AuthorFORM;
import br.com.zupacademy.hugo.casadocodigo.model.Author;
import br.com.zupacademy.hugo.casadocodigo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public Page<AuthorDTO> list(Pageable pages){

        Page<Author> authors = authorRepository.findAll(pages);

        return AuthorDTO.convert(authors);
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> register(@RequestBody @Valid AuthorFORM authorFORM, UriComponentsBuilder uriComponentsBuilder){

        Author author = authorFORM.convert(authorFORM);
        authorRepository.save(author);

        URI uri = uriComponentsBuilder.path("author/{id}").buildAndExpand(author.getId()).toUri();
        return ResponseEntity.created(uri).body(new AuthorDTO(author));

    }

}
