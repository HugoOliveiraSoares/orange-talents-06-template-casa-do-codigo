package br.com.zupacademy.hugo.casadocodigo.controller.dto;

import br.com.zupacademy.hugo.casadocodigo.model.Book;
import org.springframework.data.domain.Page;

public class BookDTO {

    private Long id;
    private String title;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
    }

    public static Page<BookDTO> convert(Page<Book> books) {
        return books.map(BookDTO::new);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
