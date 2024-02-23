package br.com.dws.book.domain.dto;

import br.com.dws.book.domain.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BookDto {
    private UUID id;
    private String title;
    private String author;
    private String description;
    private Boolean isFavorite;
    private Boolean isReading;
    private Boolean isFinished;

    public BookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.description = book.getDescription();
        this.isFavorite = book.getIsFavorite();
        this.isReading = book.getIsReading();
        this.isFinished = book.getIsFinished();
    }
}
