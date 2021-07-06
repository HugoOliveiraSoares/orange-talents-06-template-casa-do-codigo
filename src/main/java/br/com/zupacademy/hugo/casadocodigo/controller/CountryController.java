package br.com.zupacademy.hugo.casadocodigo.controller;

import br.com.zupacademy.hugo.casadocodigo.controller.dto.CountryDTO;
import br.com.zupacademy.hugo.casadocodigo.controller.form.CountryFORM;
import br.com.zupacademy.hugo.casadocodigo.model.Country;
import br.com.zupacademy.hugo.casadocodigo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public Page<CountryDTO> list(Pageable pages){

        Page<Country> countries = countryRepository.findAll(pages);

        return CountryDTO.convert(countries);
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid CountryFORM countryFORM){

        Country country = countryFORM.convert();

        countryRepository.save(country);

        return ResponseEntity.ok().build();

    }

}
