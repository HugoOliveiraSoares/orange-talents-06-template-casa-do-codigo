package br.com.zupacademy.hugo.casadocodigo.model;

import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotNull @NotEmpty
    private String title;
    @NotNull @NotEmpty @Length(max = 500)
    private String description;
    private String summary;
    @NotNull @DecimalMin("20")
    private int price;
    @NotNull @DecimalMin("100")
    private int numberPages;
    @NotNull @NotEmpty
    private String isbn;
    @NotNull @Future
    private LocalDate releaseDate;
    @NotNull @OneToOne
    private Category category;
    @NotNull @OneToOne
    private Author author;

    @Deprecated
    public Book() {
    }

    public Book(@Valid String title, String description, String summary, int price, int numberPages, String isbn, LocalDate releaseDate, Category category, Author author) {
        this.title = title;
        this.description = description;
        this.summary = summary;
        this.price = price;
        this.numberPages = numberPages;
        this.isbn = isbn;
        this.releaseDate = releaseDate;
        this.category = category;
        this.author = author;
    }

    public Long getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSummary() {
        return summary;
    }

    public int getPrice() {
        return price;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }
}
