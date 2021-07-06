package br.com.zupacademy.hugo.casadocodigo.repository;

import br.com.zupacademy.hugo.casadocodigo.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Long> {

    Clients findByName(String name);

}
