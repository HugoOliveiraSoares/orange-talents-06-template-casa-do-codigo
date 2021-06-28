package br.com.zupacademy.hugo.casadocodigo.controller.dto;

import br.com.zupacademy.hugo.casadocodigo.model.Author;
import org.springframework.data.domain.Page;

public class AuthorDTO {

    private Long id;
    private String name;
    private String email;
    private String description;

    public AuthorDTO(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.email = author.getEmail();
        this.description = author.getDescription();
    }

    public static Page<AuthorDTO> convert(Page<Author> authors){
        return authors.map(AuthorDTO::new);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
