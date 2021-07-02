package br.com.zupacademy.hugo.casadocodigo.validator;

import br.com.zupacademy.hugo.casadocodigo.controller.form.CategoryFORM;
import br.com.zupacademy.hugo.casadocodigo.model.Category;
import br.com.zupacademy.hugo.casadocodigo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UniqueCategory implements Validator {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoryFORM.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (errors.hasErrors())
            return;

        CategoryFORM categoryFORM = (CategoryFORM) target;
        Optional<Category> possibleCategory = categoryRepository.findByName(categoryFORM.getName());

        if (possibleCategory.isPresent()){
            errors.rejectValue("name", "Categoria ja cadastrada!");
        }
    }
}
