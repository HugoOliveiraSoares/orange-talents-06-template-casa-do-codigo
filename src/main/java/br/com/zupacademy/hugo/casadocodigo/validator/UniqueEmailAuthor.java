package br.com.zupacademy.hugo.casadocodigo.validator;

import br.com.zupacademy.hugo.casadocodigo.controller.form.AuthorFORM;
import br.com.zupacademy.hugo.casadocodigo.model.Author;
import br.com.zupacademy.hugo.casadocodigo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UniqueEmailAuthor implements Validator {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AuthorFORM.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors())
            return;

        AuthorFORM authorFORM = (AuthorFORM) target;
        Optional<Author> possibleAuthor = authorRepository.findByEmail(authorFORM.getEmail());

        if (possibleAuthor.isPresent()) {
            errors.rejectValue("email", "Email já cadastrado!");
        }

    }
}
