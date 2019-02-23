package org.kj6682.gundulfbooks.services.movie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MovieConfig {

    @Profile({"h2"})
    @Bean
    CommandLineRunner initMovieDatabase(MovieRepository repository) {
        return args -> {
            repository.save(new Movie("the big Lebonwski", "Choen Bros.", "comedy"));
            repository.save(new Movie("la vita è bella", "Roberto Benigni", "comedy"));
        };
    }
}
