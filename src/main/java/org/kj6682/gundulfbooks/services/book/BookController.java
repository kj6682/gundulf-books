package org.kj6682.gundulfbooks.services.book;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.Assert.notNull;
import static org.springframework.util.StringUtils.isEmpty;
import static org.springframework.util.Assert.isTrue;

import java.util.LinkedList;
import java.util.List;

@Api(value = "books", description = "Books API")
@RestController("BookController")
@RequestMapping("/api/books/v1.0")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @PostMapping(value = "/")
    ResponseEntity<?> create(@RequestBody Book book) {

        notNull(book, "The record can not be empty");
        isTrue(!isEmpty(book.getTitle()), "a book needs a title");
        isTrue(!isEmpty(book.getAuthor()), "a book needs at least one author");


        book.setTitle(book.getTitle().toLowerCase().trim());

        Book result = bookRepository.save(book);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/")
    void delete(@RequestParam(required = true) Long id) {

        notNull(id,"id must be not null");
        isTrue(id >=0, "id must be positive");

        bookRepository.deleteById(id);
    }

    private static class BookNotFoundException extends RuntimeException {
        BookNotFoundException(String id) {
            super("could not find product '" + id + "'.");
        }
    }

    @ControllerAdvice
    private static class BookControllerAdvice {

        @ResponseBody
        @ExceptionHandler(BookNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public List<Book> handleConflict() {
            return new LinkedList<>();
        }


        @ResponseBody
        @ExceptionHandler(java.lang.IllegalArgumentException.class)
        public ResponseEntity<?> handleConflictIllegalArgument() {
            return new ResponseEntity<>("Illegal Arguments", HttpStatus.FORBIDDEN);
        }

    }

}

