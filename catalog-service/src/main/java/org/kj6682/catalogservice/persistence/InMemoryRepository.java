package org.kj6682.catalogservice.persistence;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.kj6682.catalogservice.domain.Book;
import org.kj6682.catalogservice.domain.BookRepository;

public class InMemoryRepository implements BookRepository{
    
    private final static Map<String, Book> books = new ConcurrentHashMap<>();

    @Override
    public void deleteByIsbn(String isbn) {
        books.remove(isbn);
        
    }

    @Override
    public boolean existsByIsbn(String isbn) {
        return books.get(isbn) != null;
    }

    @Override
    public Iterable<Book> findAll() {
        return books.values();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return existsByIsbn(isbn)?Optional.of(books.get(isbn)):Optional.empty();
    }

    @Override
    public Book save(Book book) {
        books.put(book.isbn(), book);
        return book;
    }

}
