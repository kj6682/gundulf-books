package org.kj6682.catalogservice.domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.assertj.core.api.Assertions.fail;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    
    @Mock
    private BookRepository repository;

    @InjectMocks
    private BookService service;

    @Test
    void when_book_to_be_inserted_already_exist__then_throws(){
        var isbn = "1234567890";
        var book = new Book(isbn, "title", "author", 10.00);
        when(repository.existsByIsbn(isbn)).thenReturn(true);

        assertThatThrownBy(()-> service.addBookToCatalog(book))
            .isInstanceOf(BookAlreadyExistsException.class)
            .hasMessage("A book with ISBN " + isbn + " already exists.");
    }

    @Test
    void when_book_to_be_read_does_not_exist__then_throws(){
        var isbn = "1234567890";
        var book = new Book(isbn, "title", "author", 10.00);
        when(repository.findByIsbn(isbn)).thenReturn(Optional.empty());

        assertThatThrownBy(()-> service.viewBookDetails(isbn))
            .isInstanceOf(BookNotFoundException.class)
            .hasMessage("The book with ISBN " + isbn + " was not found.");
    }

}
