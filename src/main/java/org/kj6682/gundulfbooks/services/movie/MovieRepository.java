package org.kj6682.gundulfbooks.services.movie;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Qualifier("MovieRepository")
public interface Repository extends CrudRepository<Movie, Long> {

    List<Movie> findAll();


}
