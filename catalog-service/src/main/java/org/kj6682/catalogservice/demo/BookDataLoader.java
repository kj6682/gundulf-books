package org.kj6682.catalogservice.demo;

import org.kj6682.catalogservice.domain.Book;
import org.kj6682.catalogservice.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

@Component
@Profile("testdata")
public class BookDataLoader {
    private final BookRepository repository;

    public BookDataLoader(BookRepository repository) {
        this.repository = repository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBooks(){

        IntStream.range(0, 100).boxed().forEach(i -> {
            var book = new Book("123456789"+i, "title"+i, "author"+i, i.doubleValue());
            repository.save(book);
        });

    }
}
