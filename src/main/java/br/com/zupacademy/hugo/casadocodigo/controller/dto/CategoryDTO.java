package br.com.zupacademy.hugo.casadocodigo.controller.dto;

import br.com.zupacademy.hugo.casadocodigo.model.Category;
import org.springframework.data.domain.Page;

public class CategoryDTO {

    private String name;

    public CategoryDTO(Category category) {
        this.name = category.getName();
    }

    public static Page<CategoryDTO> convert(Page<Category> category){
        return category.map(CategoryDTO::new);
    }

    public String getName() {
        return name;
    }
}
