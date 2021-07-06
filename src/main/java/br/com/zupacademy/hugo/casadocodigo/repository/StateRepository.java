package br.com.zupacademy.hugo.casadocodigo.repository;

import br.com.zupacademy.hugo.casadocodigo.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
    State findByName(String state);
}
