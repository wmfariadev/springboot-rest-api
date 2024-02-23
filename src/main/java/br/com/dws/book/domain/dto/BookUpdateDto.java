package br.com.dws.book.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookUpdateDto {
    private Boolean isFavorite;
    private Boolean isReading;
    private Boolean isFinished;
}
