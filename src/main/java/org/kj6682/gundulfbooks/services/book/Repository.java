package org.kj6682.gundulfbooks.services.book;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Repository extends CrudRepository<Book, Long> {
    List<Book> findAll();
}
