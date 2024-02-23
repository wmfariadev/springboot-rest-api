package br.com.dws.book.controllers;

import br.com.dws.book.domain.dto.BookCreateDto;
import br.com.dws.book.domain.dto.BookDto;
import br.com.dws.book.domain.dto.BookUpdateDto;
import br.com.dws.book.domain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService service;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<BookDto> books = service.getAll();
        return ResponseEntity.ok(books);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody BookCreateDto bookCreateDto) {
        BookDto bookDto = service.create(bookCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody BookUpdateDto bookUpdateDto) {

        try {
            service.update(id, bookUpdateDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable UUID id) {
        try {
            BookDto bookDto = service.findById(id);
            return ResponseEntity.ok().body(bookDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
