package br.com.zupacademy.hugo.casadocodigo.controller.form;

import br.com.zupacademy.hugo.casadocodigo.model.Country;
import br.com.zupacademy.hugo.casadocodigo.model.State;
import br.com.zupacademy.hugo.casadocodigo.repository.CountryRepository;
import br.com.zupacademy.hugo.casadocodigo.validator.Unique;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class StateFORM {

    @NotNull @NotEmpty @Unique(domainClass = State.class, fieldName = "name")
    private String name;
    @NotNull @NotEmpty
    private String country;

    public StateFORM(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public State convert(CountryRepository countryRepository) {

        Country country = countryRepository.findByName(this.country);

        return new State(this.name, country);

    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
