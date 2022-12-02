package com.movie.bookmovie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.movie.bookmovie.entities.Movies;

public interface MovieRepository extends CrudRepository<Movies,Integer> {
    
    @Query("select m from Movies m where m.id =:n")
    public List<Movies> findMovieById(@Param("n") int id);

    public List<Movies>  findByShowCycle(String showCycle);
    
}
