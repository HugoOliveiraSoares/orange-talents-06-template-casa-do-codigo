package br.com.zupacademy.hugo.casadocodigo.controller.dto;

import br.com.zupacademy.hugo.casadocodigo.model.Country;
import org.springframework.data.domain.Page;

public class CountryDTO {

    private String name;

    public CountryDTO(Country country) {
        this.name = country.getName();
    }

    public static Page<CountryDTO> convert(Page<Country> countries) {
        return countries.map(CountryDTO::new);
    }

    public String getName() {
        return name;
    }
}
