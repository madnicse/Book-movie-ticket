package com.movie.bookmovie.dao;

import org.springframework.data.repository.CrudRepository;

import com.movie.bookmovie.entities.Cinema;

public interface CinemaRepository extends CrudRepository<Cinema,Integer> {
    
}
