package com.sakinramazan.elastic.repository;

import com.sakinramazan.elastic.model.Director;
import com.sakinramazan.elastic.model.Movie;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends ElasticsearchRepository<Movie, Long> {

    List<Movie> findByName(String name);

    List<Movie> findByRatingBetween(Double start, Double end);

    List<Movie> findByDirector(Director director);
}
