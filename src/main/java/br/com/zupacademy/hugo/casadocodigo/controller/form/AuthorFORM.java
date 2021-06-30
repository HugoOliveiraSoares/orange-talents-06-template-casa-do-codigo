package br.com.zupacademy.hugo.casadocodigo.controller.form;

import br.com.zupacademy.hugo.casadocodigo.model.Author;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AuthorFORM {

    @NotNull
    @NotEmpty
    private String name;
    @NotNull @NotEmpty @Email
    private String email;
    @NotNull @NotEmpty @Size(max = 400)
    private String description;

    public Author convert() {
        return new Author(this.name, this.email, this.description);
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
