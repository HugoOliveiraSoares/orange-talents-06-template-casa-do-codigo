package br.com.zupacademy.hugo.casadocodigo.controller;

import br.com.zupacademy.hugo.casadocodigo.controller.dto.ClientsDTO;
import br.com.zupacademy.hugo.casadocodigo.controller.form.ClientsFORM;
import br.com.zupacademy.hugo.casadocodigo.model.Clients;
import br.com.zupacademy.hugo.casadocodigo.repository.ClientsRepository;
import br.com.zupacademy.hugo.casadocodigo.repository.CountryRepository;
import br.com.zupacademy.hugo.casadocodigo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private ClientsRepository clientsRepository;

    @GetMapping
    public Page<ClientsDTO> list(Pageable pages){

        Page<Clients> clients = clientsRepository.findAll(pages);

        return ClientsDTO.convert(clients);

    }

    @PostMapping
    public ResponseEntity<Long> register(@RequestBody @Valid ClientsFORM clientsFORM){

        Clients clients = clientsFORM.convert(countryRepository, stateRepository);

        clientsRepository.save(clients);

        return ResponseEntity.ok().body(new ClientsDTO(clients).getId());
    }

}
