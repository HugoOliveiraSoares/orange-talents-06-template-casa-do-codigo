package br.com.zupacademy.hugo.casadocodigo.controller;

import br.com.zupacademy.hugo.casadocodigo.controller.dto.StateDTO;
import br.com.zupacademy.hugo.casadocodigo.controller.form.StateFORM;
import br.com.zupacademy.hugo.casadocodigo.model.State;
import br.com.zupacademy.hugo.casadocodigo.repository.CountryRepository;
import br.com.zupacademy.hugo.casadocodigo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public Page<StateDTO> list(Pageable pages){

        Page<State> states = stateRepository.findAll(pages);

        return StateDTO.convert(states);
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid StateFORM stateFORM){

        State state = stateFORM.convert(countryRepository);

        stateRepository.save(state);

        return ResponseEntity.ok().build();

    }

}
