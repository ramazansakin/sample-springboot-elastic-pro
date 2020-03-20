package com.sakinramazan.elastic.service;

import com.sakinramazan.elastic.model.Movie;
import com.sakinramazan.elastic.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sakinramazan.elastic.model.Director;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getByName(String name) {
        return movieRepository.findByName(name);
    }

    public List<Movie> getByRatingInterval(Double start, Double end) {
        return movieRepository.findByRatingBetween(start, end);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public List<Movie> findByDirector(Director director) {
        return movieRepository.findByDirector(director);
    }

}
