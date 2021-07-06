package br.com.zupacademy.hugo.casadocodigo.controller.form;

import br.com.zupacademy.hugo.casadocodigo.model.Country;
import br.com.zupacademy.hugo.casadocodigo.validator.Unique;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CountryFORM {

    @NotNull @NotEmpty @Unique(domainClass = Country.class, fieldName = "name")
    private String name;

    public Country convert() {

        return new Country(this.name);

    }

    public String getName() {
        return name;
    }
}
