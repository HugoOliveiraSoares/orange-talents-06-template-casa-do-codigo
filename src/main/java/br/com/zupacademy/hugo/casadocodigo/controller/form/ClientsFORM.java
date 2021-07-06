package br.com.zupacademy.hugo.casadocodigo.controller.form;

import br.com.zupacademy.hugo.casadocodigo.model.Clients;
import br.com.zupacademy.hugo.casadocodigo.model.Country;
import br.com.zupacademy.hugo.casadocodigo.model.State;
import br.com.zupacademy.hugo.casadocodigo.repository.CountryRepository;
import br.com.zupacademy.hugo.casadocodigo.repository.StateRepository;
import br.com.zupacademy.hugo.casadocodigo.validator.CPForCNPJ;
import br.com.zupacademy.hugo.casadocodigo.validator.Unique;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClientsFORM {

    @NotNull @NotEmpty @Email @Unique(domainClass = Clients.class, fieldName = "email")
    private String email;
    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty
    private String lastName;
    @NotNull @NotEmpty @CPForCNPJ
    @Unique(domainClass = Clients.class, fieldName = "document")
    private String document;
    @NotNull @NotEmpty
    private String address;
    @NotNull @NotEmpty
    private String complement;
    @NotNull @NotEmpty
    private String city;
    @NotNull @NotEmpty
    private String country;
    @NotNull @NotEmpty
    private String state;
    @NotNull @NotEmpty
    private String phone;
    @NotNull @NotEmpty
    private String cep;

    public ClientsFORM(String email, String name, String lastName, String document, String address, String complement, String city, String country, String state, String phone, String cep) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.country = country;
        this.state = state;
        this.phone = phone;
        this.cep = cep;
    }

    public Clients convert(CountryRepository countryRepository, StateRepository stateRepository){

        Country country = countryRepository.findByName(this.country);
        State state = stateRepository.findByName(this.state);

        return new Clients(this.email, this.name, this.lastName, this.document, this.address, this.complement, this.city, country, state, this.phone, this.cep);
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }
}
