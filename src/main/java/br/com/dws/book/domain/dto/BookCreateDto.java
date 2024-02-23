package br.com.dws.book.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookCreateDto {
    private String title;
    private String author;
    private String description;
}
