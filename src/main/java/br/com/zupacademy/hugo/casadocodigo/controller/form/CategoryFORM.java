package br.com.zupacademy.hugo.casadocodigo.controller.form;

import br.com.zupacademy.hugo.casadocodigo.model.Category;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoryFORM {

    @NotNull
    @NotEmpty
    private String name;

    public Category convert() {
        return new Category(this.name);
    }

    public String getName() {
        return name;
    }
}
