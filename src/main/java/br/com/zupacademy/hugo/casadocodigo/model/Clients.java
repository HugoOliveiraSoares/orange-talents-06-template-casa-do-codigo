package br.com.zupacademy.hugo.casadocodigo.model;

import br.com.zupacademy.hugo.casadocodigo.validator.CPForCNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotEmpty @Email
    private String email;
    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty
    private String lastName;
    @NotNull @NotEmpty @CPForCNPJ
    private String document;
    @NotNull @NotEmpty
    private String address;
    @NotNull @NotEmpty
    private String complement;
    @NotNull @NotEmpty
    private String city;
    @NotNull @OneToOne
    private Country country;
    @NotNull @OneToOne
    private State state;
    @NotNull @NotEmpty
    private String phone;
    @NotNull @NotEmpty
    private String cep;

    @Deprecated
    public Clients() {
    }

    public Clients(@Valid String email, String name, String lastName, String document, String address, String complement, String city, Country country, State state, String phone, String cep) {
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

    public Long getId() {
        return id;
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

    public Country getCountry() {
        return country;
    }

    public State getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }
}
