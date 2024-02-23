package br.com.dws.book.domain.service;

import br.com.dws.book.domain.Book;
import br.com.dws.book.domain.dto.BookCreateDto;
import br.com.dws.book.domain.dto.BookDto;
import br.com.dws.book.domain.dto.BookUpdateDto;
import br.com.dws.book.domain.repository.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    BookRepository repository;

    public BookDto create(BookCreateDto bookCreateDto) {
        Book newBook = new Book();
        BeanUtils.copyProperties(bookCreateDto, newBook);

        repository.save(newBook);

        return new BookDto(newBook);
    }

    public List<BookDto> getAll() {
        return repository.findAll().stream().map(BookDto::new).toList();
    }

    public void update(UUID id, BookUpdateDto bookUpdateDto) throws Exception {
        Optional<Book> bookOptional = repository.findById(id);

        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();

            if (bookUpdateDto.getIsFavorite() != null) {
                book.setIsFavorite(bookUpdateDto.getIsFavorite());
            }

            if (bookUpdateDto.getIsFinished() != null) {
                book.setIsFinished(bookUpdateDto.getIsFinished());
            }

            if (bookUpdateDto.getIsReading() != null) {
                book.setIsReading(bookUpdateDto.getIsReading());
            }

            repository.save(book);
        } else {
            throw new Exception("Book not found");
        }
    }

    public BookDto findById(UUID id) throws Exception {
        Book book = repository.findById(id).orElseThrow(() -> new Exception("Book not found"));
        return new BookDto(book);
    }


    public void delete(UUID id) throws Exception {
        Book book = repository.findById(id).orElseThrow(() -> new Exception("Book not found"));

        repository.delete(book);
    }
}
