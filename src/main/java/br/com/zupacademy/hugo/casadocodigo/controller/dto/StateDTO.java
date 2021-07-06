package br.com.zupacademy.hugo.casadocodigo.controller.dto;

import br.com.zupacademy.hugo.casadocodigo.model.Country;
import br.com.zupacademy.hugo.casadocodigo.model.State;
import org.springframework.data.domain.Page;

public class StateDTO {

    private String name;
    private String coutry;

    public StateDTO(State state) {
        this.name = state.getName();
        this.coutry = state.getCountry().getName();
    }

    public static Page<StateDTO> convert(Page<State> states) {
        return states.map(StateDTO::new);
    }


    public String getName() {
        return name;
    }

    public String getCoutry() {
        return coutry;
    }
}
