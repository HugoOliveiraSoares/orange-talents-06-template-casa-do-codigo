package br.com.zupacademy.hugo.casadocodigo.controller.dto;

import br.com.zupacademy.hugo.casadocodigo.model.Clients;
import org.springframework.data.domain.Page;

public class ClientsDTO {

    private Long id;
    private String email;
    private String name;
    private String lastName;
    private String document;
    private String address;
    private String complement;
    private String city;
    private String country;
    private String state;
    private String phone;
    private String cep;

    public ClientsDTO(Clients clients) {
        this.id = clients.getId();
        this.email = clients.getEmail();
        this.name = clients.getName();
        this.lastName = clients.getLastName();
        this.document = clients.getDocument();
        this.address = clients.getAddress();
        this.complement = clients.getComplement();
        this.city = clients.getCity();
        this.country = clients.getCountry().getName();
        this.state = clients.getState().getName();
        this.phone = clients.getPhone();
        this.cep = clients.getCep();
    }

    public static Page<ClientsDTO> convert(Page<Clients> clients) {
        return clients.map(ClientsDTO::new);
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
