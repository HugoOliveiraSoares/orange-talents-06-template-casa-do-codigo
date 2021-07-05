package br.com.zupacademy.hugo.casadocodigo.controller.form;

import br.com.zupacademy.hugo.casadocodigo.model.Author;
import br.com.zupacademy.hugo.casadocodigo.model.Book;
import br.com.zupacademy.hugo.casadocodigo.model.Category;
import br.com.zupacademy.hugo.casadocodigo.repository.AuthorRepository;
import br.com.zupacademy.hugo.casadocodigo.repository.CategoryRepository;
import br.com.zupacademy.hugo.casadocodigo.validator.Unique;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class BookFORM {

    @NotNull
    @NotEmpty @Unique(domainClass = Book.class, fieldName = "title", message = "Titulo já cadastrado!")
    private String title;
    @NotNull @NotEmpty @Length(max = 500)
    private String description;
    private String summary;
    @NotNull @DecimalMin("20")
    private int price;
    @NotNull @DecimalMin("100")
    private int numberPages;
    @NotNull @NotEmpty @Unique(domainClass = Book.class, fieldName = "isbn", message = "ISBN já cadastrado!")
    private String isbn;
    @NotNull @Future
    private LocalDate releaseDate;
    @NotNull @NotEmpty
    private String nameCategory;
    @NotNull @NotEmpty
    private String nameAuthor;


    public Book convert(CategoryRepository categoryRepository, AuthorRepository authorRepository) {

        Category category = categoryRepository.findByName(this.nameCategory);
        Author author = authorRepository.findByName(this.nameAuthor);

        return new Book(this.title, this.description, this.summary, this.price, this.numberPages, this.isbn, this.releaseDate, category, author);

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

    public int getPrice() {
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

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }
}
