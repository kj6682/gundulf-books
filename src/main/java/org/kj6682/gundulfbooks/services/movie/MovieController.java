package org.kj6682.gundulfbooks.services.movie;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;
import static org.springframework.util.StringUtils.isEmpty;

@CrossOrigin(origins = {"http://localhost:3000"})
@Api(value = "movies", description = "Movies API")
@RestController("MovieController")
@RequestMapping("/api/movies/v1.0")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/")
    List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @PostMapping(value = "/")
    ResponseEntity<?> create(@RequestBody Movie movie) {

        notNull(movie, "The record can not be empty");
        isTrue(!isEmpty(movie.getTitle()), "a movie needs a title");
        isTrue(!isEmpty(movie.getAuthor()), "a movie needs at least one author");


        movie.setTitle(movie.getTitle().toLowerCase().trim());

        Movie result = movieRepository.save(movie);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/")
    void delete(@RequestParam(required = true) Long id) {

        notNull(id,"id must be not null");
        isTrue(id >=0, "id must be positive");

        movieRepository.deleteById(id);
    }

    private static class MovieNotFoundException extends RuntimeException {
        MovieNotFoundException(String id) {
            super("could not find product '" + id + "'.");
        }
    }

    @ControllerAdvice
    private static class MovieControllerAdvice {

        @ResponseBody
        @ExceptionHandler(MovieNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public List<Movie> handleConflict() {
            return new LinkedList<>();
        }


        @ResponseBody
        @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<?> handleConflictIllegalArgument() {
            return new ResponseEntity<>("Illegal Arguments", HttpStatus.FORBIDDEN);
        }

    }

}

