package br.com.zupacademy.hugo.casadocodigo.controller.form;

import br.com.zupacademy.hugo.casadocodigo.model.Category;
import br.com.zupacademy.hugo.casadocodigo.validator.Unique;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoryFORM {

    @NotNull
    @NotEmpty
    @Unique(domainClass = Category.class, fieldName = "name", message = "Já existe uma categoria com esse nome")
    private String name;

    public Category convert() {
        return new Category(this.name);
    }

    public String getName() {
        return name;
    }
}
