package br.com.zupacademy.hugo.casadocodigo.controller.dto;


import br.com.zupacademy.hugo.casadocodigo.model.Book;
import br.com.zupacademy.hugo.casadocodigo.model.Category;
import java.time.LocalDate;
import java.util.List;

public class BookDetailDTO {

    private String title;
    private String description;
    private float price;
    private String summary;
    private List<Category> category;
    private String author;
    private LocalDate releaseDate;
    private int numberPages;
    private String isbn;

    public BookDetailDTO(Book book) {
        this.title = book.getTitle();
        this.description = book.getDescription();
        this.price = book.getPrice();
        this.summary = book.getSummary();
        this.category = book.getCategory();
        this.author = book.getAuthor().getName();
        this.releaseDate = book.getReleaseDate();
        this.numberPages = book.getNumberPages();
        this.isbn = book.getIsbn();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public String getSummary() {
        return summary;
    }

    public List<Category> getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public String getIsbn() {
        return isbn;
    }
}
