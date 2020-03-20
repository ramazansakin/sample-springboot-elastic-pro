package com.sakinramazan.elastic.api;

import com.sakinramazan.elastic.model.Movie;
import com.sakinramazan.elastic.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movie/add")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie newMovie) {
        Movie savedMovie = movieService.addMovie(newMovie);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedMovie.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/movie/{id}/delete")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long movieId) {
        movieService.deleteMovie(movieId);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/movie/get-by-name/{name}")
    public ResponseEntity<List<Movie>> findMovieByName(@PathVariable("name") String movieName) {
        List<Movie> fetchedMovie = movieService.getByName(movieName);
        return ResponseEntity.ok(fetchedMovie);
    }
}
