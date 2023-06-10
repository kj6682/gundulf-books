package org.kj6682.catalogservice.demo;

import org.kj6682.catalogservice.domain.Book;
import org.kj6682.catalogservice.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("testdata")
public class BookDataLoader {
    private final BookRepository repository;

    public BookDataLoader(BookRepository repository) {
        this.repository = repository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBooks(){
        var book1 = new Book("1234567890", "1984", "George Orwell", 1.0);
        var book2 = new Book("1234567891", "Atado y bien atado", "Rubén Uceda", 15.0);

        repository.save(book1);
        repository.save(book2);
    }
}
