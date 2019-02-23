package org.kj6682.gundulfbooks.services.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.IOException;

@Configuration
public class BookConfig {

    @Profile({"h2"})
    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            repository.save(new Book("the Hobbit", "J.R.Tolkien", "fantasy"));
            repository.save(new Book("1984", "George Orwell", "science fiction"));
        };
    }
}
