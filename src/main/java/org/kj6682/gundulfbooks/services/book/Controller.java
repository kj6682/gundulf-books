package org.kj6682.gundulfbooks.services.book;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "orders", description = "Orders API")
@RestController("BookController")
@RequestMapping("/api/books/v1.0")
public class Controller {

    @Autowired
    private Repository repository;

    @GetMapping("/")
    List<Book> getBooks() {
        return repository.findAll();
    }

}

