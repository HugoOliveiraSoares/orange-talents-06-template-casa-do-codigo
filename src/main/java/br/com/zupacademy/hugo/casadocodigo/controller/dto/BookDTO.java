package br.com.zupacademy.hugo.casadocodigo.controller.dto;

import br.com.zupacademy.hugo.casadocodigo.model.Author;
import br.com.zupacademy.hugo.casadocodigo.model.Book;
import br.com.zupacademy.hugo.casadocodigo.model.Category;
import org.springframework.data.domain.Page;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class BookDTO {

    private String title;
    private String description;
    private String summary;
    private float price;
    private int numberPages;
    private String isbn;
    private LocalDate releaseDate;
    private List<Category> categories;
    private Author author;

    public BookDTO(Book book) {
        this.title = book.getTitle();
        this.description = book.getDescription();
        this.summary = book.getSummary();
        this.price = book.getPrice();
        this.numberPages = book.getNumberPages();
        this.isbn = book.getIsbn();
        this.releaseDate = book.getReleaseDate();
        this.categories = book.getCategory();
        this.author = book.getAuthor();
    }

    public static Page<BookDTO> convert(Page<Book> books) {
        return books.map(BookDTO::new);
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

    public @NotNull @Min(20) float getPrice() {
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

    public List<Category> getCategories() {
        return categories;
    }

    public Author getAuthor() {
        return author;
    }
}
