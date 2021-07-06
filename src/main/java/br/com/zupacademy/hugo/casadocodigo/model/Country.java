package br.com.zupacademy.hugo.casadocodigo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotNull @NotEmpty
    private String name;

    @Deprecated
    public Country() {
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
