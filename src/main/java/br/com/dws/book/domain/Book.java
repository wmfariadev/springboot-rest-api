package br.com.dws.book.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "books", schema = "public")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String author;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Boolean isFavorite = false;
    private Boolean isReading = false;
    private Boolean isFinished = false;
}
