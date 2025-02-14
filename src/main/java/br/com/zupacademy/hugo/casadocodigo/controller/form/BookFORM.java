package br.com.zupacademy.hugo.casadocodigo.controller.form;

import br.com.zupacademy.hugo.casadocodigo.model.Author;
import br.com.zupacademy.hugo.casadocodigo.model.Book;
import br.com.zupacademy.hugo.casadocodigo.model.Category;
import br.com.zupacademy.hugo.casadocodigo.repository.AuthorRepository;
import br.com.zupacademy.hugo.casadocodigo.repository.CategoryRepository;
import br.com.zupacademy.hugo.casadocodigo.validator.Unique;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookFORM {

    @NotNull
    @NotEmpty @Unique(domainClass = Book.class, fieldName = "title", message = "Titulo já cadastrado!")
    private String title;
    @NotNull @NotEmpty @Length(max = 500)
    private String description;
    private String summary;
    @NotNull @Min(20)
    private float price;
    @NotNull @Min(100)
    private int numberPages;
    @NotNull @NotEmpty @Unique(domainClass = Book.class, fieldName = "isbn", message = "ISBN já cadastrado!")
    private String isbn;
    @NotNull @Future @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate releaseDate;
    @NotNull @NotEmpty
    private List<String> nameCategory;
    @NotNull @NotEmpty
    private String nameAuthor;


    public Book convert(CategoryRepository categoryRepository, AuthorRepository authorRepository) {

        List<Category> categories = new ArrayList<>();

        for (String category: nameCategory) {
            categories.add( categoryRepository.findByName(category) );
        }

        Author author = authorRepository.findByName(this.nameAuthor);

        return new Book(this.title, this.description, this.summary, this.price, this.numberPages, this.isbn, this.releaseDate, categories, author);

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(List<String> nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }
}
