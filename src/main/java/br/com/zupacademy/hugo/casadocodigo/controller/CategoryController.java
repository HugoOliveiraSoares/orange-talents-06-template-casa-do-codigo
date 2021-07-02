package br.com.zupacademy.hugo.casadocodigo.controller;

import br.com.zupacademy.hugo.casadocodigo.controller.dto.CategoryDTO;
import br.com.zupacademy.hugo.casadocodigo.controller.form.CategoryFORM;
import br.com.zupacademy.hugo.casadocodigo.model.Category;
import br.com.zupacademy.hugo.casadocodigo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public Page<CategoryDTO> list(Pageable pages){

        Page<Category> categories = categoryRepository.findAll(pages);

        return CategoryDTO.convert(categories);

    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid CategoryFORM categoryFORM){

        Category category = categoryFORM.convert();
        categoryRepository.save(category);

        return ResponseEntity.ok().build();
    }

}
